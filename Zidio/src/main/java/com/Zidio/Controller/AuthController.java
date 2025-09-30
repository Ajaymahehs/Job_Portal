package com.Zidio.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Zidio.DTO.AuthResponse;
import com.Zidio.DTO.ChangePasswordRequest;
import com.Zidio.DTO.ForgotPasswordRequest;
import com.Zidio.DTO.LoginRequest;
import com.Zidio.DTO.LogoutResponse;
import com.Zidio.DTO.RegisterRequest;
import com.Zidio.DTO.ResetPasswordRequest;
import com.Zidio.Entity.User;
import com.Zidio.Repository.UserRepository;
import com.Zidio.Security.JWTUtil;
import com.Zidio.Security.TokenBlacklistService;
import com.Zidio.Service.AuthService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private TokenBlacklistService blacklistService;

	@Autowired
	private JWTUtil jwtUtil;

	
	@PostMapping("/register")
	public ResponseEntity<AuthResponse>register(@RequestBody RegisterRequest request){
		return ResponseEntity.ok(authService.register(request));
	}
	
	@PostMapping("/login")
	public ResponseEntity<AuthResponse>login(@RequestBody LoginRequest request){
		return ResponseEntity.ok(authService.login(request));
	}
	
	@PostMapping("/logout")
	public ResponseEntity<LogoutResponse> logout(HttpServletRequest request) {
	    String authHeader = request.getHeader("Authorization");
	    String token = jwtUtil.extractTokenFromHeader(authHeader);

	    System.out.println("Auth header: " + authHeader);
	    System.out.println("Token extracted: " + token);

	    if (token != null && jwtUtil.validateToken(token)) {
	        blacklistService.blacklistToken(token);
	        String email = jwtUtil.extractUsername(token);
	        User user = userRepository.findByEmail(email)
	        		 .orElseThrow(() -> new RuntimeException("User not found with email: " + email));

	        user.setActive(false);
	        userRepository.save(user);
	        System.out.println("Token blacklisted successfully.");
	        return ResponseEntity.ok(new LogoutResponse("Logout successful."));
	    }

	    System.out.println("Invalid token or null.");
	    return ResponseEntity.badRequest().body(new LogoutResponse("Invalid token."));
	}

	
	@PostMapping("/change-password")
	public ResponseEntity<?> changePassword(
	        @RequestBody ChangePasswordRequest request,
	        Authentication authentication) {

	    authService.changePassword(request, authentication.getName());
	    return ResponseEntity.ok("Password changed successfully");
	}

	
	@PostMapping("/forgot-password")
	public ResponseEntity<String> forgotPassword(@RequestBody ForgotPasswordRequest request) {
	    authService.sendResetLink(request.getEmail());
	    return ResponseEntity.ok("Reset link sent to your email if it exists.");
	}

	@PostMapping("/reset-password")
	public ResponseEntity<String> resetPassword(@RequestBody ResetPasswordRequest request) {
	    boolean success = authService.resetPassword(request.getToken(), request.getNewPassword());
	    return success ?
	        ResponseEntity.ok("Password reset successful.") :
	        ResponseEntity.badRequest().body("Invalid or expired token.");
	}
	
	@GetMapping("/internal/count")
	public ResponseEntity<Long> getUserCount() {
	    return ResponseEntity.ok(authService.getUserCount());
	}

}

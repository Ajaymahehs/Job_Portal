package com.Zidio.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.mail.SimpleMailMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Zidio.DTO.AuthResponse;
import com.Zidio.DTO.ChangePasswordRequest;
import com.Zidio.DTO.LoginRequest;
import com.Zidio.DTO.RegisterRequest;
import com.Zidio.Entity.User;
import com.Zidio.Repository.UserRepository;
import com.Zidio.Security.JWTUtil;

@Service
public class AuthService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private JavaMailSender mailSender;

    public AuthResponse register(RegisterRequest request) {
        User user = new User();
        user.setId(request.getId());
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword())); // encrypt password
        user.setRole(request.getRole());

        userRepository.save(user);

        String token = jwtUtil.generateToken(user.getEmail(), user.getRole());
        return new AuthResponse(token, user.getRole(), user.getEmail());
    }

    public AuthResponse login(LoginRequest request) {
    	User user = userRepository.findByEmail(request.email)
    	        .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        if (user != null && passwordEncoder.matches(request.password, user.getPassword())) {
            String token = jwtUtil.generateToken(user.getEmail(), user.getRole());
            return new AuthResponse(token, user.getRole(), user.getEmail());
        }
        throw new RuntimeException("Invalid Password");
    }

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    	User user = userRepository.findByEmail(email)
    	        .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));


        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRole().name()) // Ensure roles are properly stored
                .build();
    }
    
    public void changePassword(ChangePasswordRequest request, String email) {
        if (!request.getNewPassword().equals(request.getConfirmPassword())) {
            throw new IllegalArgumentException("New password and confirmation do not match");
        }

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        if (!passwordEncoder.matches(request.getOldPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Old password is incorrect");
        }

        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        userRepository.save(user);
    }
    
    public void sendResetLink(String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            String token = UUID.randomUUID().toString();
            user.setResetToken(token);
            user.setTokenExpiry(LocalDateTime.now().plusMinutes(15));
            userRepository.save(user);

            String resetUrl = "http://localhost:3000/reset-password?token=" + token;

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(user.getEmail());
            message.setSubject("Reset Your Password");
            message.setText("Click the link to reset your password: " + resetUrl);

            mailSender.send(message);
        }
    }
        
        public boolean resetPassword(String token, String newPassword) {
            Optional<User> optionalUser = userRepository.findByResetToken(token);
            if (optionalUser.isPresent()) {
                User user = optionalUser.get();
                if (user.getTokenExpiry() != null && user.getTokenExpiry().isAfter(LocalDateTime.now())) {
                    user.setPassword(passwordEncoder.encode(newPassword));
                    user.setResetToken(null);
                    user.setTokenExpiry(null);
                    userRepository.save(user);
                    return true;
                }
            }
            return false;
    }
}

package com.Zidio.Security;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Zidio.Repository.UserRepository;

import io.jsonwebtoken.JwtException;

@Service
public class TokenBlacklistService {
    private final Set<String> blacklistedTokens = ConcurrentHashMap.newKeySet();

    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JWTUtil jwtUtil;
    
    
    
    public void blacklistToken(String token) {
        blacklistedTokens.add(token);
        
        
        try {
            // 👤 Extract username from token
            String username = jwtUtil.extractUsername(token);

            if (username != null) {
                userRepository.findByEmail(username).ifPresent(user -> {
                    user.setActive(false);
                    userRepository.save(user);
                    System.out.println("🚫 User marked inactive because token was blacklisted: " + username);
                });
            }
        } catch (JwtException e) {
            System.out.println("⚠️ Could not extract username from token while blacklisting: " + e.getMessage());
        }
    }
    
    
    

    public boolean isTokenBlacklisted(String token) {
        return blacklistedTokens.contains(token);
    }
}

package com.shopzone.user_service.service;

import com.shopzone.user_service.entity.Role;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;


public interface JwtService {
    String generateToken(String username, Set<Role> roles);

    String generateRefreshToken(String username);

    String extractUsername(String token);

    boolean isTokenValid(String token, UserDetails userDetails);

    boolean isTokenExpired(String token);

    Set<String> extractRoles(String token);
}

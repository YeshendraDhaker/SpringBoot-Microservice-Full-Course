package com.shopzone.user_service.service.Impl;

import com.shopzone.user_service.dto.request.LoginRequest;
import com.shopzone.user_service.dto.request.RegisterRequest;
import com.shopzone.user_service.dto.request.UserDto;
import com.shopzone.user_service.entity.Role;
import com.shopzone.user_service.entity.User;
import com.shopzone.user_service.exception.InvalidCredentialsException;
import com.shopzone.user_service.exception.UserAlreadyExistsException;
import com.shopzone.user_service.repository.RoleRepository;
import com.shopzone.user_service.repository.UserRespository;
import com.shopzone.user_service.service.AuthService;
import com.shopzone.user_service.util.CookieUtil;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRespository userRespository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository  roleRepository;
    private final JwtServiceImpl jwtService;
    private final CookieUtil cookieUtil;

    @Override
    @Transactional
    public void register(RegisterRequest request) {
        log.info("Registering new user with email: {}", request.getEmail());

        if (userRespository.existsByEmail(request.getEmail())) {
            log.warn("Registration failed - email already exists: {}", request.getEmail());
            throw new UserAlreadyExistsException("User with email " + request.getEmail() + " already exists");
        }

        Set<Role> userRoles = new HashSet<>();

        if (request.getRoles() != null && !request.getRoles().isEmpty()) {
            for (Role.RoleName roleName : request.getRoles()) {
                Role role = roleRepository.findByName(roleName)
                        .orElseThrow(() -> new RuntimeException("Role not found: " + roleName));
                userRoles.add(role);
                log.info("Assigned role: {} to user: {}", roleName, request.getEmail());
            }
        } else {
            Role customerRole = roleRepository.findByName(Role.RoleName.ROLE_CUSTOMER)
                    .orElseThrow(() -> new RuntimeException("Default role ROLE_CUSTOMER not found"));
            userRoles.add(customerRole);
            log.info("Assigned default role ROLE_CUSTOMER to user: {}", request.getEmail());
        }

        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .phone(request.getPhone())
                .roles(userRoles)
                .isActive(true)
                .build();

        userRespository.save(user);
        log.info("User registered successfully: {}", request.getEmail());
    }

    @Override
    public UserDto login(LoginRequest loginRequest, HttpServletResponse response) {
        log.info("Login attempt for email: {}", loginRequest.getEmail());

        User user = userRespository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> {
                    log.warn("Login failed - User not found: {}", loginRequest.getEmail());
                    return new InvalidCredentialsException("Invalid email or password");
                });

        if(!user.getIsActive()){
            log.warn("Login failed - account inactive: {}", loginRequest.getEmail());
            throw new InvalidCredentialsException("Account is inactive");
        }

        if(!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())){
            log.warn("Login failed - incorrect password for: {}", loginRequest.getEmail());
            throw new InvalidCredentialsException("Account is inactive");
        }

        String accessToken = jwtService.generateToken(user.getEmail(), user.getRoles());
        String refreshToken = jwtService.generateRefreshToken(user.getEmail());

        cookieUtil.setAccessTokenCookie(response, accessToken);
        cookieUtil.setRefreshTokenCookie(response, refreshToken);

        log.info("Login successful for user: {} - cookies set", loginRequest.getEmail());
        return mapToUserDto(user);

    }

    public UserDto refreshToken(String refreshToken, HttpServletResponse response) {
        log.info("refresh Token request received");

        String username = jwtService.extractUsername(refreshToken);
        log.info("Extracted username");

        User user = userRespository.findByEmail(username)
                .orElseThrow(() -> {
                    log.warn("Refresh token failed - user not found {}", username);
                    return new InvalidCredentialsException("invalid refresh token");
                });

        if(jwtService.isTokenExpired(refreshToken)){
            throw new InvalidCredentialsException("invalid refresh token");
        }

        String newAccessToken = jwtService.generateToken(user.getEmail(), user.getRoles());
        cookieUtil.setAccessTokenCookie(response, newAccessToken);
        log.info("New access token generated and cookie set for user: {}", username);

        return mapToUserDto(user);
    }

    public void logout(HttpServletResponse response) {
        log.info("Logout request");

        cookieUtil.deleteAllAuthCookies(response);
        log.info("Logout successful");
    }


    private UserDto mapToUserDto(User user){
        Set<String> roleNames = user.getRoles().stream()
                .map(role -> role.getRoleName().name())
                .collect(Collectors.toSet());

        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phone(user.getPhone())
                .roles(roleNames)
                .isActive(user.getIsActive())
                .createdAt(user.getCreatedAt())
                .build();
    }
}

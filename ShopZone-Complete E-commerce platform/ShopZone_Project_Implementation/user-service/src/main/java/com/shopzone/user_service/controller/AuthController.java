package com.shopzone.user_service.controller;

import com.shopzone.user_service.dto.request.*;
import com.shopzone.user_service.dto.response.LoginResponse;
import com.shopzone.user_service.entity.User;
import com.shopzone.user_service.service.AuthService;
import com.shopzone.user_service.service.PasswordResetService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final PasswordResetService passwordResetService;

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@Valid @RequestBody RegisterRequest registerRequest){
        authService.register(registerRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("message", "user registered Successful"));
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@Valid @RequestBody LoginRequest loginRequest, HttpServletResponse response){
        UserDto userDto = authService.login(loginRequest, response);
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<UserDto> refreshToken(
                    @CookieValue(name = "refreshToken", required = false) String refreshToken,
                                                      HttpServletResponse response){
        if(refreshToken == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        UserDto userDto = authService.refreshToken(refreshToken, response);
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/logout")
    public ResponseEntity<Map<String, String>> logout(HttpServletResponse response){
        authService.logout(response);
        return ResponseEntity.ok(Map.of("message", "user logged out"));
    }

    @PostMapping("/forgot-passowrd")
    public ResponseEntity<Map<String, String>> forgotPassword(@Valid @RequestBody ForgotPasswordRequest forgotPasswordRequest){

        passwordResetService.forgotPassword(forgotPasswordRequest.getEmail());
        return ResponseEntity.ok(Map.of("message", "Password reset link sent successfully"));
    }

    @PostMapping("/reset-password")
    public ResponseEntity<Map<String, String>> resetPassword(@Valid @RequestBody ResetPasswordrequest resetPasswordrequest){
        passwordResetService.resetPassword(resetPasswordrequest.getToken(), resetPasswordrequest.getNewPassword());
        return ResponseEntity.ok(Map.of("message", "Password reset successfully"));
    }
}


















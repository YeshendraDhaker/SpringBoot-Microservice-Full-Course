package com.shopzone.user_service.controller;

import com.shopzone.user_service.dto.request.ForgotPasswordRequest;
import com.shopzone.user_service.dto.request.LoginRequest;
import com.shopzone.user_service.dto.request.RegisterRequest;
import com.shopzone.user_service.dto.request.ResetPasswordrequest;
import com.shopzone.user_service.dto.response.LoginResponse;
import com.shopzone.user_service.service.AuthService;
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

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@Valid @RequestBody RegisterRequest registerRequest){
        authService.register(registerRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("message", "user registered Successful"));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest){
        LoginResponse loginResponse = authService.login(loginRequest);
        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<LoginResponse> refreshToken(@RequestBody Map<String,String> request){
        String refreshToken = request.get("refreshToken");
        LoginResponse response = authService.refreshToken(refreshToken);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/logout")
    public ResponseEntity<Map<String, String>> logout(){
        // In stateless JWT, logout is typically handled client-side by removing token
        return ResponseEntity.ok(Map.of("message", "user logged out"));
    }

    @PostMapping("/forgot-passowrd")
    public ResponseEntity<Map<String, String>> forgotPassword(@Valid @RequestBody ForgotPasswordRequest forgotPasswordRequest){

        authService.forgotPassword(forgotPasswordRequest.getEmail());
        return ResponseEntity.ok(Map.of("message", "Password reset link sent successfully"));
    }

    @PostMapping("/reset-password")
    public ResponseEntity<Map<String, String>> resetPassword(@Valid @RequestBody ResetPasswordrequest resetPasswordrequest){
        authService.resetPassword(resetPasswordrequest.getToken(), resetPasswordrequest.getNewPassword());
        return ResponseEntity.ok(Map.of("message", "Password reset successfully"));
    }



}



















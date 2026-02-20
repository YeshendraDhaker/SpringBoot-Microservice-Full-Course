package com.shopzone.user_service.service;

import com.shopzone.user_service.dto.request.LoginRequest;
import com.shopzone.user_service.dto.request.RegisterRequest;
import com.shopzone.user_service.dto.request.UserDto;
import jakarta.servlet.http.HttpServletResponse;

public interface AuthService {

    void register(RegisterRequest request);
    UserDto login(LoginRequest loginRequest, HttpServletResponse response);
    UserDto refreshToken(String refreshToken, HttpServletResponse response);
    void logout(HttpServletResponse response);
}

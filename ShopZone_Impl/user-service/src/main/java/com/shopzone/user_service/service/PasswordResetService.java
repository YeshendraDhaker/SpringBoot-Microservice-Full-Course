package com.shopzone.user_service.service;

public interface PasswordResetService {

    void forgotPassword(String email);

    void resetPassword(String token, String newPassword);
}

package com.shopzone.user_service.service.Impl;

import com.shopzone.user_service.client.NotificationClient;
import com.shopzone.user_service.entity.PasswordResetToken;
import com.shopzone.user_service.entity.User;
import com.shopzone.user_service.repository.PasswordTokenRepository;
import com.shopzone.user_service.repository.UserRespository;
import com.shopzone.user_service.service.PasswordResetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class PasswordResetServiceImpl implements PasswordResetService {

    @Value("${app.password-reset.token-validity-minutes}")
    private int tokenValidityMinutes;

    @Value("${app.frontend.url}")
    private String frontendUrl;

    private final UserRespository userRespository;
    private final PasswordTokenRepository passwordTokenRepository;
    private final NotificationClient notificationClient;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void forgotPassword(String email) {
        log.info("Password reset required for email: {}", email);

        //STEP 1: Validate user exists

        User user = userRespository.findByEmail(email)
                .orElseThrow(() -> {
                    log.warn("Password reset failed - user not found: {}", email);
                    return new UserNotFoundException("User not found with email: "+email);
                });

        log.info("User found: {} {}", user.getFirstName(), user.getLastName());

        //STEP 2: Delete any existing token (cleanup)
        passwordTokenRepository.findByEmail(email).ifPresent(token -> {
            log.info("Deleting existing reset token for email: {}", email);
            passwordTokenRepository.delete(token);
        });

        //STEP 3: Generate new random token
        String token = UUID.randomUUID().toString();

        //STEP 4: save token to database with expiry
        PasswordResetToken passwordResetToken = PasswordResetToken.builder()
                .token(token)
                .email(email)
                .expiryDate(LocalDateTime.now().plusMinutes(tokenValidityMinutes))
                .used(false)
                .build();

        passwordTokenRepository.save(passwordResetToken);

        //STEP 5: create reset link
        String resetLink = frontendUrl + "/reset-password?token=" + token;

        //STEP 6: Call Notification Client to send email
        try{
            Map<String, String> emailRequest = Map.of(
                    "email",email,
                    "firstName",user.getFirstName(),
                    "resetLink", resetLink
            );
            log.info("Calling Notification Client");
            notificationClient.sendPasswordResetEmail(emailRequest);
            log.info("Password reset email sent successfully");
        } catch (Exception e) {
            log.error("Failed to send password reset email");
        }

    }

    @Override
    public void resetPassword(String token, String newPassword) {

        //STEP 1: find token in database
        PasswordResetToken resetToken = passwordTokenRepository.findByToken(token)
                .orElseThrow(() -> {
                    return new InvalidTokenException("Invalid or expired reset token");
                });

        //STEP 2: check if token is expired
        if(resetToken.isExpired()){
            throw new InvalidTokenException("Token has expired, please request a new password link");
        }

        //STEP 3: check if token was already used
        if(resetToken.getUsed()){
            throw new InvalidTokenException("Reset token has been used, please request a new password link");
        }

        //STEP4: get the user
        User user = userRespository.findByEmail(resetToken.getEmail())
                .orElseThrow(() -> {
                    log.warn("Password reset failed - user not found: {}", resetToken.getEmail());
                    return new UserNotFoundException("User not found with email: "+resetToken.getEmail());
                });

        //STEP5: Updating password(encrypt with BCrypt)
        String encryptedPassword = passwordEncoder.encode(newPassword);
        user.setPassword(encryptedPassword);
        userRespository.save(user);

        //STEP6: Mark token as used (prevent reuse)
        resetToken.setUsed(true);
        passwordTokenRepository.save(resetToken);
        log.info("Password reset completed successfully for email: {}", user.getEmail());
    }
}





























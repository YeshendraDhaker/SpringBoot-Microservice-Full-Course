package com.shopzone.user_service.repository;

import com.shopzone.user_service.entity.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PasswordTokenRepository extends JpaRepository<PasswordResetToken, Long> {

    Optional<PasswordResetToken> findByEmail(String email);
    Optional<PasswordResetToken> findByToken(String token);
}

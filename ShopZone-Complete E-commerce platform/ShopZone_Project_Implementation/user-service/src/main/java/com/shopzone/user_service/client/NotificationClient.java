package com.shopzone.user_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(name = "notification-service", url = "${notification.service.url}")
public interface NotificationClient {

    // Calls Notification Service to send password reset email

    @PostMapping("/internal/notifications/password-reset")
    void sendPasswordResetEmail(@RequestBody Map<String, String> request);
}























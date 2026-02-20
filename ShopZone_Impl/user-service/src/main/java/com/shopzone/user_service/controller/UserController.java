package com.shopzone.user_service.controller;


import com.shopzone.user_service.dto.request.AddressRequest;
import com.shopzone.user_service.dto.request.ChangePasswordRequest;
import com.shopzone.user_service.dto.response.AddressResponse;
import com.shopzone.user_service.dto.response.UserResponse;
import com.shopzone.user_service.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/profile")
    public ResponseEntity<UserResponse> getProfile() {
        UserResponse response = userService.getCurrentUserProfile();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/profile")
    public ResponseEntity<UserResponse> updateProfile(@Valid @RequestBody UserResponse request) {
        UserResponse response = userService.updateProfile(request);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/change-password")
    public ResponseEntity<Map<String, String>> changePassword(@Valid @RequestBody ChangePasswordRequest request) {
        userService.changePassword(request);
        return ResponseEntity.ok(Map.of("message", "Password changed successfully"));
    }

    @DeleteMapping("/account")
    public ResponseEntity<Map<String, String>> deleteAccount() {
        userService.deleteAccount();
        return ResponseEntity.ok(Map.of("message", "Account deleted successfully"));
    }

    @GetMapping("/addresses")
    public ResponseEntity<List<AddressResponse>> getAllAddresses() {
        List<AddressResponse> addresses = userService.getAllAddresses();
        return ResponseEntity.ok(addresses);
    }

    @PostMapping("/addresses")
    public ResponseEntity<AddressResponse> addAddress(@Valid @RequestBody AddressRequest request) {
        AddressResponse response = userService.addAddress(request);
        return ResponseEntity.status(201).body(response);
    }

    @PutMapping("/addresses/{id}")
    public ResponseEntity<AddressResponse> updateAddress(
            @PathVariable Long id,
            @Valid @RequestBody AddressRequest request
    ) {
        AddressResponse response = userService.updateAddress(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/addresses/{id}")
    public ResponseEntity<Map<String, String>> deleteAddress(@PathVariable Long id) {
        userService.deleteAddress(id);
        return ResponseEntity.ok(Map.of("message", "Address deleted successfully"));
    }

    @PutMapping("/addresses/{id}/default")
    public ResponseEntity<Map<String, String>> setDefaultAddress(@PathVariable Long id) {
        userService.setDefaultAddress(id);
        return ResponseEntity.ok(Map.of("message", "Default address updated"));
    }

}

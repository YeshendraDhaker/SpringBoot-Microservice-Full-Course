package com.shopzone.user_service.service;

import com.shopzone.user_service.dto.request.AddressRequest;
import com.shopzone.user_service.dto.request.ChangePasswordRequest;
import com.shopzone.user_service.dto.response.AddressResponse;
import com.shopzone.user_service.dto.response.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse getCurrentUserProfile();

    UserResponse updateProfile(UserResponse userResponse);

    void changePassword(ChangePasswordRequest request);

    void deleteAccount();

    List<AddressResponse> getAllAddresses();

    AddressResponse addAddress(AddressRequest request);

    AddressResponse updateAddress(Long addressId, AddressRequest request);

    void deleteAddress(Long addressId);

    void setDefaultAddress(Long addressId);

    UserResponse getUserById(Long userId);

    UserResponse getUserByEmail(String email);
}

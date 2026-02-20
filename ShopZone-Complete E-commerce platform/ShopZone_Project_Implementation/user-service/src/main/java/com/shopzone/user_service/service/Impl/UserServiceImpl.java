package com.shopzone.user_service.service.Impl;

import com.shopzone.user_service.dto.request.AddressRequest;
import com.shopzone.user_service.dto.request.ChangePasswordRequest;
import com.shopzone.user_service.dto.response.AddressResponse;
import com.shopzone.user_service.dto.response.UserResponse;
import com.shopzone.user_service.entity.Address;
import com.shopzone.user_service.entity.User;
import com.shopzone.user_service.exception.InvalidCredentialsException;
import com.shopzone.user_service.exception.ResourceNotFoundException;
import com.shopzone.user_service.exception.UserNotFoundException;
import com.shopzone.user_service.repository.AddressRepository;
import com.shopzone.user_service.repository.UserRespository;
import com.shopzone.user_service.service.UserService;
import com.shopzone.user_service.util.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRespository userRepository;
    private final AddressRepository addressRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponse getCurrentUserProfile() {
        User user = getCurrentUser();
        return mapToUserResponse(user);
    }

    @Override
    @Transactional
    public UserResponse updateProfile(UserResponse userResponse) {
        User user = getCurrentUser();

        user.setFirstName(userResponse.getFirstName());
        user.setLastName(userResponse.getLastName());
        user.setPhone(userResponse.getPhone());

        user = userRepository.save(user);
        return mapToUserResponse(user);
    }

    @Override
    @Transactional
    public void changePassword(ChangePasswordRequest request) {
        User user = getCurrentUser();

        if (!passwordEncoder.matches(request.getOldPassword(), user.getPassword())) {
            throw new InvalidCredentialsException("Old password is incorrect");
        }

        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteAccount() {
        User user = getCurrentUser();
        user.setIsActive(false);
        userRepository.save(user);
    }

    @Override
    public List<AddressResponse> getAllAddresses() {
        User user = getCurrentUser();
        List<Address> addresses = addressRepository.findByUserId(user.getId());
        return addresses.stream()
                .map(this::mapToAddressResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public AddressResponse addAddress(AddressRequest request) {
        User user = getCurrentUser();

        Address address = Address.builder()
                .user(user)
                .addressLine1(request.getAddressLine1())
                .addressLine2(request.getAddressLine2())
                .city(request.getCity())
                .state(request.getState())
                .country(request.getCountry())
                .zip(request.getPincode())
                .isDefault(request.getIsDefault())
                .build();

        if (Boolean.TRUE.equals(request.getIsDefault())) {
            unsetDefaultAddresses(user.getId());
        }

        address = addressRepository.save(address);
        return mapToAddressResponse(address);
    }

    @Override
    @Transactional
    public AddressResponse updateAddress(Long addressId, AddressRequest request) {
        User user = getCurrentUser();

        Address address = addressRepository.findById(addressId)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found"));

        if (!address.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("Unauthorized");
        }

        address.setAddressLine1(request.getAddressLine1());
        address.setAddressLine2(request.getAddressLine2());
        address.setCity(request.getCity());
        address.setState(request.getState());
        address.setCountry(request.getCountry());
        address.setZip(request.getPincode());
        address.setIsDefault(request.getIsDefault());

        if (Boolean.TRUE.equals(request.getIsDefault())) {
            unsetDefaultAddresses(user.getId());
        }

        address = addressRepository.save(address);
        return mapToAddressResponse(address);
    }

    @Override
    @Transactional
    public void deleteAddress(Long addressId) {
        User user = getCurrentUser();

        Address address = addressRepository.findById(addressId)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found"));

        if (!address.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("Unauthorized");
        }

        addressRepository.delete(address);
    }

    @Override
    @Transactional
    public void setDefaultAddress(Long addressId) {
        User user = getCurrentUser();

        Address address = addressRepository.findById(addressId)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found"));

        if (!address.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("Unauthorized");
        }

        unsetDefaultAddresses(user.getId());
        address.setIsDefault(true);
        addressRepository.save(address);
    }

    @Override
    public UserResponse getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + userId));
        return mapToUserResponse(user);
    }

    @Override
    public UserResponse getUserByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found with email: " + email));
        return mapToUserResponse(user);
    }

    private User getCurrentUser() {
        String email = SecurityUtils.getCurrentUserEmail();
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    private void unsetDefaultAddresses(Long userId) {
        List<Address> addresses = addressRepository.findByUserId(userId);
        addresses.forEach(addr -> addr.setIsDefault(false));
        addressRepository.saveAll(addresses);
    }

    private UserResponse mapToUserResponse(User user) {
        List<AddressResponse> addresses = user.getAddresses().stream()
                .map(this::mapToAddressResponse)
                .collect(Collectors.toList());

        Set<String> roleNames = user.getRoles().stream()
                .map(role -> role.getRoleName().name())
                .collect(Collectors.toSet());

        return UserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phone(user.getPhone())
                .roles(roleNames)
                .isActive(user.getIsActive())
                .addresses(addresses)
                .createdAt(user.getCreatedAt())
                .build();
    }

    private AddressResponse mapToAddressResponse(Address address) {
        return AddressResponse.builder()
                .id(address.getId())
                .addressLine1(address.getAddressLine1())
                .addressLine2(address.getAddressLine2())
                .city(address.getCity())
                .state(address.getState())
                .country(address.getCountry())
                .pincode(address.getZip())
                .isDefault(address.getIsDefault())
                .build();
    }

}

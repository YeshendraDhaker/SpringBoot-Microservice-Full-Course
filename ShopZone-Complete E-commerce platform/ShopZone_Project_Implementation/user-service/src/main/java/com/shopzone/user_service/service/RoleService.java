package com.shopzone.user_service.service;

import com.shopzone.user_service.dto.response.RoleResponse;

import java.util.List;

public interface RoleService {
    List<RoleResponse> getAllRoles();
}

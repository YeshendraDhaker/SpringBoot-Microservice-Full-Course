package com.shopzone.user_service.service.Impl;

import com.shopzone.user_service.dto.response.RoleResponse;
import com.shopzone.user_service.repository.RoleRepository;
import com.shopzone.user_service.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public List<RoleResponse> getAllRoles() {
        return roleRepository.findAll().stream()
                .map(role -> RoleResponse.builder()
                        .id(role.getId())
                        .name(role.getRoleName().name())
                        .description(role.getDescription())
                        .build())
                .collect(Collectors.toList());
    }

}

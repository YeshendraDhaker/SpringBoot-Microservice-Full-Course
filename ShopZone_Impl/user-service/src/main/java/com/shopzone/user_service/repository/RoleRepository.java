package com.shopzone.user_service.repository;

import com.shopzone.user_service.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(Role.RoleName name);

    boolean existsByName(Role.RoleName name);
}

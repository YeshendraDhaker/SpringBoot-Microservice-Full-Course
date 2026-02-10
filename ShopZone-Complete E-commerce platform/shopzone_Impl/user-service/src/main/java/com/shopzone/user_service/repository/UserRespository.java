package com.shopzone.user_service.repository;

import com.shopzone.user_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRespository extends JpaRepository<User, Long> {
}

package com.shopzone.user_service.config;


import com.shopzone.user_service.entity.Role;
import com.shopzone.user_service.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        initializeRoles();
    }

    private void initializeRoles() {
        if (!roleRepository.existsByName(Role.RoleName.ROLE_CUSTOMER)) {
            Role customerRole = Role.builder()
                    .roleName(Role.RoleName.ROLE_CUSTOMER)
                    .description("Default role for customers who can browse and purchase products")
                    .build();
            roleRepository.save(customerRole);
            log.info("✅ Created ROLE_CUSTOMER");
        }

        if (!roleRepository.existsByName(Role.RoleName.ROLE_SELLER)) {
            Role sellerRole = Role.builder()
                    .roleName(Role.RoleName.ROLE_SELLER)
                    .description("Role for sellers/vendors who can list and manage their products")
                    .build();
            roleRepository.save(sellerRole);
            log.info("✅ Created ROLE_SELLER");
        }

        if (!roleRepository.existsByName(Role.RoleName.ROLE_ADMIN)) {
            Role adminRole = Role.builder()
                    .roleName(Role.RoleName.ROLE_ADMIN)
                    .description("Platform administrator with full access")
                    .build();
            roleRepository.save(adminRole);
            log.info("✅ Created ROLE_ADMIN");
        }

        log.info("✅ Role initialization completed");
    }

}

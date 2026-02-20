package com.shopzone.user_service.dto.request;

import com.shopzone.user_service.dto.response.AddressResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Long id;
     private String firstName;
     private String lastName;
     private String email;
     private String phone;
     private Set<String> roles;
     private Boolean isActive;
     private List<AddressResponse> addressResponses;
     private LocalDateTime createdAt;
}

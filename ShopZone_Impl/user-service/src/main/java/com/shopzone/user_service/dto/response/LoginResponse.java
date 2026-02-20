package com.shopzone.user_service.dto.response;

import com.shopzone.user_service.dto.request.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponse {

    private String accessToken;
    private String refreshToken;
    @Builder.Default
    private String tokenType="Bearer";

     private Long expiresIn;
     private UserDto userDto;
}

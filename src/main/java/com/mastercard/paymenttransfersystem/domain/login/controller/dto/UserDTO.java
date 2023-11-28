package com.mastercard.paymenttransfersystem.domain.login.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class UserDTO {
    
    private Long userId;
    
    private String jwt;
}

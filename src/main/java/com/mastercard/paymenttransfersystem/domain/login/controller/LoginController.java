package com.mastercard.paymenttransfersystem.domain.login.controller;

import com.mastercard.paymenttransfersystem.domain.login.controller.dto.LoginDTO;
import com.mastercard.paymenttransfersystem.domain.login.controller.dto.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/login")
@RequiredArgsConstructor
@Tag(name = "Login")
@CrossOrigin
public class LoginController {
    
    @GetMapping(path = "/")
    @Operation(summary = "The login interface")
    @ApiResponse(responseCode = "200", description = "Login to system")
    @ApiResponse(responseCode = "404", description = "User with given id not found")
    public UserDTO login(@RequestBody LoginDTO dto) {
        return null;
    }
}

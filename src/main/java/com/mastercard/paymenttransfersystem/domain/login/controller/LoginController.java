package com.mastercard.paymenttransfersystem.domain.login.controller;

import com.mastercard.paymenttransfersystem.domain.login.controller.dto.LoginRequest;
import com.mastercard.paymenttransfersystem.domain.login.controller.dto.SignUpRequest;
import com.mastercard.paymenttransfersystem.domain.login.controller.dto.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
@Tag(name = "Login")
@CrossOrigin
public class LoginController {
    
    @GetMapping(path = "/signup")
    @Operation(summary = "The login interface")
    @ApiResponse(responseCode = "200", description = "Signup successful")
    @ApiResponse(responseCode = "404", description = "Signup failed")
    public ResponseEntity<UserDTO> signup(@RequestBody SignUpRequest request) {
        return null;
    }

    @GetMapping(path = "/login")
    @Operation(summary = "The login interface")
    @ApiResponse(responseCode = "200", description = "Login successful")
    @ApiResponse(responseCode = "404", description = "Login failed")
    public ResponseEntity<UserDTO> signin(@RequestBody LoginRequest request) {
        return null;
    }
}

package com.xask.controller;

import com.xask.exceptions.NonAuthenticatedUserException;
import com.xask.security_response_request.AuthenticationRequest;
import com.xask.security_response_request.AuthenticationResponse;
import com.xask.security_response_request.RegisterRequest;
import com.xask.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody AuthenticationRequest request
    ) throws NonAuthenticatedUserException {
        return ResponseEntity.ok(service.authenticate(request));
    }
}

package com.xask.service;

import com.xask.database.entity.Role;
import com.xask.database.entity.User;
import com.xask.exceptions.NonAuthenticatedUserException;
import com.xask.repository.UserRepository;
import com.xask.security_response_request.AuthenticationRequest;
import com.xask.security_response_request.AuthenticationResponse;
import com.xask.security_response_request.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) throws NonAuthenticatedUserException {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                     request.getUsername(),
                     request.getPassword()
                )
        );
        var user = repository.findByUsername(request.getUsername())
                .orElseThrow(()->new NonAuthenticatedUserException("Пользователь не авторизован."));
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}

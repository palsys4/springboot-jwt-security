package com.example.jwt.jwtsecurity.controller;

import com.example.jwt.jwtsecurity.JWTUtility.JWTUtility;
import com.example.jwt.jwtsecurity.model.JWTTokenRequest;
import com.example.jwt.jwtsecurity.model.JWTTokenResponse;
import com.example.jwt.jwtsecurity.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JWTController {

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    CustomUserDetailsService userDetailsService;

    @Autowired
    JWTUtility jwtUtility;

    @GetMapping("/test-jwt")
    public String testJWT() {
        return "Hello world. Jwt token is valid";
    }

    @PostMapping("/authenticate")
    public JWTTokenResponse generateToken(@RequestBody JWTTokenRequest request){

        authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(),request.getPassword()));

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUserName());

        String token = jwtUtility.generateToken(userDetails);
        return new JWTTokenResponse(token);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}

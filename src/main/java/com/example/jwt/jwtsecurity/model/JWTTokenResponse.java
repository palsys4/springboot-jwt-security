package com.example.jwt.jwtsecurity.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class JWTTokenResponse {

    private String jwtToken;
}

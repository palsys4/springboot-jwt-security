package com.example.jwt.jwtsecurity.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class JWTTokenRequest {

    private String userName;
    private String password;

}

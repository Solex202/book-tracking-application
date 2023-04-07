package com.lotaproject.bookTracking.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {
    @Value("${jwt.secret.key}")
    private String jwtSecretKey;


    @Bean
    public JwtUtil jwtUtil(){
        var jwtUtil = new JwtUtil(jwtSecretKey);
        return jwtUtil;
    }
}

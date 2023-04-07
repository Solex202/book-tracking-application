package com.lotaproject.bookTracking.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class JwtUtil {
    private String secret;
}

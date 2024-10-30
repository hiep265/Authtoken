package com.example.demo.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


public interface JwtService {
    String generateToken(UserDetails user);
    String extractUsername(String token);
    boolean validateToken(String token,UserDetails user);
}

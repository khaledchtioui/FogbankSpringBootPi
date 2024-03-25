package com.fogbank.springsecurity.services;

import com.fogbank.springsecurity.entities.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashMap;
import java.util.Map;

public interface JWTService {


    String extractUserName(String token);

    String generateToken(UserDetails userDetails);

    String generateRefreshToken(Map<String, Object> extraclaims, UserDetails user);


    boolean isTokenValid(String token, UserDetails userDetails);


}



package com.fogbank.springsecurity.services;

import com.fogbank.springsecurity.dto.JwtAuthenticationResponse;
import com.fogbank.springsecurity.dto.RefreshTokenRequest;
import com.fogbank.springsecurity.dto.SignUpRequest;
import com.fogbank.springsecurity.dto.SigninRequest;
import com.fogbank.springsecurity.entities.User;

public interface AuthenticationService {

    User signup(SignUpRequest signUpRequest) ;
    JwtAuthenticationResponse signin(SigninRequest signinRequest)   ;
    JwtAuthenticationResponse refreshtoken(RefreshTokenRequest refreshTokenRequest)     ;

}

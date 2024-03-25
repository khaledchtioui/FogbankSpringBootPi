package com.fogbank.springsecurity.controller;

import com.fogbank.springsecurity.dto.JwtAuthenticationResponse;
import com.fogbank.springsecurity.dto.RefreshTokenRequest;
import com.fogbank.springsecurity.dto.SignUpRequest;
import com.fogbank.springsecurity.dto.SigninRequest;
import com.fogbank.springsecurity.entities.User;
import com.fogbank.springsecurity.services.AuthenticationService;
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


    private  final AuthenticationService authenticationService ;
    @PostMapping("/signup")

    public ResponseEntity<User> signup(@RequestBody SignUpRequest signUpRequest)

    {
return ResponseEntity.ok(authenticationService.signup(signUpRequest))  ;
    }



    @PostMapping("/signin")
    public  ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest signinRequest)
    {
        return  ResponseEntity.ok(authenticationService.signin(signinRequest)) ;
    }
    @PostMapping("/refresh")
    public  ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody RefreshTokenRequest refreshTokenRequest)
    {
        return  ResponseEntity.ok(authenticationService.refreshtoken(refreshTokenRequest)) ;
    }


}

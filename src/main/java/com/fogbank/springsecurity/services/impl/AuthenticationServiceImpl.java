package com.fogbank.springsecurity.services.impl;

import com.fogbank.springsecurity.Repository.UserRepository;
import com.fogbank.springsecurity.dto.JwtAuthenticationResponse;
import com.fogbank.springsecurity.dto.RefreshTokenRequest;
import com.fogbank.springsecurity.dto.SignUpRequest;
import com.fogbank.springsecurity.dto.SigninRequest;
import com.fogbank.springsecurity.entities.Role;
import com.fogbank.springsecurity.entities.User;
import com.fogbank.springsecurity.services.AuthenticationService;
import com.fogbank.springsecurity.services.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {


    private  final UserRepository userRepository  ;
    private final PasswordEncoder passwordEncoder  ;
    private final AuthenticationManager authenticationManager ;
    private final JWTService jwtService ;


    public User signup(SignUpRequest signUpRequest) {

        User user = new User()  ;
        user.setEmail(signUpRequest.getEmail());
        user.setFirstname(signUpRequest.getFirstname());
        user.setLastname(signUpRequest.getLastname());
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

        return userRepository.save(user) ;

    }


    public JwtAuthenticationResponse signin(SigninRequest signinRequest)
    {
    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signinRequest.getEmail(),signinRequest.getPassword())) ;

    var user = userRepository.findByEmail(signinRequest.getEmail()).orElseThrow(()->new IllegalArgumentException("Invalid email or password"))  ;
    var jwt = jwtService.generateToken(user)  ;
    var refreshtoken = jwtService.generateRefreshToken(new HashMap<>()  ,user)  ;

    JwtAuthenticationResponse jwtAuthenticationResponse =new JwtAuthenticationResponse()  ;

     jwtAuthenticationResponse.setToken(jwt);
     jwtAuthenticationResponse.setRefreshToken(refreshtoken);

     return jwtAuthenticationResponse  ;
    }


    public JwtAuthenticationResponse refreshtoken(RefreshTokenRequest refreshTokenRequest)
    {
        String userEmail = jwtService.extractUserName(refreshTokenRequest.getToken());
        User user =  userRepository.findByEmail(userEmail).orElseThrow()  ;
        if (jwtService.isTokenValid(refreshTokenRequest.getToken(),user))
        {
            var jwt = jwtService.generateToken(user)  ;

            JwtAuthenticationResponse jwtAuthenticationResponse =new JwtAuthenticationResponse()  ;

            jwtAuthenticationResponse.setToken(jwt);
            jwtAuthenticationResponse.setRefreshToken(refreshTokenRequest.getToken());

            return jwtAuthenticationResponse  ;

        }

        return null  ;
    }





}

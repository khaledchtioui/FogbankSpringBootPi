package com.fogbank.springsecurity.controller;

import com.fogbank.springsecurity.Repository.ForgetPasswordRepository;
import com.fogbank.springsecurity.Repository.UserRepository;
import com.fogbank.springsecurity.dto.MailBody;
import com.fogbank.springsecurity.entities.ForgetPassword;
import com.fogbank.springsecurity.entities.User;
import com.fogbank.springsecurity.services.impl.EmailService;
import com.fogbank.springsecurity.utils.ChangePassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;
import java.util.Random;

@RestController
@RequestMapping("/forgetpassword")

public class ForgotPasswordController {
    @Autowired
private  UserRepository userRepository ;
    @Autowired
    private  EmailService emailService ;
    @Autowired
    private ForgetPasswordRepository forgetPasswordRepository ;
    @Autowired
    private PasswordEncoder passwordEncoder  ;
    @PostMapping("/verifyMail/{email}")
    public ResponseEntity<String> verifyEmail(@PathVariable String email)

    {
       // System.out.println("testA");
        User user =userRepository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("Please provide an valid email "))  ;
        int otp = otpGenerator()  ;
        MailBody mailBody = MailBody.builder().to(email)
                .text("This is the OTP For Your Forgot Password  request : "+otp)
                .subject("Otp for Forgot password")
                .build() ;
    //    System.out.println("testB");

        ForgetPassword fp = ForgetPassword.builder()
                .otp(otp)
                .expirationtime(new Date(System.currentTimeMillis()+120*1000))
                .user(user)
                .build() ;
     //   System.out.println("testC");


        emailService.sendSimpleMessage(mailBody);
        forgetPasswordRepository.save(fp) ;
        return ResponseEntity.ok("Email sent for verification")  ;


    }

    @PostMapping("/verifyOtp/{otp}/{email}")
    public ResponseEntity<String> verifyOtp(@PathVariable Integer otp , @PathVariable String email)
    {
        User user =userRepository.findByEmail(email)
                                 .orElseThrow(()->new UsernameNotFoundException("Please provide an valid email "))  ;

     ForgetPassword fp=   forgetPasswordRepository.findByOtpAndUser(otp,user).orElseThrow(()->new RuntimeException("Invalid OTP"))  ;
        if (fp.getExpirationtime().before(Date.from(Instant.now())))
        {
            forgetPasswordRepository.deleteById(fp.getFpid());
            return new ResponseEntity<>("OTP has  expired ", HttpStatus.EXPECTATION_FAILED)  ;
        }


        return ResponseEntity.ok("OTP verified")  ;
    }

    @PostMapping("/changePassword/{email}")
    public ResponseEntity<String> changePasswordHandler(@RequestBody ChangePassword changePassword , @PathVariable String email)
    {
    if(!Objects.equals(changePassword.password(),changePassword.repeatpassword()))
    {


        return new ResponseEntity<>("Please enter the password again",HttpStatus.EXPECTATION_FAILED)  ;


    }



        String encodedPassword = passwordEncoder.encode(changePassword.password())  ;

        userRepository.updatePassword(email,encodedPassword);

        return ResponseEntity.ok("Password has been  changed ") ;
    }

    private Integer otpGenerator()
    {
        Random random = new Random()  ;
        return  random.nextInt(100_000,999_999)  ;
    }
}

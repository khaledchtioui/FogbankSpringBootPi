package com.fogbank.springsecurity.services.forum.implServiceForum;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SmsTool {
    // Find your Account Sid and Token at twilio.com/user/account
    public static final String ACCOUNT_SID = "ACbeb796e10c8d2a4ffd80a0f60f3a2426";
    public static final String AUTH_TOKEN = "b4b760be6e1684a5ea0c2ca731e3b0ff";

    public static void envoyer(String msg,String numDest) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber(numDest),
                new PhoneNumber("+19412397745"),
                msg).create();

        System.out.println(message.getSid());
    }
}
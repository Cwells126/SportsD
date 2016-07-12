package com.connectcard.service.impl;

import com.connectcard.service.SendVerificationEmail;
import com.jigy.api.Helpful;

import javax.annotation.Resource;
import javax.mail.MessagingException;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class SendVerificationEmailImpl implements SendVerificationEmail {

    @Resource
    private SendEmailImpl sendEmail;

    private static String USERNAME = "admin@connectCard.com";
    private static String PASSWORD = "testPassword";
    private static String EMAIL_SUBJECT = "Complete your CONNECT CARD registration";
    private static String MESSAGE_BODY = "Thank you for signing up with Connect Card! <br>Click on the link below "
            + "to activate your account. If the link is not working, copy and paste it into your browser "
            + "and hit enter.<br><br>  <a href=\"http://connectcard.com/ConnectCard/verifyEmail.go?email=:email&val=:val\">\"http://connectcard.com/ConnectCard/verifyEmail.go?email=:email&val=:val\"</a><br><br> "
            + "Thanks again for choosing Connect Card! <br><br> __ <br><br>Please Note: this email message was sent from a notification-only address that cannot except incoming email.";

    
    
    @Override
    public boolean sendVerificationEmail(String tempPassword, String email) throws MessagingException {
        return sendEmail.sendMessage(EMAIL_SUBJECT, createMessageBody(email, tempPassword), email);
    }
    
    
    
    private String createMessageBody(String email, String tempPassword){
        return MESSAGE_BODY.replace(":email", Helpful.encodeStringToBase64(email)).replace(":val", Helpful.encodeStringToBase64(tempPassword));
    }
}

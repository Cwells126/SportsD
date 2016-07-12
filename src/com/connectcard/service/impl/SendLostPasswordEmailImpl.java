package com.connectcard.service.impl;

import com.connectcard.service.SendLostPasswordEmail;
import com.jigy.api.Helpful;
import javax.annotation.Resource;
import javax.mail.MessagingException;
import org.springframework.stereotype.Service;

@Service
public class SendLostPasswordEmailImpl implements SendLostPasswordEmail { 

    @Resource
    private SendEmailImpl sendEmail ;

    private static String USERNAME = "admin@connectcard.com";
    private static String PASSWORD = "testPassword";
    private static String EMAIL_SUBJECT = "Connect Card Password Reset";
    private static String MESSAGE_BODY = "Dear User, <br>Please click the link below to reset your password.  (Please note:  If you experience problems when you click on the link below, please copy and paste the link into your web browser.)<br><br>  "
            + "<a href=\"http://connectcard.com/ConnectCard/resetPassword.go?email=:email&val=:val\">\"http://ConnectCard.com/GetJigy/resetPassword.go?email=:email&val=:val\"</a><br><br> "
            + "Thanks again for choosing Connect Card! <br><br> __ <br><br>This message was requested by the user to reset the credentials previously created for Connect Card to which the user has access. "
            + "<br>Please Do Not Reply To This Message. This email message was sent from a notification-only address that cannot except incoming email.<br>"
            + "We are happy to help you with any questions or concerns you may have.  Please contact Customer Service at:<br><br>customerservice@connectcard.com";

    
    
    @Override
    public boolean sendLostPasswordEmail(String tempPassword, String email) throws MessagingException {
        return sendEmail.sendMessage(EMAIL_SUBJECT, createMessageBody(email, tempPassword), email);
    }
    
    
    
    private String createMessageBody(String email, String tempPassword){
        return MESSAGE_BODY.replace(":email", Helpful.encodeStringToBase64(email)).replace(":val", Helpful.encodeStringToBase64(tempPassword));
    }
}

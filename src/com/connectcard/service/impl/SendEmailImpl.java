package com.connectcard.service.impl;

import com.connectcard.service.SendEmail;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.stereotype.Service;

@Service
public class SendEmailImpl implements SendEmail {

    /**
     * TODO - add the username and password to the properties file and inject them into this service
     */
    private static final String SMTP_HOST_NAME = "smtpout.secureserver.net"; //smtp URL
    private static final int SMTP_HOST_PORT = 465; //port number
    private static String JIGY_CUSTOMER_SERVICE = "customerservice@getjigy.com";
    private static String PASSWORD = "kC020202";

    // to is a var args field. If it is empty, it means that someone is attempting to contact jigy so
    // we will fill the "to" field in with the jigy customer service info. If it is not empty, it means
    // that a message needs to go out to a user and the email has been included so we'll use that one
    @Override
    public boolean sendMessage(String subject, String messageBody, String... to){
 
		Properties props = new Properties();
                props.put("mail.transport.protocol", "smtps");
                props.put("mail.smtps.host", SMTP_HOST_NAME);
                props.put("mail.smtps.auth", "true");
		//props.put("mail.smtp.auth", "true");
		//props.put("mail.smtp.starttls.enable", "true");
		//props.put("mail.smtp.host", "smtpout.secureserver.net");
		//props.put("mail.smtp.port", "25");
 
		Session mailSession = Session.getDefaultInstance(props);
                mailSession.setDebug(true);
 
		try {
                        Transport transport = mailSession.getTransport();
			javax.mail.Message message = new MimeMessage(mailSession);
			message.setFrom(new InternetAddress(JIGY_CUSTOMER_SERVICE));
                        if(to != null && to.length > 0){
                            message.setRecipients(javax.mail.Message.RecipientType.TO,InternetAddress.parse(to[0]));
                        } else {
                            message.setRecipients(javax.mail.Message.RecipientType.TO,InternetAddress.parse(JIGY_CUSTOMER_SERVICE));
                        }
			
			message.setSubject(subject);
			message.setContent(messageBody, "text/html" );
 
			//Transport.send(message);
                        transport.connect(SMTP_HOST_NAME, SMTP_HOST_PORT, JIGY_CUSTOMER_SERVICE, PASSWORD);
                        transport.sendMessage(message, message.getRecipients(javax.mail.Message.RecipientType.TO));
                        transport.close();
 
		} catch (Exception ex) {
                    Logger.getLogger(SendEmailImpl.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
		}
                
                return true;
	}
}


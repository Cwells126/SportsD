
package com.connectcard.service;

import javax.mail.MessagingException;

/**
 *
 * @author admin
 */
public interface SendVerificationEmail {
    /**
     * This method sends a verification email to the user
     * after sign up to verify the uer's email address
     * @param tempPassword the temporary password created for verification
     * @param email the email address of the user
     * @return true if the message sent successfully, false otherwise
     * @throws MessagingException 
     */
    public boolean sendVerificationEmail(String tempPassword, String email) throws MessagingException;
}


package com.connectcard.service;

import javax.mail.MessagingException;

/**
 *
 * @author admin
 */
public interface SendLostPasswordEmail {
    /**
     * This method sends out a password retrieval to a user to help them
     * get their lost password
     * @param tempPassword the temporary password to send to the user
     * @param email the email address of the user
     * @return true if the message sent, false otherwise
     * @throws MessagingException 
     */
    public boolean sendLostPasswordEmail(String tempPassword, String email) throws MessagingException;
}

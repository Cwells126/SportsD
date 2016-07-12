
package com.connectcard.service;

/**
 *
 * @author admin
 */
public interface SendEmail {
    /**
     * This method sends an email message
     * @param subject the subject of the email
     * @param messageBody the body of the email
     * @param to the address(es) to send the email to
     * @return 
     */
    public boolean sendMessage(String subject, String messageBody, String... to);
}

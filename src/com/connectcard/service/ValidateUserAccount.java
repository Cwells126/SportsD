
package com.connectcard.service;

import com.connectcard.domain.User;



/**
 *
 * @author admin
 */
public interface ValidateUserAccount {
    /**
     * This method performs validation on the email of a user
     * by searching the database for the user with the email
     * address and temporary password
     * @param email the user's email address
     * @param tempPassword the temporary password of the user
     * @return returns the user record if found
     */
    public User validateUserAccount(String email, String tempPassword);
}

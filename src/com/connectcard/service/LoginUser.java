
package com.connectcard.service;

import com.connectcard.domain.User;



/**
 *
 * @author admin
 */
public interface LoginUser {
    /**
     * This method logs the user in
     * @param email the user's email address
     * @param password the user's password
     * @return 
     */
    public User loginUser(String email, String password);
}

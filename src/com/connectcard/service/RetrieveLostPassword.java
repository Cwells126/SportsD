
package com.connectcard.service;

import com.connectcard.exception.ConnectCardException;

/**
 *
 * @author admin
 */
public interface RetrieveLostPassword {
    /**
     * This method retrieves the lost password of the user
     * @param email
     * @return
     * @throws ConnectCardException 
     */
    public String retrieveLostPassword(String email) throws ConnectCardException;
}

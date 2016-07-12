
package com.connectcard.service;

import com.connectcard.exception.ConnectCardException;

/**
 *
 * @author admin
 */
public interface CreateTemporaryUser {
    public String createTemporaryUser(String userName, String password, String email) throws ConnectCardException;
}

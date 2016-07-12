
package com.connectcard.service;

/**
 *
 * @author admin
 */
public interface UpdateUserPassword {
    /**
     * This method updates a user's password to the
     * new passed-in password
     * @param idUser the id of the user
     * @param password the new password
     * @return returns 1 if the record updated successfully, 0 otherwise
     */
    public int updateUserPassword(int idUser, String password);
}

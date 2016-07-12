
package com.connectcard.dao;

/**
 *
 * @author admin
 */
public interface ContactDAO {
    /**
     * This method inserts a new contact record into the database
     * @param idUser
     * @param nmUser
     * @param email
     * @param name
     * @param subject
     * @param message
     * @return 
     */
    public int createNewContactWithUserInfo(int idUser, String nmUser, String email, String name, String subject, String message);
    
    
    /**
     * This method creates a new contact record for a user who
     * does not have an account
     * @param email
     * @param name
     * @param subject
     * @param message
     * @return 
     */
    public int createNewContactWithoutUserInfo(String email, String name, String subject, String message);
}

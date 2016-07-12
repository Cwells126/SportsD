
package com.connectcard.dao;

import com.connectcard.domain.User;



/**
 *
 * @author admin
 */
public interface UserDAO {
    /**
     * This method inserts a new user record into the database
     * @param userName
     * @param email
     * @param password
     * @param tempPassword
     * @return 
     */
     public int createNewUser(String userName, String email, String password, String tempPassword);
    
    
     /**
      * This method inserts a temporary user password into the database
      * @param idUser
      * @param tempPassword
      * @return 
      */
    public int setTempPassword(int idUser, String tempPassword);
    
    
    /**
     * This method updates a user's password with the new password
     * @param idUser
     * @param password
     * @return 
     */
    public int updatePassword(int idUser, String password);
    
    
    /**
     * This method retrieves a user by their email address
     * @param email
     * @return 
     */
    public User retrieveUserByEmail(String email);
    
    
    /**
     * This method finds a user by email address and password
     * @param email
     * @param password
     * @return 
     */
    public User retrieveUserByEmailAndPassword(String email, String password);
    
    
    /**
     * This method handles email validation for a user
     * @param email the email address of the user
     * @param tempPassword the temporary password assigned to the user
     * @return 
     */
    public User validateUserEmail(String email, String tempPassword);
}

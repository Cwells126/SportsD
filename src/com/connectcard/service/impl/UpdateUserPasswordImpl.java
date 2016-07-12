package com.connectcard.service.impl;

import com.connectcard.dao.impl.UserDAOImpl;
import com.connectcard.service.UpdateUserPassword;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserPasswordImpl implements UpdateUserPassword {
    @Resource
    private UserDAOImpl userDAO;
    
    @Override
    public int updateUserPassword(int idUser, String password) {
        // update the user's password to the new passed-in password
        return userDAO.updatePassword(idUser, password); 
    }
}

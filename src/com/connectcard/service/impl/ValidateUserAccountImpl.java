package com.connectcard.service.impl;

import com.connectcard.dao.impl.UserDAOImpl;
import com.connectcard.domain.User;
import com.connectcard.service.ValidateUserAccount;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ValidateUserAccountImpl implements ValidateUserAccount {
    @Resource
    private UserDAOImpl userDAO;
    
    @Override
    public User validateUserAccount(String email, String tempPassword) {
        // verify the user's email address and validate the account
        User user = userDAO.validateUserEmail(email, tempPassword);
        
        return user;
        
    }
}

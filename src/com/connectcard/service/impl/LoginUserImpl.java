package com.connectcard.service.impl;

import com.connectcard.dao.impl.UserDAOImpl;
import com.connectcard.domain.User;
import com.connectcard.service.LoginUser;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginUserImpl implements LoginUser{
    @Autowired
    private UserDAOImpl userDAO;
    
    @Override
    public User loginUser(String email, String password) {
        // retrieve the user that is attempting to log in
        User user = userDAO.retrieveUserByEmailAndPassword(email, password);
        
        return user;
        
    }
}

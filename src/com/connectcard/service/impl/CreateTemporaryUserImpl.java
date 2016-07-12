package com.connectcard.service.impl;

import com.jigy.api.security.SymmetricEncryption;
import com.connectcard.dao.impl.UserDAOImpl;
import com.connectcard.domain.User;
import com.connectcard.exception.ConnectCardException;
import com.connectcard.service.CreateTemporaryUser;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateTemporaryUserImpl implements CreateTemporaryUser{

    @Resource
    private UserDAOImpl userDAO;
    
    public static final String EMAIL_ADDRESS_ALREADY_REGISTERED = "Email Address Already Registered";
    public static final String ACCOUNT_CREATION_FAILED = "Account creation insert statment failed";

    @Transactional
    @Override
    public String createTemporaryUser(String userName, String password, String email) throws ConnectCardException {
        Map returnMap = new HashMap();
        
        // check to make sure email address is not already signed up
        User user = userDAO.retrieveUserByEmail(email);
        
        // if user is not null then email address is already signed up... send back an error message
        if(user != null){
            throw new ConnectCardException(EMAIL_ADDRESS_ALREADY_REGISTERED);
        }
        
        // create temporary password to email to user
        String tempPassword = SymmetricEncryption.generateKey().substring(0, 20);
        
        // create temporary user account
        int insert = userDAO.createNewUser(userName, email, password, tempPassword);
        
        // send verification email
        if(insert == 0){
            throw new ConnectCardException(ACCOUNT_CREATION_FAILED);
        }

        
        return tempPassword;
    }
}

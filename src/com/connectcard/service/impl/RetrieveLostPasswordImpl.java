package com.connectcard.service.impl;

import com.jigy.api.Helpful;
import com.jigy.api.security.SymmetricEncryption;
import com.connectcard.dao.impl.UserDAOImpl;
import com.connectcard.domain.User;
import com.connectcard.exception.ConnectCardException;
import com.connectcard.service.RetrieveLostPassword;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RetrieveLostPasswordImpl implements RetrieveLostPassword {

    @Resource
    private UserDAOImpl userDAO;
    
    public static final String EMAIL_ADDRESS_NOT_REGISTERED = "Email Address Is Not Registered";

    @Transactional
    @Override
    public String retrieveLostPassword(String email) throws ConnectCardException {
        Map returnMap = new HashMap();
        
        // get user by email address
        User user = userDAO.retrieveUserByEmail(email);
        
        // if user is null then email address is not valid... throw exception
        if(user == null){
            throw new ConnectCardException(EMAIL_ADDRESS_NOT_REGISTERED);
        }
        
        // create temporary password to email to user
        String tempPassword = SymmetricEncryption.generateKey().substring(0, 20);
        
        if(!Helpful.isEmpty(tempPassword)){
            int update = userDAO.setTempPassword(user.getIdUser(), tempPassword);
            if(update > 0){
                return tempPassword;
            } else {
                throw new ConnectCardException("Error: Please try again later");
            }
        } else {
                throw new ConnectCardException("Error: Please try again later");
        }
    }
}

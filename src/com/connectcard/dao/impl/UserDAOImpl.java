
package com.connectcard.dao.impl;

import com.connectcard.domain.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class UserDAOImpl extends BaseDAOImpl {

    
    public int createNewUser(String userName, String email, String password, String tempPassword){
        String sql = "insert into user (nm_user, email_user, password, temp_password) values (?, ?, ?, ?)";
        return getSimpleJdbcTemplate().update(sql, userName, email, password, tempPassword);
    }
    
    
    public int setTempPassword(int idUser, String tempPassword){
        String sql = "update user set temp_password = ? where id_user = ?";
        return getSimpleJdbcTemplate().update(sql, tempPassword, idUser);
    }
    
    
    public int updatePassword(int idUser, String password){
        String sql = "update user set password = ? where id_user = ?";
        return getSimpleJdbcTemplate().update(sql, password, idUser);
    }
    
    
    public User retrieveUserByEmail(String email){
        String sql = "SELECT * from user where email_user = ?";
        return (User) getUniqueResult(getSimpleJdbcTemplate().query(sql, new UserRowMapper(), email));
    }
    
    
    public User retrieveUserByEmailAndPassword(String email, String password){
        String sql = "SELECT * from user where email = ? and BINARY password = ?";
        return (User) getUniqueResult(getSimpleJdbcTemplate().query(sql, new UserRowMapper(), email, password));
    }
    
    
    public User validateUserEmail(String email, String tempPassword){
        String sqlUpdate = "update user set temp_password = '' where email_user = ? and temp_password = ?";
        int update = getSimpleJdbcTemplate().update(sqlUpdate, email, tempPassword);
        if(update > 0){
            return retrieveUserByEmail(email);
        }
        return null;
    }
    
    
    public class UserRowMapper implements RowMapper {

        @Override
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setIdUser(rs.getInt("id_user"));
            user.setEmailUser(rs.getString("email_user"));
            user.setNmUser(rs.getString("nm_user"));
            user.setPassword(rs.getString("password"));
            user.setTempPassword(rs.getString("temp_password"));
            return user;
        }
    }
}

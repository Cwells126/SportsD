
package com.connectcard.dao.impl;

import com.connectcard.domain.Contact;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class ContactDAOImpl extends BaseDAOImpl {

    
    public int createNewContactWithUserInfo(int idUser, String nmUser, String email, String name, String subject, String message){
        String sql = "insert into contact (id_user, nm_user, email, name, subject, message) values (?, ?, ?, ?, ?, ?)";
        return getSimpleJdbcTemplate().update(sql, idUser, nmUser, email, name, subject, message);
    }
    
    
    public int createNewContactWithoutUserInfo(String email, String name, String subject, String message){
        String sql = "insert into contact (email, name, subject, message) values (?, ?, ?, ?)";
        return getSimpleJdbcTemplate().update(sql, email, name, subject, message);
    }

    
    public class ContactRowMapper implements RowMapper {

        @Override
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            Contact contact = new Contact();
            contact.setIdUser(rs.getInt("id_user"));
            contact.setIdContact(rs.getInt("id_contact"));
            contact.setNmUser(rs.getString("nm_user"));
            contact.setEmail(rs.getString("email"));
            contact.setName(rs.getString("name"));
            contact.setSubject(rs.getString("subject"));
            contact.setMessage(rs.getString("message"));
            return contact;
        }
    }
}

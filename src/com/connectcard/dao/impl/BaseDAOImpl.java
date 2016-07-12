
package com.connectcard.dao.impl;


import java.util.List;
import javax.annotation.Resource;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class BaseDAOImpl{

    private DataSource dataSource;
    
    
    
    /**
     * This method gets an initiated SimpleJdbcTemplate
     * @return a SimpleJdbcTemplate
     */
    public SimpleJdbcTemplate getSimpleJdbcTemplate() {
        return new SimpleJdbcTemplate(dataSource);
    }

    
    
    /**
     * This method gets an initiated JdbcTemplate
     * @return a JdbcTemplate
     */
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }
    
    
    
    /**
     * This method gets an initiated NamedParameterJdbcTemplate
     * @return returns a NamedParameterJdbcTemplate for named jdbc operations
     */
    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate(){
        return new NamedParameterJdbcTemplate(dataSource);
    }
    
    
    
    /**
     * This method returns the only result within a list
     * @param objectList - a list containing only a single object
     * @return 
     */
    protected Object getUniqueResult(List<Object> objectList){
        if(!objectList.isEmpty()){
            return objectList.get(0);
        }
        return null;
    }
}

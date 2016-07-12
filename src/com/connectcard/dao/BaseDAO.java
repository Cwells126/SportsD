
package com.connectcard.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

/**
 *
 * @author admin
 */
public interface BaseDAO {
    /**
     * This method gets an initiated SimpleJdbcTemplate
     * @return a SimpleJdbcTemplate
     */
    public SimpleJdbcTemplate getSimpleJdbcTemplate();

    
    
    /**
     * This method gets an initiated JdbcTemplate
     * @return a JdbcTemplate
     */
    public JdbcTemplate getJdbcTemplate();
    
    
    
    /**
     * This method gets an initiated NamedParameterJdbcTemplate
     * @return returns a NamedParameterJdbcTemplate for named jdbc operations
     */
    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate();
}

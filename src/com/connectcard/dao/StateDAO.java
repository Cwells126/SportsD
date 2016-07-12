
package com.connectcard.dao;
import java.util.List;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import com.connectcard.domain.State;

/**
 *
 * @author admin
 */
public interface StateDAO {
    /**
     * This method gets an initiated SimpleJdbcTemplate
     * @return a SimpleJdbcTemplate
     */
    public SimpleJdbcTemplate getSimpleJdbcTemplateCity();
    
    
    /**
     * This method retrieves a list of all U.S. States
     * @return return a  list of states
     */
    public List<State> retrieveAllStates();
}

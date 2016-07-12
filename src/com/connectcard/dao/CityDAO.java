
package com.connectcard.dao;

import java.util.List;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

/**
 *
 * @author admin
 */
public interface CityDAO {
    /**
     * This method gets an initiated SimpleJdbcTemplate
     * @return a SimpleJdbcTemplate
     */
    public SimpleJdbcTemplate getSimpleJdbcTemplateCity();
    
    
    /**
     * Retrieve all cities for a specific state
     * @param stateCode the code of the state 
     * @return a list of cities
     */
    public Long saveCity(String cityName);
}

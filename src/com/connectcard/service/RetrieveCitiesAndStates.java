
package com.connectcard.service;

import com.connectcard.domain.City;
import com.connectcard.domain.State;
import java.util.List;

/**
 *
 * @author admin
 */
public interface RetrieveCitiesAndStates {
    /**
     * This method retrieves cities for the passed-in state
     * @param stateCode the code of the state (ie. GA)
     * @return 
     */
    public List<City> retrieveAllCities();
    
    
    /**
     * Retrieve all US states
     * @return 
     */
    public List<State> retrieveAllStates();
}

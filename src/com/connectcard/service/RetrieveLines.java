package com.connectcard.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.connectcard.domain.City;
import com.connectcard.domain.Matchup;
import com.connectcard.domain.State;

public interface RetrieveLines {
    /**
     * This method retrieves cities for the passed-in state
     * @param stateCode the code of the state (ie. GA)
     * @return 
     */
    public List<Matchup> retrieveAllLines();
    
    
    /**
     * Retrieve all US states
     * @return 
     */
    public List<Matchup> retrieveLinesByWeek(short week);
}

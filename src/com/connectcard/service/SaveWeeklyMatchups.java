package com.connectcard.service;

import java.util.ArrayList;
import java.util.List;

import com.connectcard.domain.Matchup;

public interface SaveWeeklyMatchups {

    /**
     * This method retrieves cities for the passed-in state
     * @param stateCode the code of the state (ie. GA)
     * @return 
     */
    public Long saveAllWeeklyMatcups(ArrayList<Matchup>matchups);
 

}

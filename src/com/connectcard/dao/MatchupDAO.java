package com.connectcard.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import com.connectcard.domain.Matchup;

public interface MatchupDAO {
    /**
     * This method gets an initiated SimpleJdbcTemplate
     * @return a SimpleJdbcTemplate
     */
    public SimpleJdbcTemplate getSimpleJdbcTemplateCity();
    
    
    /**
     * Save all Lines to the Database
     * @param matchups the code of the state 
     */
    public Long saveMatchups(ArrayList<Matchup> matchups);
    
    
    public List<Matchup> getMatchups();
	
    public List<Matchup> getMatchupsByGameId(short week);
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}

package com.connectcard.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.connectcard.dao.impl.MatchupDAOImpl;
import com.connectcard.domain.Matchup;
import com.connectcard.service.SaveWeeklyMatchups;

public class SaveWeeklyMatchupsImpl implements SaveWeeklyMatchups {
    @Resource
    private MatchupDAOImpl matchupDAO;
   
   
    @Override
        public Long saveAllWeeklyMatcups(ArrayList<Matchup> matchups) {
    	MatchupDAOImpl matchupDAO = new MatchupDAOImpl();
    	
        return (long) matchupDAO.saveMatcups(matchups); 
        
    }
   
    
    /**
     * This method converts a list of objects into a delimited string
     * @param list the list to convert to a delimited string
     * @param delimiter the delimiter to use
     * @return the list as a delimited string
     */
    private static String convertListToDelimitedStringWithQoutes(List list, String delimiter) {
        StringBuilder sb = new StringBuilder();

        for (Object obj : list) {
            sb.append("\"").append(String.valueOf(obj)).append("\"").append(',');
        }

        sb.deleteCharAt(sb.length() - 1); //delete last comma

        return sb.toString();
    }

  
}

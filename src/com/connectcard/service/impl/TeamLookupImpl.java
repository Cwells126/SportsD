package com.connectcard.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.connectcard.dao.TeamDAO;
import com.connectcard.dao.impl.TeamDAOImpl;
import com.connectcard.domain.Team;
import com.connectcard.service.TeamLookUp;

public class TeamLookupImpl implements TeamLookUp {
	
    @Transactional
    public Team lookUpTeamID(String teamNm) {
    	 TeamDAO teamDAO = new TeamDAOImpl();
        return teamDAO.getTeamIdByTeamNm(teamNm); 
    }

}

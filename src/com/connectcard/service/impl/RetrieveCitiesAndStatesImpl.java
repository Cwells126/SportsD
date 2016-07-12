package com.connectcard.service.impl;

import com.connectcard.dao.impl.CityDAOImpl;
import com.connectcard.dao.impl.StateDAOImpl;
import com.connectcard.domain.City;
import com.connectcard.domain.State;
import com.connectcard.service.RetrieveCitiesAndStates;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class RetrieveCitiesAndStatesImpl implements RetrieveCitiesAndStates {
    @Resource
    private CityDAOImpl cityDAO;
    @Resource
    private StateDAOImpl stateDAO;
    
    
    @Override
        public List<City> retrieveAllCities() {
        //return cityDAO.listCities();
        return null;
    }
    
    
    @Override
    public List<State> retrieveAllStates() {
        return stateDAO.retrieveAllStates(); 
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

package com.connectcard.controller;

import com.connectcard.dao.SchduleDAO;
import com.connectcard.dao.impl.ScheduleDAOImpl;
import com.connectcard.domain.City;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.connectcard.domain.Matchup;
import com.connectcard.domain.Schdule;
import com.connectcard.domain.User;
import com.connectcard.service.LoginUser;
import com.connectcard.service.RetrieveCitiesAndStates;
import com.connectcard.service.RetrieveLines;
import com.connectcard.service.SportsDataProxy;
import com.connectcard.service.impl.RetrieveLinesImpl;
import com.connectcard.service.impl.SportsDataProxyImpl;
import com.connectcard.utility.ServerProxy;
import com.jigy.api.Helpful;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * This class is currently only used for it's static properties; however, it
 * could be used in the future if we decide to include asynchronous file upload
 * or some other enhancement to the calendar related to uploading attachments 
 * asynchronously
 * @author admin
 */
@Controller
public class IndexController extends BaseController {
	

	
    public static final String REDIRECT_URL = "redirectUrl";
    public static final String WEB_PROPERTIES = "web.properties";
    public static final String VALIDATED_PATH_LIST = "validatedPathList";
    public static final String MOBILE_CONTEXT = "mobile/";
    public static final String DESKTOP_CONTEXT = "desktop/";
    public static final String DEVICE_TYPE = "deviceType";
    public static final String SEASON = "2016";
    public static final String key = "56b2609637ab4c9fbbb852e5217eca1f";
    public static final int MOBILE_DEVICE = 1;
    public static final int DESKTOP_DEVICE = 2;
    
    @Resource
    private LoginUser loginUser;
    
    @Autowired
  private RetrieveLinesImpl retrieveLinesImpl;
    
    
    @RequestMapping(value = "/videos.htm")
    public String displayVideos(HttpServletRequest request, HttpServletResponse response) {  
    	 ServerProxy serverProxy = new ServerProxy();
    	 SportsDataProxy sdp = new SportsDataProxyImpl();
    	 short week = 16;
    	 
    	 while (week < 17){
    		    week ++;
    		 String url = "http://killersports.com/nfl/query?sdql=team,%20o:team,%20line%20,%20points,%20o:points%20@week%20=%201%20and%20season%20=%202014%20and%20site%20=%20home";	 
    		// "http://api.sportsdatabase.com/nfl/query.json?sdql=%20team,%20o:team,%20line,points%20,o:points%20@week%20=%20" + week + "%20and%20season%20=%202014%20and%20site%20=%20home&output=json";
    		  //final String src = "http://scores.espn.go.com/nfl/scoreboard";
    		 
    	      Gson gson = new Gson();
    	    
   
    	    try {
    	    	//BufferedReader br = serverProxy.sendGet(url, week); 	
    	    	
    	    	String schdeule = "";
    	    	schdeule= sdp.getSchedule("2016", "JSON", key);
    	    	if (!"".equals(schdeule)){
    	    		Schdule[] enums = gson.fromJson(schdeule, Schdule[].class);
    	    	
    	 	    //convert the json string back to object
        	//	Matchup matchup = gson.fromJson(br, Matchup.class);
        	    
        	//	br.close();
    	    	SchduleDAO schduleDao = new ScheduleDAOImpl();	
        		
    	    	schduleDao.saveMatcups(enums);
    	    	
    	    	week++;
        			
    	    }
    	     }
    			 catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    
    }
         return "videos";
    }
    @RequestMapping(value = "/schedule.htm")
    public String displayLines(HttpServletRequest request, HttpServletResponse response) {   
     ServerProxy serverProxy = new ServerProxy();
     
 	    String url = "http://api.sportsdatabase.com/nfl/query.json?sdql=%20team,%20o:team,%20line,points%20@week%20=%201%20and%20season%20=%202014%20and%20site%20=%20home&output=json";
    	   
    	    
    	    try {
    	    	
   
    	    	RetrieveLinesImpl retrieveLinesImpl = new RetrieveLinesImpl();
    	    	
    	    	
    	    	List<Matchup> matchups =retrieveLinesImpl.retrieveLinesByWeek((short) 10);
    	    	
    	       
    	    	 
			if (matchups != null) {
				Helpful.setObjInSession(request, "matchups", matchups);
				request.setAttribute("matchups", matchups);
				// super.sendJsonToPage(response, request, cities);
			} else {
				super.sendMessageToPageAsJson(response, request, "error",
						"No Matchups Displayed. Please Try Again.");
			}
    	                   
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	    // serverProxy.
        return "schedule";
    }


    
    
    @RequestMapping(value = "/weekChange.htm", method = RequestMethod.GET)
    public @ResponseBody
  String changeWeek(@RequestParam("week") String week ,HttpServletRequest request) {
 

		List<Matchup> matchups = null;
		String matchupsJson = new String();
	    try {
	    	
	    	RetrieveLinesImpl retrieveLinesImpl = new RetrieveLinesImpl();
	    	matchups =retrieveLinesImpl.retrieveLinesByWeek(Short.parseShort(week));
	    	
	       
	    	 
		if (matchups != null) {
			Helpful.setObjInSession(request, "matchups", matchups);
			request.setAttribute("matchups", matchups);
			List<Matchup> check = (List<Matchup>) Helpful.getObjFromSession(request, "matchups");
			 matchupsJson = new Gson().toJson(matchups);;
	
		} else {
//			super.sendMessageToPageAsJson(response, request, "error",
//					"No Matchups Displayed. Please Try Again.");
		}
	                   
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    // serverProxy.
	    
    
	    return matchupsJson;

    }
    
    
    
    /**
     * Class used to update week.  Ajax call is pulling from database. 
     * @author admin
     */
    @RequestMapping(value = "/weekChange.htm2")
    public List<Matchup> changeWeek(HttpServletRequest request, HttpServletResponse response) {   
    	

    		List<Matchup> matchups = null;
    	    
    	    try {
    	    	
    	    	RetrieveLinesImpl retrieveLinesImpl = new RetrieveLinesImpl();
    	    	Integer week = (Integer) request.getAttribute("week");   	
    	    	matchups =retrieveLinesImpl.retrieveLinesByWeek(week.shortValue());    	       
    	    	 
			if (matchups != null) {
				Helpful.setObjInSession(request, "matchups", matchups);
				request.setAttribute("matchups", matchups);
				List<Matchup> check = (List<Matchup>) Helpful.getObjFromSession(request, "matchups");
				 String matchupsJson = new Gson().toJson(matchups);
				  response.getWriter().write(matchupsJson);
				// super.sendJsonToPage(response, request, cities);
			} else {
				super.sendMessageToPageAsJson(response, request, "error",
						"No Matchups Displayed. Please Try Again.");
			}
    	                   
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	    // serverProxy.
    	    
        
    	    return matchups;
    }
    
    
    
    /**
     * stores an upload file to the file system
     * @param request the request object
     */
    @RequestMapping(value = "/index.htm")
    public String displayIndex(HttpServletRequest request, HttpServletResponse response) {
        // get the resolution of screen from the request
        int width = Helpful.getRequestParamIntSafe("width", request);
        int height = Helpful.getRequestParamIntSafe("height", request);
        
        if(width > 1000 || height > 1000){
            Helpful.setObjInSession(request, DEVICE_TYPE, DESKTOP_DEVICE);
        } else {
            Helpful.setObjInSession(request, DEVICE_TYPE, MOBILE_DEVICE);
        }
        
        // put the list of paths to validate in session
        if(request.isRequestedSessionIdValid() && request.getSession().getAttribute(VALIDATED_PATH_LIST) == null){
            Helpful.setObjInSession(request, VALIDATED_PATH_LIST, getValidatedPaths());
        }
       
//       List<City> cities =  retrieveCitiesAndStates.retrieveAllCities();
//       
//       
//       
//               if(cities != null){
//            Helpful.setObjInSession(request, "cities", cities);
//         //   super.sendJsonToPage(response, request, cities);
//        } else {
//            super.sendMessageToPageAsJson(response, request, "error", "No Cities Displayed. Please Try Again.");
//        }
        
        return "index";
    }
    
    
    
    
   
    
    
    
    
    
    /**
     * This method logs the user in
     * @param request the request object
     * @param response the response object
     */
    @RequestMapping(value = "/login.htm")
    public void login(HttpServletRequest request, HttpServletResponse response) {
        User user = loginUser.loginUser("", "");
        if(user != null){
            Helpful.setObjInSession(request, "user", user);
            super.sendJsonToPage(response, request, user);
        } else {
            super.sendMessageToPageAsJson(response, request, "error", "Username/Password Incorrect. Please Try Again.");
        }
    }
        
    
    
    
    /**
     * This method creates a list of paths that need to be validated
     * prior to allowing the user to access them. The spring interceptor
     * will check to make sure the user has logged in before allowing the
     * user access to the pages in this list
     * @return the list of application paths to validate
     */
    public static List<String> getValidatedPaths(){
        List<String> validatedPathList = new ArrayList<String>();
        validatedPathList.add("/connectCard.htm");
      
        return validatedPathList;
    }
}

package com.connectcard.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;

import com.connectcard.domain.City;
import com.connectcard.domain.User;
import com.connectcard.service.LoginUser;
import com.connectcard.service.RetrieveCitiesAndStates;
import com.connectcard.utility.ServerProxy;
import com.jigy.api.Helpful;

public class VideosController  extends BaseController{
	

	
    public static final String REDIRECT_URL = "redirectUrl";
    public static final String WEB_PROPERTIES = "web.properties";
    public static final String VALIDATED_PATH_LIST = "validatedPathList";
    public static final String MOBILE_CONTEXT = "mobile/";
    public static final String DESKTOP_CONTEXT = "desktop/";
    public static final String DEVICE_TYPE = "deviceType";
    public static final int MOBILE_DEVICE = 1;
    public static final int DESKTOP_DEVICE = 2;
    
    @Resource
    private LoginUser loginUser;
    
    @Resource
    private RetrieveCitiesAndStates retrieveCitiesAndStates;
    
    /**
     * This method logs the user in
     * @param request the request object
     * @param response the response object
     */
    @RequestMapping(value = "/videos.htm")
    public String displayVideos(HttpServletRequest request, HttpServletResponse response) {       
    	
    	
    	 ServerProxy serverProxy = new ServerProxy();
    	    String url = "http://api.sportsdatabase.com/nfl/query.json?sdql=date%2Cpoints%2Co%3Apoints%40team%3DBears%20and%20season%3D2011%20and%20site&output=json";
    	   
    	    
    	    try {
    			//serverProxy.sendGet(url);
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	    // serverProxy.
        return "videos";
    
    

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

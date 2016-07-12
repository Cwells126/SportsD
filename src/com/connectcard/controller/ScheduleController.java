package com.connectcard.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.connectcard.service.impl.RetrieveLinesImpl;

public class ScheduleController  extends BaseController{
	

	
    public static final String REDIRECT_URL = "redirectUrl";
    public static final String WEB_PROPERTIES = "web.properties";
    public static final String VALIDATED_PATH_LIST = "validatedPathList";
    public static final String MOBILE_CONTEXT = "mobile/";
    public static final String DESKTOP_CONTEXT = "desktop/";
    public static final String DEVICE_TYPE = "deviceType";
    public static final int MOBILE_DEVICE = 1;
    public static final int DESKTOP_DEVICE = 2;
    
    @Autowired
  private RetrieveLinesImpl retrieveLinesImpl;
   
    
    /**
     * This method logs the user in
     * @param request the request object
     * @param response the response object
     */
    @RequestMapping(value = "/weekChange.htm")
    public String displaySchedule(HttpServletRequest request, HttpServletResponse response) {        
    
    	
    	return "schedule";
   
    }
    
    @RequestMapping
    public @ResponseBody String mydefault() {
        return "schedule";
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

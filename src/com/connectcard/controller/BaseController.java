package com.connectcard.controller;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jigy.api.Helpful;


/**
 * This class serves as the basis for all created controllers. It allows
 * common code to be shared across controller objects
 * @author admin
 */
public class BaseController {
    public static final String JSON_RESPONSE = "jsonResponse";

    /**
     * This method converts the passed in object to json and sends it
     * back to the page
     * @param response the response object
     * @param obj the object to convert to json
     * @throws JsonGenerationException 
     */
    protected void sendJsonToPage(HttpServletResponse response, HttpServletRequest request, Object obj) {  
        Gson gson = new GsonBuilder().create();
        request.setAttribute(JSON_RESPONSE, true);
        Helpful.writeToResponse(response, gson.toJson(obj));
    }
    
    
    /**
     * This method sends a string message to the page
     * as a json object
     * @param response the response object
     * @param key the name to use as the key to access the message on the json object
     * @param message the message to convert to json
     */
    protected void sendMessageToPageAsJson(HttpServletResponse response, HttpServletRequest request, String key, String message) {
        Map<String, String> jsonMap = new HashMap<String, String>();
        jsonMap.put(key, message);
        Gson gson = new GsonBuilder().create();
        request.setAttribute(JSON_RESPONSE, true);
        Helpful.writeToResponse(response, gson.toJson(jsonMap));    
    }
    
    
    /**
     * This method takes the parameters from the request and wraps
     * them into a domain object
     * @param request the request object
     * @param className the qualified name of the domain object
     * @return the populated domain object 
     */
    @SuppressWarnings("rawtypes")
	protected Object convertToDomainObj(HttpServletRequest request, String className){
        Map<String, Method> methodMap = new HashMap<String, Method>();
        Object obj;
        
        // construct the object using the class name
        try {
            obj = Class.forName(className);
        } catch (ClassNotFoundException ex) {
            return null;
        }
        
        // put the setter methods of the object in a map with the method name as the key
        for(Method method : obj.getClass().getMethods()){
            if(method.getName().startsWith("set")){
                 methodMap.put(method.getName().toLowerCase(), method);
            }
        }
        
        // find the method that matches the parameter
        Enumeration<String> paramNames = request.getParameterNames();
        while(paramNames.hasMoreElements()){
            String name = paramNames.nextElement();
            if(methodMap.containsKey("set" + name.toLowerCase())){
                try {
                    Method method = methodMap.get(name);
                   Class[] paramTypes = method.getParameterTypes();
                   if(paramTypes == null || paramTypes.length == 0){
                	   return null;
                   } else {
                	   Class type = paramTypes[0];
                	   method.invoke(obj, type.cast(request.getParameter(name)));
                   }
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(BaseController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(BaseController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvocationTargetException ex) {
                    Logger.getLogger(BaseController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return obj;
    }
}

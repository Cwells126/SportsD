package com.connectcard.utility;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.google.gson.JsonObject;
 
public class CorsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public CorsServlet() {
        super();
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
        //List of allowed origins
        List<String> incomingURLs = Arrays.asList(getServletContext().getInitParameter("incomingURLs").trim().split(","));
 
        
        // Get client's origin
        String clientOrigin = request.getHeader("origin");
        
        // Get client's IP address
        String ipAddress = request.getHeader("x-forwarded-for");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }  
        
        String userId = request.getParameter("userId").trim();
        String password = request.getParameter("password").trim();
 
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        response.setHeader("Cache-control", "no-cache, no-store");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "-1");
        
        int myIndex = incomingURLs.indexOf(clientOrigin);
        //if the client origin is found in our list then give access
        //if you don't want to check for origin and want to allow access 
        //to all incoming request then change the line to this
        //response.setHeader("Access-Control-Allow-Origin", "*");
        if(myIndex != -1){
            response.setHeader("Access-Control-Allow-Origin", clientOrigin);
            response.setHeader("Access-Control-Allow-Methods", "POST");
            response.setHeader("Access-Control-Allow-Headers", "Content-Type");
            response.setHeader("Access-Control-Max-Age", "86400");
        }
 
        //just a fake login - if userId is same as password allow access
        if(userId.equalsIgnoreCase(password)){
 
            JsonObject myObj = new JsonObject();
            myObj.addProperty("success", true);
            out.println(myObj.toString());
 
        }
        else {
            
            JsonObject myObj = new JsonObject();
            myObj.addProperty("success", false);
            out.println(myObj.toString());
 
        }
 
        out.close();
 
    }
 
}

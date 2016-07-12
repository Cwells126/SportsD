package com.connectcard.interceptor;

import com.connectcard.controller.BaseController;
import com.connectcard.controller.IndexController;
import com.jigy.api.Helpful;
import java.util.List;
import java.util.Properties;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author admin
 */
public class SessionValidationInterceptor implements HandlerInterceptor {

    /**
     * This method is called before the request is sent to the controller method. We're using
     * this method in the same way a before aspect could be used to handle cross cutting concerns.
     * Session validation/login can be enforced here to make sure a user cannot access functionality
     * that requires user information without having a valid session. An interceptor was used here
     * instead of an aspect since spring doesn't support aspects on annotated controllers that do not
     * implement a controller interface. All pre-processing code that addresses cross-cutting 
     * functionality should go here
     *
     * @param request the request object
     * @param response the response object
     * @param handler a handle to the controller
     * @return true to allow the request to proceed, false to halt the request
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
        
        // get the request path
        String servletPath = Helpful.toStringSafe(request.getServletPath());
        
        // create a static list of paths that require a user session to be accessed
        List<String> validatedPathList = (List<String>) request.getSession().getAttribute(IndexController.VALIDATED_PATH_LIST);
        if(!request.isRequestedSessionIdValid() || (request.isRequestedSessionIdValid() &&  validatedPathList == null)){
            validatedPathList = IndexController.getValidatedPaths();
        } 
        
        // get the web properties so we know where to redirect the user
        String redirectUrl;
        if(request.isRequestedSessionIdValid() && request.getSession().getAttribute(IndexController.REDIRECT_URL) == null){
            Properties properties = new Properties();
            properties.load(SessionValidationInterceptor.class.getClassLoader().getResourceAsStream(IndexController.WEB_PROPERTIES));
            redirectUrl = properties.getProperty(IndexController.REDIRECT_URL);
        } else {
            redirectUrl = (String) request.getSession().getAttribute(IndexController.REDIRECT_URL);
        }
        
        // if the page the user is trying to access requires login, make sure the user is logged in
        if (servletPath.endsWith(".htm")) {
            if(servletPath == null){
                response.sendRedirect(redirectUrl);
            } else if(validatedPathList.contains(servletPath)){
                // make sure the user has a valid session
                if (request.isRequestedSessionIdValid() && request.getSession().getAttribute("user") != null) {
                  return true;
                } else {
                    // when the session is not valid (eg. session timed out, etc.) redirect user to main calendar page
                    response.sendRedirect(redirectUrl);
                    return false;
                }
            }
        }
        
        return true;
    }
    
    
    /**
     * This method is called after the controller method has processed the
     * request
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
               
        // When the user first requests a page from the site, we are storing the
        // device type in session. Get the device type out of session
        int deviceType = (Integer) request.getSession().getAttribute(IndexController.DEVICE_TYPE);
        
        // transform the model and view to present the page from the correct context
        // if the request has a json_response attribute, it means that we returned json as
        // the response instead of a jsp so we don't need to apply context to the response
        if(request.getAttribute(BaseController.JSON_RESPONSE) == null){
            if(deviceType == IndexController.MOBILE_DEVICE){
                modelAndView.setViewName(IndexController.MOBILE_CONTEXT + modelAndView.getViewName());
            } else if(deviceType == IndexController.DESKTOP_DEVICE){
                modelAndView.setViewName(IndexController.DESKTOP_CONTEXT + modelAndView.getViewName());
            }
        }
    }

    
    /**
     * This method is called after the view has been rendered. This method could
     * be used to handle processing of information that does not necessarily need to be
     * performed in the normal order of the request and can be handled in the background.
     * For example, when saving an event with a new file attached to it, the event information
     * could be saved and then control returned to the page then use this method to handle storage
     * of the file in the background. So in general, any long process that does not have to 
     * be performed during the normal request processing should probably be handled here
     * 
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // System.out.println("After completion handle");
    }
}

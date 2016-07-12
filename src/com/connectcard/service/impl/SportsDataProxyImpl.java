package com.connectcard.service.impl;

//// This sample uses the Apache HTTP client from HTTP Components (http://hc.apache.org/httpcomponents-client-ga/)
import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import com.connectcard.service.SportsDataProxy;

@Component
public class SportsDataProxyImpl implements SportsDataProxy
{
 public String getSchedule(String season,String format,String key) 
 {
     HttpClient httpclient = HttpClients.createDefault();
     String responseString = null;
     

     try
     {
    	 
    	
         URIBuilder builder = new URIBuilder("https://api.fantasydata.net/nfl/v2/" + format + "/Schedules/" + season);


         URI uri = builder.build();
         HttpGet request = new HttpGet(uri);			
         request.setHeader("Ocp-Apim-Subscription-Key", key);
        // request.set

         // Request body
         StringEntity reqEntity = new StringEntity("{body}");
        // ((HttpResponse) request).setEntity(reqEntity);

         HttpResponse response = httpclient.execute(request);
         HttpEntity entity = response.getEntity();

         if (entity != null) 
         {
             
             responseString = EntityUtils.toString(entity);
         }else{
        	 responseString = EntityUtils.toString(entity);
         }
     }
     catch (Exception e)
     {
         System.out.println(e.getMessage());
     }
	return responseString;
 }
}


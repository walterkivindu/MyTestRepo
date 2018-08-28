package com.dynsol.rest;

import org.json.JSONArray;
import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
 

public class MessageJerseyClient {
 
    public static void main(String args[]){
         
        String url = "http://localhost:8080/WebTwo/webapi/messages/database";
        Client restClient = Client.create();
        WebResource webResource = restClient.resource(url);
        ClientResponse resp = webResource.accept("application/json")
                                                    .get(ClientResponse.class);
        if(resp.getStatus() != 200){
            System.err.println("Unable to connect to the server");
        }
        String output = resp.getEntity(String.class);
        System.out.println("response: "+output);
        System.out.println();
        System.out.println("****************************************");
        
        try{
        JSONArray array = new JSONArray(output);
        for (int i = 0; i < array.length(); i++) {
            
            //getting product object from json array
            JSONObject message = array.getJSONObject(i);

            System.out.println();
            System.out.println("Reading JSON Object number: "+i);
            System.out.println("-------------------------------------------");
            System.out.println();

            System.out.println("ID: "+message.getInt("id"));
            System.out.println("NAME: "+message.getString("name"));
            System.out.println("AUTHOR: "+message.getString("author"));
            System.out.println("CREATED ON: "+message.getString("date"));
            
            System.out.println("_________________________________________");
            System.out.println("Completed Reading Object number: "+i);
            System.out.println("------------------------------------------");

        }
        }catch(Exception e){
        	
        	
        }
    }
}

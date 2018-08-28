package com.dynsol.rest;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
 
public class MessageJerseyPostClient {
 
    public static void main(String a[]){
         
        String url = "http://localhost:8080/WebTwo/webapi/messages/postdatabase";
        String jsonInput = "{\"author\":\"Professor Walter\","
        		+ "\"date\":\"Tue 2018.05.10 at 03:19:48 AM EAT\","+
                "\"name\":\"Walter Yule msee\"}";
        Client restClient = Client.create();
        WebResource webResource = restClient.resource(url);
        ClientResponse resp = webResource.type("application/json")
                                    .post(ClientResponse.class, jsonInput);
        if(resp.getStatus() != 200){
            System.err.println("Unable to connect to the server");
        }
        String output = resp.getEntity(String.class);
        System.out.println("response: "+output);
    }
}

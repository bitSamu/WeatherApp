package com.github.bitsamu.weatherapp.http.request;

import com.github.bitsamu.weatherapp.http.response.ResponseHandler;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class RequestHandler {
    private URL url;
    private HttpURLConnection con;

    private ResponseHandler responseHandler;

    private final String BASE_URL = "http://api.weatherapi.com/v1";
    private final String WEATHER_URL = BASE_URL + "/current.json";
    private final String API_KEY = "b511dbd209e24989ba7160703232602";

    Map<String, String> parameters = new HashMap<>();

    public void createHTTPRequest(){

        try {
            url = new URL(WEATHER_URL);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            responseHandler = new ResponseHandler();

            addParametersToList("Bad Leonfelden");
            addRequestParameters(con);

            responseHandler.getFullResponse(con);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addParametersToList(String location){
        parameters.put("key",API_KEY);
        parameters.put("q", location);
    }

    private void addRequestParameters(HttpURLConnection con){

        ParameterStringBuilder parameterStringBuilder = new ParameterStringBuilder();

        try{
            con.setDoOutput(true);
            DataOutputStream out = new DataOutputStream(con.getOutputStream());
            System.out.println(parameterStringBuilder.getParamsString(parameters));
            out.writeBytes(parameterStringBuilder.getParamsString(parameters));
            out.flush();
            out.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

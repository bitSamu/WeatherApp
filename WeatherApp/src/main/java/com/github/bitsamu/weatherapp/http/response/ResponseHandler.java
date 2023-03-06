package com.github.bitsamu.weatherapp.http.response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/**
 * This class handles the response coming from the API.
 * @author Samuel Hofer
 */
public class ResponseHandler {
    /**
     * builds up the full response
     * @param con
     */
    public void getFullResponse(HttpURLConnection con){

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));

            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            System.out.println(response.toString());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

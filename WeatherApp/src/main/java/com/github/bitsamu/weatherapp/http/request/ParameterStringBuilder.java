package com.github.bitsamu.weatherapp.http.request;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * This is a help class for the Request handler.
 * It brings the parameters in the right format.
 * @author Samuel Hofer
 * @see RequestHandler
 */
public class ParameterStringBuilder {

    // set charset to UTF 8
    private final Charset CHARSET = StandardCharsets.UTF_8;

    /**
     * Brings the parameters in the format:
     * q=LOCATION&key=API_KEY
     * @param params
     * @return
     * @throws UnsupportedEncodingException
     */
    public String getParamsString(Map<String, String> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, String> entry : params.entrySet()) {
            result.append(URLEncoder.encode(entry.getKey(), CHARSET));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), CHARSET));
            result.append("&");
        }

        String resultString = result.toString();
        return resultString.length() > 0 ? resultString.substring(0, resultString.length() - 1) : resultString;
    }
}

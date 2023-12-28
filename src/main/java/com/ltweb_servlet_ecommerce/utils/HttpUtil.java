package com.ltweb_servlet_ecommerce.utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.cloudinary.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import static java.nio.charset.StandardCharsets.UTF_8;

public class HttpUtil {

    private String value;

    public HttpUtil (String value) {
        this.value = value;
    }

    public <T> T toModel(Class<T> tClass) {
        try {
            return new ObjectMapper().readValue(value, tClass);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return null;
    }
    public JSONObject toJSONObject() throws UnsupportedEncodingException {
        JSONObject result = new JSONObject(new String(value.getBytes("ISO-8859-1"), StandardCharsets.UTF_8));
        return result;
    }

    public static HttpUtil of (BufferedReader reader) {
        StringBuilder sb = new StringBuilder();
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
        return new HttpUtil(sb.toString());
    }
}

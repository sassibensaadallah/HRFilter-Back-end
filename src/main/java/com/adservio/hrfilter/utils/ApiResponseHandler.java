package com.adservio.hrfilter.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ApiResponseHandler {
    public static ResponseEntity<Object> generateResponse(HttpStatus status, boolean success, String message, Object data){
        Map<String, Object> response = new HashMap<>();
        response.put("status", status.value());
        response.put("success", success);
        response.put("message", message);
        response.put("data", data);
        return new ResponseEntity<Object>(response, status);
    }
}

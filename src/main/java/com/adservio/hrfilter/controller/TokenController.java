package com.adservio.hrfilter.controller;

import com.adservio.hrfilter.utils.ApiResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
@CrossOrigin(origins = "*")
public class TokenController {
    @GetMapping
    public ResponseEntity<Object> verifyToken(){
        return ApiResponseHandler
                .generateResponse(HttpStatus.OK, true,
                        "Token is valid",
                        null);
    }
}

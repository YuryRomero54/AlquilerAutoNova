package com.example.demo.controlador;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
public interface UserRest {

    @PostMapping( "/signUp")
    ResponseEntity<String> signUp(@RequestBody Map<String, String> requestMap);

    @PostMapping("/login")
    ResponseEntity<String> login(@RequestBody Map<String, String> requestMap);
    
   
}





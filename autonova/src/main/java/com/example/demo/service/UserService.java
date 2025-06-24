package com.example.demo.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
	
	ResponseEntity<String> signUp(Map<String,String>requestMap);

	ResponseEntity<String> login(Map<String, String> requestMap);
}

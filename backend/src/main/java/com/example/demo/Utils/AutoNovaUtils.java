package com.example.demo.Utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AutoNovaUtils {


private AutoNovaUtils() {
	
	
}

public static ResponseEntity<String> getResponseEntity (String responseMessage,HttpStatus httpStatus){
	

	  String jsonMessage = "{\"message\":\"" + responseMessage + "\"}";
	   return new ResponseEntity<String>(jsonMessage, httpStatus);
	}
}



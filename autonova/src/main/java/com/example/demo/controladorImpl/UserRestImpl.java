package com.example.demo.controladorImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Constantes.AutoNovaConstantes;
import com.example.demo.Utils.AutoNovaUtils;
import com.example.demo.controlador.UserRest;
import com.example.demo.service.UserService;

@RestController
public class UserRestImpl implements UserRest {
	
	@Autowired
	UserService userService;
	@Override
	public ResponseEntity<String> signUp(Map<String, String> requestMap) {
		try {
		return userService.signUp(requestMap);
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return AutoNovaUtils.getResponseEntity(AutoNovaConstantes.ALGO_SALIO_MAL, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	@Override
	public ResponseEntity<String> login(Map<String, String> requestMap) {
	    try {
	        return userService.login(requestMap);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return AutoNovaUtils.getResponseEntity("Algo salió mal", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}

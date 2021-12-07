package org.spring.boot.starter.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.spring.boot.starter.service.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;


@RestController
@EnableAutoConfiguration
public class LoginControllers {
	
	@Autowired
	TokenGenerator tokenGenerator;
	
	public boolean websso(String username, String password) {
		
		boolean flag = false;
		
		if(username.equals("misha.batra@db.com") && password.equals("1234")) {
			
			flag = true;
		}
		
		if(username.equals("rupali@db.com") && password.equals("12345")) {
			
			flag = true;
		}
		
		return flag;
	}
	
	@RequestMapping("login")
	HashMap<String, String> login(@RequestParam String username, @RequestParam String password) {
		
		HashMap<String, String> response = new HashMap<String, String>();
		
		boolean flag = websso(username, password);
		
		if(flag == true) {
			
			String token = tokenGenerator.generateToken(username);
			response.put("token", token);
		}
		else {
			
			response.put("token", "error");
		}
		
		return response;
	}
}

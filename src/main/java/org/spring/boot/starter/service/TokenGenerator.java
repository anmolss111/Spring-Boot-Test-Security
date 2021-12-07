package org.spring.boot.starter.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class TokenGenerator {

	public String randomString() {
		
		int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 25;
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    String generatedString = buffer.toString();

	    System.out.println(generatedString);
	    
	    return generatedString;
	}
	
	public String generateToken(String username) {
		
		String token = randomString();
		TokenCache.setToken(token, username);
		return token;
	}
}

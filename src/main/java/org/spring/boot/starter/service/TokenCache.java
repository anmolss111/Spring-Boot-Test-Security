package org.spring.boot.starter.service;

import java.util.HashMap;

public class TokenCache {

	private static HashMap<String, String> cache = new HashMap<String, String>();
	
	public static void setToken(String token, String username) {
		
		cache.put(token, username);
	}
	
	public static boolean checkToken(String token) {
		
		boolean flag = false;
		if(cache.containsKey(token)) {
			
			flag = true;
		}
		
		return flag;
	}
}

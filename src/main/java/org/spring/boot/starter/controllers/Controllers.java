package org.spring.boot.starter.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;


@RestController
@EnableAutoConfiguration
public class Controllers {
	
	@RequestMapping("endpoint1")
	HashMap<String, String> endpoint1() {
		HashMap<String, String> response = new HashMap<String, String>();
		response.put("endpoint1", "success");
		return response;
	}
	
	@RequestMapping("endpoint2")
	HashMap<String, String> endpoint2() {
		HashMap<String, String> response = new HashMap<String, String>();
		response.put("endpoint2", "success");
		return response;
	}
	
	@RequestMapping("endpoint3")
	HashMap<String, String> endpoint3() {
		HashMap<String, String> response = new HashMap<String, String>();
		response.put("endpoint3", "success");
		return response;
	}
	
	@RequestMapping("endpoint4")
	HashMap<String, String> endpoint4() {
		HashMap<String, String> response = new HashMap<String, String>();
		response.put("endpoint4", "success");
		return response;
	}
}

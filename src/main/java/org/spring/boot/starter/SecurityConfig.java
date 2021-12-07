package org.spring.boot.starter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.boot.starter.service.TokenCache;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Service
public class SecurityConfig implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory
			.getLogger(SecurityConfig.class);
	
	String authenticatedPaths = "endpoint1,endpoint2";
	
	public boolean checkInAuthenticatedPaths(String path) {
		
		boolean flag = false;
		
		List<String> authenticatedPathsSplit = Arrays.asList(authenticatedPaths.split(","));
		
		if(authenticatedPathsSplit.contains(path)) {
			
			flag = true;
		}
		
		return flag;
	}
	
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
	
		String[] urlSplit = request.getRequestURL().toString().split("/");
		
		String requestingPath = urlSplit[3];
		
		logger.info(requestingPath);
		
		String token = request.getParameter("token");
		
		logger.info(token);
		
		if(checkInAuthenticatedPaths(requestingPath)) {
			
			if(TokenCache.checkToken(token)) {
				
				return true;
			}
			else {
				
				return false;
			}
		}
		else {
			
			return true;
		}
	}

//	@Override
//	public void postHandle(HttpServletRequest request,
//			HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//		
//		String[] urlSplit = request.getRequestURL().toString().split("/");
//		
//		String requestingPath = urlSplit[3];
//		
//		logger.info(requestingPath);
//		
//		System.out.println("Request URL::" + request.getRequestURL().toString()
//				+ " Sent to Handler :: Current Time=" + System.currentTimeMillis());
//		//we can add attributes in the modelAndView and use that in the view page
//	}
//
//	@Override
//	public void afterCompletion(HttpServletRequest request,
//			HttpServletResponse response, Object handler, Exception ex)
//			throws Exception {
//		
//		String[] urlSplit = request.getRequestURL().toString().split("/");
//		
//		String requestingPath = urlSplit[3];
//		
//		logger.info(requestingPath);
//		
//		long startTime = (Long) request.getAttribute("startTime");
//		logger.info("Request URL::" + request.getRequestURL().toString()
//				+ ":: End Time=" + System.currentTimeMillis());
//		logger.info("Request URL::" + request.getRequestURL().toString()
//				+ ":: Time Taken=" + (System.currentTimeMillis() - startTime));
//	}

}
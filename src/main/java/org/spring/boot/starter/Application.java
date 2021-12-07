package org.spring.boot.starter;

import org.spring.boot.starter.controllers.Controllers;
import org.spring.boot.starter.controllers.LoginControllers;
import org.spring.boot.starter.service.TokenGenerator;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = WebConfig.class)
@ComponentScan(basePackageClasses = Controllers.class)
@ComponentScan(basePackageClasses = LoginControllers.class)
@ComponentScan(basePackageClasses = TokenGenerator.class)
@ComponentScan(basePackageClasses = SecurityConfig.class)
public class Application {
	
	public static void main(String[] args) {
		
		SpringApplication.run(Application.class, args);
	}
}

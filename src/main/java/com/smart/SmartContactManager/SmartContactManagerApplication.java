package com.smart.SmartContactManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
   indicates a configuration class that declares one or more @Bans methods and also trigger 
   auto-configuration and component scanning 
 */

@SpringBootApplication
public class SmartContactManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartContactManagerApplication.class, args);
	}
	
}
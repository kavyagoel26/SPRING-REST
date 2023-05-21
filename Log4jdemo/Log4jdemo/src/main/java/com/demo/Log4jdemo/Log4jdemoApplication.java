package com.demo.Log4jdemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Log4jdemoApplication {
	
	static Logger Logger = LogManager.getLogger(Log4jdemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(Log4jdemoApplication.class, args);
		
		System.out.println("Hello...");
		
		Logger.trace("This is an trace msg");
		Logger.debug("This is an debug msg");
		Logger.info("This is an info msg");
		Logger.warn("This is an warn msg");
		Logger.error("This is an error msg");
		Logger.fatal("This is an fatal msg");
	}

}

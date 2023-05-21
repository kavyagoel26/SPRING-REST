package com.demo.Log4jdemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Log4jdemoController {
	static Logger logger = LogManager.getLogger(Log4jdemoApplication.class);
	
	@GetMapping("/hello")
	public String getString() {
		logger.info("Controller Executing ... ");
		return "Hello Kavya";
	}
	

}

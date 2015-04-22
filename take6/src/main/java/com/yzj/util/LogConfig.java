package com.yzj.util;

import org.springframework.stereotype.Component;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

@Component("log")
public class LogConfig {
	
	private static final Logger logger = Logger.getLogger(LogConfig.class);
	
	public LogConfig(){
		PropertyConfigurator.configure("./src/main/resources/config/log4j.properties");
	}

	public Logger getLog(){
	
		return logger;
		
	}

}

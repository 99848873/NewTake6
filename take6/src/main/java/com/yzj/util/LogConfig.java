package com.yzj.util;

import org.springframework.stereotype.Component;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * 工具类,用来导入log4j的配置文件
 * @author 余周锦
 * @version 2.0
 * 2015-4-21
*/
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

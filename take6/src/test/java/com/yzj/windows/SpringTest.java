package com.yzj.windows;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringTest {
	
	@Test
	public void springTest(){
				
		@SuppressWarnings("resource")
		ApplicationContext config  = new ClassPathXmlApplicationContext("config/applicationContext.xml");
		config.getBean("take6");
		config.getBean("mainWindow");
		config.getBean("backGround");
		config.getBean("playPanel");
	}

}

package com.yzj.windows;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yzj.StartSpring;

public class SpringTest {
	
	@Test
	public void springTest(){
		
//		assert StartSpring.getConfig().containsBean("take6");
		
		ApplicationContext config  = new ClassPathXmlApplicationContext("applicationContext.xml");
		
//		assert StartSpring.getConfig().containsBean("mainWindow");
		assert StartSpring.getConfig().containsBean("backGround");
		System.out.println("//////"+config.containsBean("backGround"));
//		assert StartSpring.getConfig().containsBean("desktop");
		
	}

}

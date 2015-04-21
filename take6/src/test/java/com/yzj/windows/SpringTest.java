package com.yzj.windows;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yzj.StartSpring;

public class SpringTest {
	
	@SuppressWarnings("unused")
	@Test
	public void springTest(){
				
		ApplicationContext config  = new ClassPathXmlApplicationContext("applicationContext.xml");
					
	}

}

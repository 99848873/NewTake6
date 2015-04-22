package com.yzj.windows;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yzj.config.Preference;
import com.yzj.util.LogConfig;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/applicationContext*.xml"}) 
public class LogTest {
	
	
	@Resource
	LogConfig log;
	
	@Test
	public void testLog(){
		
		log.getLog().info("测试log功能");
		
		
	}
	

}

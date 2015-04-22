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
public class PreferenceTest {
	
	@Resource
	Preference preference;
	
	@Resource
	LogConfig log;
	
	@Test
	public void testPreference(){
		
		preference.getPf().putInt("time", 0);
				
		log.getLog().info("将配置信息初始化为"+preference.getPf().getInt("time", 0));
		
		
	}
}

package com.yzj.windows;

import org.junit.Test;
import org.junit.rules.Verifier;

import com.yzj.StartSpring;

public class SpringTest {
	
	@Test
	public void springTest(){
		
		assert StartSpring.getConfig().containsBean("take6");
		assert StartSpring.getConfig().containsBean("mainWindow");
		
	}

}

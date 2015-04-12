package com.yzj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 载入spring的配置为文件并且启动Take6程序
 * @author 余周锦
 * @version 2.0
 * 2015-4-12
*/
public class StartSpring {
		
	public static void main(String args[]){
		
		ApplicationContext config = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		config.getBean(Take6.class).start();
		
	}

}

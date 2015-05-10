package com.yzj.config;

import java.util.prefs.Preferences;

import org.springframework.stereotype.Component;

/**
 * 创建偏好设置节点
 * 
 * @author 余周锦
 * @version 2.0 2015-5-10
 */
@Component
public class Preference {
	
	private static final Preferences pf = Preferences.userNodeForPackage(Preference.class);
		
	public void creatDefaultInfo(){
		pf.put("name", "Player");
		pf.put("head", "./src/main/resources/headpic/head1.gif");
	}
	
	public Preferences getPf(){		
		return pf;		
	}

}

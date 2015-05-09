package com.yzj.config;

import java.util.prefs.Preferences;

import org.springframework.stereotype.Component;


@Component
public class Preference {
	
	private static final Preferences pf = Preferences.userNodeForPackage(Preference.class);
		
	public void creatDefaultInfo(){
		pf.put("name", "Player");
		pf.put("head", "./src/main/resources/headpic/head1.png");
	}
	
	public Preferences getPf(){		
		return pf;		
	}

}

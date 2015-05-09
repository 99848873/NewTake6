package com.yzj.windows.internalwindow;

import org.springframework.stereotype.Component;

import com.yzj.api.InternalWindow;

/**
 * 内部制造器
 * 
 * @author 余周锦
 * @version 2.0 2015-5-09
 */
@Component
public class InWindowCreater {

	public InternalWindow create(String name) {

		if (name.equals("preference1")) {
			return createPreferenceWindow(name, false);
		} else if (name.equals("preference1")) {

		}
		return null;
	}

	private InternalWindow createPreferenceWindow(String name, boolean state) {
		InternalWindow preferenceWindow = new PreferenceWindow(name, state);
		return preferenceWindow;
	}

}

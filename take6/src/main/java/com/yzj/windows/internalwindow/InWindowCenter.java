package com.yzj.windows.internalwindow;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.yzj.api.InternalWindow;

/**
 * 内部桌面管理中心,负责管理内部桌面
 * 
 * @author 余周锦
 * @version 2.0 2015-5-09
 */
@Component
public class InWindowCenter {

	@Resource
	private InWindowCreater inWindowCreater;

	private Map<String, InternalWindow> internalWindows = new HashMap<String, InternalWindow>();

	public InternalWindow getInWindow(String name) {
		InternalWindow inWindow = internalWindows.get(name);
		if (inWindow == null) {
			inWindow = inWindowCreater.create(name);
			internalWindows.putIfAbsent(name, inWindow);
		}
		return inWindow;
	}

}

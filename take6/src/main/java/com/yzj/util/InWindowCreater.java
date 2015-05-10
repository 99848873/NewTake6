package com.yzj.util;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.yzj.api.InternalWindow;
import com.yzj.config.Preference;
import com.yzj.windows.internalwindow.ContentWindow;
import com.yzj.windows.internalwindow.PreferenceWindow;

/**
 * 内部制造器
 * 
 * @author 余周锦
 * @version 2.0 2015-5-09
 */
@Component
public class InWindowCreater {
	
	@Resource
	private Preference preference;

	public InternalWindow create(WindowsName name) {

		if (name == WindowsName.FirstPreference) {
			return createPreferenceWindow("firstPreference", false);
		} else if (name.equals("preference")) {
			return createPreferenceWindow("preference", true);
		} else if (name == WindowsName.About) {
			return creatContentWindow("about", "/txt/About", 300);
		} else if (name == WindowsName.Rule) {
			return creatContentWindow("rule", "/txt/Rule", 600);
		}
		return null;
	}

	/**
	 * 创建一个偏好窗体
	 * 
	 * @param name
	 *            窗体名字
	 * @param state
	 *            窗体状态
	 * @return 偏好窗体
	 */
	private InternalWindow createPreferenceWindow(String name, boolean state) {
		PreferenceWindow preferenceWindow = new PreferenceWindow(name, state);
		preferenceWindow.setPreference(preference);
		return preferenceWindow;
	}

	/**
	 * 创建一个内容窗体
	 * 
	 * @param name
	 *            窗体名字
	 * @param path
	 *            窗体内容路径
	 * @param height
	 *            窗体高度
	 * @return 一个内容窗体
	 */
	private InternalWindow creatContentWindow(String name, String path,
			int height) {
		InternalWindow preferenceWindow = new ContentWindow(name, path, height);
		return preferenceWindow;
	}

}

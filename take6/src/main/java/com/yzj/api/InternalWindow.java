package com.yzj.api;

import java.beans.PropertyVetoException;

import javax.swing.JInternalFrame;

/**
 * 内部窗体模板接口
 * 
 * @author 余周锦
 * @version 2.0 2015-5-09
 */
@SuppressWarnings("serial")
public abstract class InternalWindow extends JInternalFrame {

	public InternalWindow(String name) {
		super(name, false, false, false, false);
		try {
			setClosed(true);
		} catch (PropertyVetoException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	public abstract void createContent();

}

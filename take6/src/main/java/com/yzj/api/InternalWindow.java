package com.yzj.api;

import java.beans.PropertyVetoException;

import javax.swing.JInternalFrame;

@SuppressWarnings("serial")
public abstract class InternalWindow extends JInternalFrame {

	public InternalWindow(String name) {
		super(name);
		try {
			setClosed(true);
		} catch (PropertyVetoException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	public abstract void createContent();

}

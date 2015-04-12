package com.yzj;

import java.awt.EventQueue;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.yzj.windows.MainWindow;

/**
 * 启动主界面线程
 * @author 余周锦
 * @version 2.0
 * 2015-4-12
*/
@Controller
public class Take6 {
	
	//自动注入主界面窗口
	@Resource
	private MainWindow mainWindow;
	
	//启动主界面线程
	public void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

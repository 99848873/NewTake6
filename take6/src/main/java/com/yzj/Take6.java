package com.yzj;

import java.awt.EventQueue;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.yzj.api.InternalWindow;
import com.yzj.config.Preference;
import com.yzj.util.LogConfig;
import com.yzj.windows.MainWindow;
import com.yzj.windows.internalwindow.InWindowCenter;

/**
 * 启动主界面线程并判断初始化信息
 * 
 * @author 余周锦
 * @version 2.0 2015-4-12
 */
@Controller
public class Take6 {

	@Resource
	private MainWindow mainWindow;

	@Resource
	private InWindowCenter inWindowCenter;

	@Resource
	private Preference preference;

	@Resource
	private LogConfig log;

	// 启动主界面
	@PostConstruct
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
		judgeState();
	}

	/* 定义判断是否第一次游玩的方法 */
	private void judgeState() {

		int time = preference.getPf().getInt("time", 0);
		if (time == 0) {
			preference.getPf().putInt("time", 1);
			log.getLog().info("第一次启动游戏，初始化用户信息");
			preference.creatDefaultInfo();
			creatPreferenceWindow();
		} else {
			log.getLog().info("不是第一次启动游戏");
			// TODO 需要删掉
			creatPreferenceWindow();
		}

	}

	/* 创建选择头像及编辑用户名的窗口 */
	private void creatPreferenceWindow() {
		InternalWindow inWindow = inWindowCenter.getInWindow("preference1");
		mainWindow.getBackGround().showWindow(inWindow);
	}

}

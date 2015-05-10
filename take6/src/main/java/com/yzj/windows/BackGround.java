package com.yzj.windows;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.beans.Beans;
import java.beans.PropertyVetoException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

import org.springframework.stereotype.Component;

import com.yzj.api.InternalWindow;
import com.yzj.util.InWindowCreater;
import com.yzj.util.LogConfig;
import com.yzj.util.WindowsName;
import com.yzj.windows.internalwindow.ContentWindow;

/**
 * 当前桌面背景，同时也是一个内部桌面
 * 
 * @author 余周锦
 * @version 2.0 2015-4-21
 */
@SuppressWarnings("serial")
@Component
public class BackGround extends JDesktopPane {

	@Resource
	private PlayPanel playPanel;

	@Resource
	private LogConfig log;

	@Resource
	private InWindowCreater inWindowCreater;

	private Map<WindowsName, InternalWindow> internalWindows = new HashMap<WindowsName, InternalWindow>();

	private String backGroundPath;
	
	public BackGround() {
		super();
		setLayer(this, -1);// 设置该Panel在最底层
		this.backGroundPath = "./src/main/resources/syspic/background1.png";
	}

	@PostConstruct
	public void initialize() {
		add(playPanel);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// 覆盖paint钩子刷新界面
		Image backGround = Toolkit.getDefaultToolkit().getImage(backGroundPath);
		super.paintComponent(g);
		int width = this.getParent().getWidth();
		int height = this.getParent().getHeight();
		setBounds(0, 0, width, height);
		if (backGround != null) {
			g.drawImage(backGround, 0, 0, width, height, this);
		}
//		 System.out.println("当前BackGround大小为"+width+"*"+height);
	}

	/**
	 * 显示内部窗口方法
	 * 
	 * @param name
	 *            需要显示的内部窗口名字
	 */
	public void showInWindow(WindowsName name) {
		final InternalWindow internalWindow = getInWindow(name);
		
		if (internalWindow != null && internalWindow.isClosed()) {
			log.getLog().info("开始启动窗口");
			reLocateWindow(internalWindow);
			try {
				internalWindow.setClosed(false);
				internalWindow.setSelected(true);
			} catch (PropertyVetoException e) {
				log.getLog().warn("设置该窗口状态失败");
			}
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						internalWindow.setVisible(true);
					} catch (Exception e) {
						log.getLog().warn("无法显示该窗口");
					}
				}
				
			});

		}
	}

	/**
	 * 获得相应的内部窗体
	 * 
	 * @param name
	 *            需要的内部窗体
	 * @return 内部窗体
	 */
	private InternalWindow getInWindow(WindowsName name) {
		InternalWindow inWindow = internalWindows.get(name);
		
		if (inWindow == null) {
			inWindow = inWindowCreater.create(name);
			add(inWindow);
			inWindow.createContent();
			internalWindows.put(name, inWindow);
		}
		return inWindow;
	}

	/**
	 * 重新定制内部窗体位置
	 * 
	 * @param inWindow
	 */
	private void reLocateWindow(InternalWindow inWindow) {
		
		if (Beans.isInstanceOf(inWindow, ContentWindow.class)) {
			int x = 0;
			int y = 0;
			if (this.getFrontWindow() != null) {
				if (getFrontWindow().isShowing()) {
					x = this.getFrontWindow().getX() - 10;
					y = this.getFrontWindow().getY() + 22;
				}
				inWindow.setLocation(x, y);
			}

		}

	}

	/**
	 * 获得当前第一个内容窗体
	 * 
	 * @return 返回第一个内容窗体
	 */
	private InternalWindow getFrontWindow() {
		JInternalFrame[] inWindows = getAllFrames();
		for (JInternalFrame inWindow : inWindows) {
			if (Beans.isInstanceOf(inWindow, ContentWindow.class))
				return (InternalWindow) inWindow;
		}
		return null;
	}

}

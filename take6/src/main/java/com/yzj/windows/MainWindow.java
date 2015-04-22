package com.yzj.windows;

import java.awt.BorderLayout;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.swing.*;

import org.springframework.stereotype.Component;

import com.yzj.config.Preference;
import com.yzj.util.LogConfig;

import java.awt.Dimension;

//import com.take6.base.action.CreatConfirmWindows;
//import com.take6.base.action.CreatInternalWindows;
//import com.take6.base.action.MusicSelectAction;
//import com.take6.base.action.SystemAction;

/**
 * 实现主界面现实与刷新
 * @author 余周锦
 * @version 2.0
 * 2015-4-12
*/
@SuppressWarnings("serial")
@Component("mainWindow")
public class MainWindow extends JFrame{
	
	
	/** 定义主界面中的桌面变量*/
	@Resource
	private BackGround backGround;
	
	@Resource 
	private Preference preference;
	
	@Resource 
	private LogConfig log;
	
	private int width;
	private int height;
	
	
	/** 定义主界面的有参构造函数
	 * @param title 主界面的题目
	 * */
	public MainWindow(){
		
		super();
				
	}
	
	/** 定义主界面的初始化方法
	 * @param title 初始化的主界面题目
	 * */
	@PostConstruct
	private void initialize(){
			
		//创建主界面并添加一个desktop,需要修改系统图标
		setTitle("谁是牛头王?");
		setBounds(0, 0, 1280, 720);
		setMinimumSize(new Dimension(960, 540));
		setMaximumSize(new Dimension(1280, 720));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		width = this.getWidth();
		height = this.getHeight();
		
		//修改主界面风格
		setLookAndFeel();
		//增加logo
		creatLogo();
		//创建菜单栏
		creatMenu();
					
		getContentPane().setSize(width, height);
		
		getContentPane().add(backGround, BorderLayout.CENTER);
		
		judgeState();
					
	}	

	/** 创建菜单栏的方法 */
	private void creatMenu(){
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		//创建开始菜单
		JMenu strat = new JMenu("开始 (S)");
		strat.setMnemonic('S');
		menuBar.add(strat);
		//创建控制菜单
		JMenu option = new JMenu("选项 (O)");
		option.setMnemonic('C');
		menuBar.add(option);
		//创建帮助菜单
		JMenu help = new JMenu("帮助 (H)");
		help.setMnemonic('H');
		menuBar.add(help);
		
		//创建子菜单游玩模式
		JMenu mode = new JMenu("模式");
		strat.add(mode);
		//创建游玩模式下的菜单项
		JMenuItem singleP = new JMenuItem("单人");
		singleP.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));//增加快捷键
		singleP.setActionCommand("Single Play");
//		singleP.addActionListener(new CreatConfirmWindows(desktop));
		mode.add(singleP);
		//创建游玩模式下的菜单项
		JMenuItem olineP = new JMenuItem("多人");
		olineP.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_MASK));//增加快捷键
		olineP.setActionCommand("Online Play");
//		olineP.addActionListener(new CreatConfirmWindows(desktop));
		mode.add(olineP);
		
		//创建strat下菜单项3
		JMenuItem reset = new JMenuItem("重置");
		reset.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,InputEvent.CTRL_MASK));//增加快捷键
		reset.setActionCommand("Reset");
//		reset.addActionListener(new SystemAction(desktop));
		strat.add(reset);
		//创建strat下菜单项4
		JMenuItem exit = new JMenuItem("退出");
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
		exit.setActionCommand("Exit");
//		exit.addActionListener(new SystemAction(desktop));
		strat.add(exit);
		
		//创建背景音乐下菜单
		JRadioButtonMenuItem musicoption = new JRadioButtonMenuItem("背景音乐");
		musicoption.setSelected(true);
		musicoption.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,InputEvent.CTRL_MASK));
//		musicoption.addItemListener(new MusicSelectAction(musicoption));
		option.add(musicoption);	
		
		JMenuItem changeUserInfo = new JMenuItem("用户信息");
		changeUserInfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,InputEvent.CTRL_MASK));//增加快捷键
		changeUserInfo.setActionCommand("changeUserInfo");
//		changeUserInfo.addActionListener(new CreatInternalWindows(desktop));
		option.add(changeUserInfo);
		//创建help下菜单项5
		JMenuItem rule = new JMenuItem("规则");
		rule.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,InputEvent.CTRL_MASK));//增加快捷键
		rule.setActionCommand("Rule");
//		rule.addActionListener(new CreatInternalWindows(desktop));
		help.add(rule);
		//创建help下菜单项6
		JMenuItem about = new JMenuItem("关于");
		about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
//		about.addActionListener(new CreatInternalWindows(desktop));
		about.setActionCommand("About");;
		help.add(about);
	}
	
	/** 定义判断是否第一次游玩的方法 */
	private void judgeState(){

		int time = preference.getPf().getInt("time", 0 );
		
		if(time == 0){
			
			preference.getPf().putInt("time", 1);
			log.getLog().info("第一次启动游戏，默认初始化用户信息");
			preference.creatDefaultInfo();
					
		}else{
						
			log.getLog().info("不是第一次启动游戏，初始化用户信息");
		
		}

	}
	
	/**创建主界面图标*/
	private void creatLogo(){
		
		ImageIcon icon = new ImageIcon("./src/main/resources/logo.png");
		setIconImage(icon.getImage());
		
	}
	
	/**修改界面皮肤*/
	private void setLookAndFeel() {
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}

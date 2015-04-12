package com.yzj.windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MainWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("游戏");
		menuBar.add(menu);
		
		JMenu menu_1 = new JMenu("开始游戏");
		menu.add(menu_1);
		
		JMenuItem menuItem = new JMenuItem("单人游戏");
		menu_1.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("多人游戏");
		menu_1.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("重置游戏");
		menu.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("退出");
		menu.add(menuItem_3);
		
		JMenu menu_2 = new JMenu("配置");
		menuBar.add(menu_2);
		
		JMenu menu_3 = new JMenu("游戏音乐");
		menu_2.add(menu_3);
		
		JMenuItem menuItem_6 = new JMenuItem("开背景音乐");
		menu_3.add(menuItem_6);
		
		JMenuItem menuItem_7 = new JMenuItem("关背景音乐");
		menu_3.add(menuItem_7);
		
		JMenuItem menuItem_5 = new JMenuItem("个人信息");
		menu_2.add(menuItem_5);
		
		JMenu menu_4 = new JMenu("帮助");
		menuBar.add(menu_4);
		
		JMenuItem menuItem_4 = new JMenuItem("游戏规则");
		menu_4.add(menuItem_4);
		
		JMenuItem mntmtake = new JMenuItem("关于Take6");
		menu_4.add(mntmtake);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}

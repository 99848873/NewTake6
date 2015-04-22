package com.yzj.windows;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.swing.JDesktopPane;

import org.springframework.stereotype.Component;


/**
 * 当前桌面背景，同时也是一个内部桌面
 * @author 余周锦
 * @version 2.0
 * 2015-4-21
*/
@SuppressWarnings("serial")
@Component
public class BackGround extends JDesktopPane{
	
	@Resource
	private PlayPanel playPanel;
	
	private int width;
	private int height;
	private Image backGround;
	
	public BackGround(){
		super();
		setLayer(this, 0);//设置该Panel在最底层  
		backGround = Toolkit.getDefaultToolkit().getImage("./src/main/resources/syspic/background1.png");		
	}
	
	
	@PostConstruct
	public void initialize(){
		add(playPanel);
	}
		
	@Override
	protected void paintComponent(Graphics g) {
		//覆盖paint钩子刷新界面
		super.paintComponent(g);
		width = this.getParent().getWidth();
		height = this.getParent().getHeight();
		if(backGround !=null){
			g.drawImage(backGround, 0, 0, width, height, this);
		}
//		System.out.println("当前BackGround大小为"+width+"*"+height);
	}

}

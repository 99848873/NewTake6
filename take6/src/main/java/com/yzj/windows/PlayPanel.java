package com.yzj.windows;

import java.awt.Graphics;

import javax.swing.JLayeredPane;

import org.springframework.stereotype.Component;

/**
 * 游玩区域的分层Panel，用来放置用户信息和扑克牌等组件
 * @author 余周锦
 * @version 2.0
 * 2015-4-21
*/
@SuppressWarnings("serial")
@Component
public class PlayPanel extends JLayeredPane {
	
	private int width;
	private int height;
	
	public PlayPanel(){		
		super();
		setOpaque(false);		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		//覆盖paint钩子刷新界面
		super.paintComponent(g);
		width = this.getParent().getWidth();
		height = this.getParent().getHeight();
		setSize(width,height);
		System.out.println("当前PlayPanel大小为"+width+"*"+height);
		
	}

}

package com.yzj.windows;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.JLayeredPane;

import com.yzj.util.DirList;

public class BackGround extends JLayeredPane {
	
	private Image backGround;
	
	public BackGround(){
		super();
		setLayer(this, 0);//设置该Panel在最底层
		//打印当前目录位置
//		DirList.fileList(".");		  
		backGround = Toolkit.getDefaultToolkit().getImage("./src/main/resources/background1.png");		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO 自动生成的方法存根
		super.paintComponent(g);
		int width = this.getParent().getWidth();
		int height = this.getParent().getHeight();
		if(backGround !=null){
			g.drawImage(backGround, 0, 0, width, height, this);
		}
		
	}

}

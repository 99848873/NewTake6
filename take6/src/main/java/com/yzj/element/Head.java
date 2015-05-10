package com.yzj.element;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 实现创建玩家头像的代码
 * 
 * @author 余周锦
 * @version 2.0 2015-05-10
 */
@SuppressWarnings("serial")
public class Head extends JLabel {

	/** 定义私有变量，获得图片位置 */
	private String headPath;

	/**
	 * 定义私有变量，获得图片位置
	 * 
	 * @param pathName
	 *            图片位置
	 * */
	public Head(String headPath) {
		this.headPath = headPath;	
		setSize(100, 100);
		Image head = Toolkit.getDefaultToolkit().getImage(headPath);
		ImageIcon icon = new ImageIcon(head);
		setIcon(icon);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int parentWidth = this.getParent().getWidth();
		int x = (parentWidth-100)/2;
		setLocation(x, 10);
	}

	public String getHeadPath() {
		return headPath;
	}

	public void setHeadPath(String headPath) {
		this.headPath = headPath;
	}
	
}

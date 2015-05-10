package com.yzj.windows.internalwindow;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

import com.yzj.api.InternalWindow;

@SuppressWarnings("serial")
public class ContentWindow extends InternalWindow {

	private String path;
	private int height;

	public ContentWindow(String name, String path, int height) {
		super(name);
		if (name.equals("about")) {
			setTitle("关于");
		} else
			setTitle("规则");
		this.path = path;
		this.height = height;
	}

	@Override
	protected void setDisLocation() {
		int parentWidth = this.getParent().getWidth();
		int x = parentWidth - 50;
		setBounds(x, 0, 500, height);
	}

	@Override
	protected void iniContent() {
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		InputStream filePath = this.getClass().getResourceAsStream(path);
		
		try {
			BufferedReader bufferRead = new BufferedReader(
					new InputStreamReader(filePath, "UTF-8"));
			String content = null;
			while ((content = bufferRead.readLine()) != null) {
				textArea.append(content);
				textArea.append("\n");
			}
			textArea.setCaretPosition(0);
			bufferRead.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(textArea);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		getContentPane().add(scrollPane);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 2,
				SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, -2,
				SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 2,
				SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -2,
				SpringLayout.SOUTH, getContentPane());
	}

}

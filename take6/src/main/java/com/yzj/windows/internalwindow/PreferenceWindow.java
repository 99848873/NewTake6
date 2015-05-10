package com.yzj.windows.internalwindow;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.yzj.api.InternalWindow;
import com.yzj.config.Preference;
import com.yzj.element.Head;
import com.yzj.util.HeadCreater;
import javax.swing.BoxLayout;

/**
 * 偏好设置内部窗口
 * 
 * @author 余周锦
 * @version 2.0 2015-5-09
 */
@SuppressWarnings("serial")
public class PreferenceWindow extends InternalWindow {

	private Preference preference;

	private boolean state;

	public PreferenceWindow(String name, boolean state) {
		super(name);
		this.state = state;
		setTitle("偏好设置");
		setClosable(state);
	}

	@Override
	protected void setDisLocation() {
		int parentWidth = this.getParent().getWidth();
		int parentHeight = this.getParent().getHeight();
		int width = parentWidth / 4;
		int height = parentHeight / 2;
		int x = parentWidth * 3 / 8;
		int y = parentHeight * 1 / 4;
		setBounds(x, y, width, height);
		getContentPane().setSize(width, height);
	}

	@Override
	protected void iniContent() {

		JPanel hintPanel = new JPanel();
		getContentPane().add(hintPanel, BorderLayout.NORTH);
		JLabel hintlabel = new JLabel("您可以修改昵称以及头像");
		hintlabel.setHorizontalAlignment(SwingConstants.CENTER);
		hintPanel.add(hintlabel);

		//TODO 修改infoPanel的布局,让布局更清爽
		JPanel infoPanel = new JPanel();
		getContentPane().add(infoPanel, BorderLayout.CENTER);
		Head head = HeadCreater.creatHead(preference.getPf().get("head",
				"./src/main/resources/headpic/head1.gif"));
		infoPanel.add(head);
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.X_AXIS));

		
//		JButton changeButton = new JButton("修改");
		
		// 创建按钮区域
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);

		JButton confirmButton = new JButton("确认信息");
		confirmButton.setActionCommand("confirm");
		// confirmButton.addActionListener(new InputPlayerInformation(desktop,
		// head, nameText, this));

		buttonPanel.add(confirmButton);

		if (!state) {
			JButton hintButton = new JButton("查看规则");
			hintButton.setActionCommand("Rule");
			// hintButton.addActionListener(new CreatInternalWindows(desktop));
			buttonPanel.add(hintButton);
		}



	}

	public void setPreference(Preference preference) {
		this.preference = preference;
	}

}

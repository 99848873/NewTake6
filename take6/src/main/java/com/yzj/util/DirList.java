package com.yzj.util;

import java.io.File;

/**
 * 工具类，用来查看当前类路径
 * 
 * @author 余周锦
 * @version 2.0 2015-4-21
 */
public class DirList {

	public static void fileList(String path) {
		File file = new File(path);
		String[] list = file.list();
		for (String dirItem : list)
			System.out.println(dirItem);
	}

}

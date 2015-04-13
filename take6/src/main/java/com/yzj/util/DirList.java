package com.yzj.util;

import java.io.File;

public class DirList {
	
	public static void fileList(String path){
		
		File file = new File(path);		
		String[] list = file.list();
		for(String dirItem : list)
		   System.out.println(dirItem);
		
	}

}

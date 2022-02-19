package com.vamshi.proj;

import java.io.File;

public class FileSearcher {

	public static void main(String[] args){
		
		String url="/home/vvkvrk";
       
		File file = new File(url);
		getfiles(file, "s");

	}

	public static void getfiles(File file, String searchfile) {

		File[] files = file.listFiles();

		if (files != null) {
			for (File file2 : files) {
				if (file2.isDirectory() && !file2.isHidden()) {
					getfiles(file2, searchfile);
				}

				if (file2.isFile()&&file2.getName().startsWith(searchfile)) {
					
						System.out.println(file2.getAbsolutePath());
					

				}
			}

		}
	}
}

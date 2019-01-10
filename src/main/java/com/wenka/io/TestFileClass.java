package com.wenka.io;

import java.io.File;

public class TestFileClass {
	
	private static int count = 0;
	
	public static void main(String[] args) {
		File file = new File("./");
		readJavaFile(file);
		System.out.println("一共有[" + count + "]个java文件！");
	}
	
	public static void readJavaFile(File file){
		File[] listFiles = file.listFiles();
		for (File f : listFiles) {
//			System.out.println(f.getName() + "-->" + f.isDirectory() + "-->" + f.isFile());
			if (f.isDirectory()) {
				readJavaFile(f);
			}
			if (f.isFile() && f.getName().endsWith(".java")) {
				count++;
				System.out.println(f.getAbsolutePath());
			}
		}
	}
	
}

package com.wenka.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TestCopyFile {
	public static void main(String[] args) {
		File file = new File("./IMG_2376.PNG");
		try {
			copy(file, "H:/a.PNG");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void copy(File file,String savePath) throws IOException{
		InputStream inputStream = new FileInputStream(file);
		OutputStream outputStream = new FileOutputStream(new File(savePath));
		
		byte[] buffer = new byte[1024];
		int len = 0;
		
		while ((len = inputStream.read(buffer)) != -1) {
			System.out.println(len);
			outputStream.write(buffer, 0, len);
		}
		
		inputStream.close();
		outputStream.close();
	}
	
}

package com.yufeng.blog.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.lang.StringUtils;

public class ReadFileUtil {
	protected OutputStream output;//输入流
	protected String filename;//文件全路径
	protected int size=1024;//每次读写字节数
	public void setOutput(OutputStream output) {
		this.output = output;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public void readFile() throws IOException{
		if(output==null||StringUtils.isBlank(filename)){
			throw new RuntimeException("未赋初值");
		}
		FileInputStream fin = new FileInputStream(new File(filename));
		byte[] bytes = new byte[size];
		int flag  = 0;
		while((flag = fin.read(bytes))>0 ){
			output.write(bytes);
			output.flush();
		}
		fin.close();
	}
	
	
}

package com.yufeng.blog.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.lang.StringUtils;
/**
 * 全路径，将文件输出，不做任何判断
 * @author Feng
 *
 */
public class WriteFileUtil {
	protected InputStream input;//输入流
	protected String filename;//文件全路径
	protected int size=1024;//每次读写字节数
	public void setInput(InputStream input) {
		this.input = input;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFileName(){
		return filename;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public void writeFile() throws IOException{
		if(input==null||StringUtils.isBlank(filename)){
			throw new RuntimeException("未赋初值");
		}
		String dirName = filename.substring(0,(filename.lastIndexOf('/')<0?filename.lastIndexOf('\\'):filename.lastIndexOf('/')));
		System.out.println(dirName);
		File dir = new File(dirName);
		if(!dir.exists()){
			dir.mkdirs();
		}
		FileOutputStream fout = new FileOutputStream(new File(filename));
		byte[] bytes = new byte[size];
		int flag  = 0;
		while((flag = input.read(bytes))>0 ){
			fout.write(bytes);
			fout.flush();
		}
		fout.close();
	}
	public static void main(String[] args) throws IOException {
		File file = new File("D:\\J2EE\\jboss7.1.1\\standalone\\deployments\\LinkModule.war\\/upload/picture");
		System.out.println(file.exists());
		file.mkdirs();
	}
}

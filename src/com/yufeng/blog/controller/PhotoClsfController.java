package com.yufeng.blog.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.yufeng.blog.model.Photo;
import com.yufeng.blog.model.PhotoClsf;
import com.yufeng.blog.service.PhotoClsfService;
import com.yufeng.blog.service.PhotoService;

/**
 * 
 * @author Feng
 *
 */
public class PhotoClsfController {
	protected PhotoClsf current = new PhotoClsf();//当前要处理的分类对象
	protected List<PhotoClsf> sons;//当前分类的子类，使用延迟加载，所以显示子类需要先查询（可以先不做，直接加载所有分类）
	protected List<PhotoClsf> parents = new ArrayList<PhotoClsf>();
	protected String pid;//记录父类ID，用于查找父类
	@Inject
	protected PhotoClsfService service;
	@Inject
	protected PhotoService photoService;
	
	public List<PhotoClsf> getAll(){
		return service.queryAll();
	}
	/**
	 * 添加新的分类
	 * @return
	 * 2016年8月29日  下午8:17:50
	 * @author yufeng
	 */
	public String add(){
		service.addClsf(current,pid);
		return "";
	}
	public String update(){
		service.updateClsf(current,pid);
		return "";
	}
	public String delete(){
		service.deleteClsf(pid);
		return "";
	}
	/**
	 * 获取当前分类的博文
	 * @return
	 * 2016年8月29日  下午9:08:04
	 * @author yufeng
	 */
	public List<Photo> getPhotos(){
		return photoService.queryByClsf(current.getPcid(),null);
	}
	public PhotoClsf getCurrent() {
		return current;
	}
	public void setCurrent(PhotoClsf current) {
		this.current = current;
	}
	public List<PhotoClsf> getSons() {
		return sons;
	}
	public void setSons(List<PhotoClsf> sons) {
		this.sons = sons;
	}
	public List<PhotoClsf> getParents() {
		return parents;
	}
	public void setParents(List<PhotoClsf> parents) {
		this.parents = parents;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public PhotoClsfService getService() {
		return service;
	}
	public void setService(PhotoClsfService service) {
		this.service = service;
	}
	public PhotoService getPhotoService() {
		return photoService;
	}
	public void setPhotoService(PhotoService photoService) {
		this.photoService = photoService;
	}
}

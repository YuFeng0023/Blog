package com.yufeng.blog.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.UploadedFile;

import com.yufeng.blog.model.Link;

@ManagedBean(name="link")
public class LinkController {
	protected UploadedFile photo;//用于上传文件
	protected List<Link> links ;//用于显示列表
	protected Link link;//用于添加\修改链接
	
	/**
	 * 加载所有友情链接
	 * 
	 * 2016年8月27日  下午9:03:38
	 * @author yufeng
	 */
	protected void list(){
		
	}
	protected String add(){
		return "";
	}
	protected String update(){
		return "";
	}
	protected String delete(){
		return "";
	}
	
	public UploadedFile getPhoto() {
		return photo;
	}
	public void setPhoto(UploadedFile photo) {
		this.photo = photo;
	}
	public List<Link> getLinks() {
		return links;
	}
	public void setLinks(List<Link> links) {
		this.links = links;
	}
	public Link getLink() {
		return link;
	}
	public void setLink(Link link) {
		this.link = link;
	}
}

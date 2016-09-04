package com.yufeng.blog.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import com.yufeng.blog.model.Photo;
import com.yufeng.blog.model.PageBean;
import com.yufeng.blog.service.PhotoService;
@ManagedBean(name="pc")
@RequestScoped
public class PhotoController {
	protected Photo photo = new Photo();
	protected List<Photo> photos ;
	protected PageBean page;//分页用,预留，可以不用
	protected String keyword;//检索关键字
	protected String pcid;//分类号ID
	@Inject
	protected PhotoService service ;
	/**
	 * 添加图书
	 * @return
	 * 2016年8月25日  下午3:16:43
	 * @author yufeng
	 */
	public String add(){
		service.add(photo);
		return "";
	}
	public String update(){
		service.add(photo);
		return "";
	}
	/**
	 * 查询图书，将结果存入photos中
	 * 
	 * 2016年8月27日  上午10:05:37
	 * @author yufeng
	 */
	public void query(){
		this.photos = service.query(keyword, page);
	}
	/**
	 * 页面跳转，将结果写入photos中
	 * 
	 * 2016年8月27日  上午10:06:32
	 * @author yufeng
	 */
	public void toPage(int index){
		this.photos = service.list(page);
	}
	/**
	 * 根据分类ID获取对应图片
	 * @return
	 * 2016年8月30日  下午3:38:48
	 * @author yufeng
	 */
	public List<Photo> getPhotos(){
		return service.queryByClsf(pcid,null);
	}
	public Photo getPhoto() {
		return photo;
	}
	public void setPhoto(Photo photo) {
		this.photo = photo;
	}
	public PageBean getPage() {
		return page;
	}
	public void setPage(PageBean page) {
		this.page = page;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getPcid() {
		return pcid;
	}
	public void setPcid(String pcid) {
		this.pcid = pcid;
	}
	public PhotoService getService() {
		return service;
	}
	public void setService(PhotoService service) {
		this.service = service;
	}
	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}
}

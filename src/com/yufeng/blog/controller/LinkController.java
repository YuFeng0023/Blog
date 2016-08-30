package com.yufeng.blog.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.UploadedFile;

import com.yufeng.blog.model.Link;
import com.yufeng.blog.service.LinkService;
import com.yufeng.blog.utils.GetServerLocation;
import com.yufeng.blog.utils.WriteFileUtil;

@ManagedBean(name="link")
@RequestScoped
public class LinkController {
	protected UploadedFile photo;//用于上传文件
	protected List<Link> links ;//用于显示列表
	protected Link link = new Link();//用于添加\修改链接
	@ManagedProperty(value = "#{linkService}")
	protected LinkService service ;
	/**
	 * @return
	 * 2016年8月28日  下午2:14:51
	 * @author yufeng
	 */
	public String addLink(){
		System.out.println(link);
		WriteFileUtil writer = new WriteFileUtil();
		if(photo!=null){
			try {
				//设置输入流
				writer.setInput(photo.getInputstream());
				//设置文件名
				String prefix = GetServerLocation.getServerLocation();
				prefix+="/upload/picture/"+UUID.randomUUID();
				String tmpName = photo.getFileName();
				tmpName = tmpName.substring( (tmpName.lastIndexOf('\\')<0?tmpName.lastIndexOf('/'):tmpName.lastIndexOf('\\'))+1 );
				writer.setFilename(prefix+tmpName);		
				//写文件
				writer.writeFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			String fileName = writer.getFileName();
			link.setPicUrl(fileName.substring(fileName.indexOf("/upload/picture/")));
		}else{
			link.setPicUrl("javascript:;");
		}
		service.add(link);
		return "/modules/link/listLink.xhtml";
		
	}
	/**
	 * 加载所有友情链接
	 * 
	 * 2016年8月27日  下午9:03:38
	 * @author yufeng
	 */
	public void list(){
		this.links = service.list();
	}
	public String update(String... ids){
		System.out.println(ids);
		return "";
	}
	public String delete(String... ids){
		System.out.println(ids);
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
	public LinkService getService() {
		return service;
	}
	public void setService(LinkService service) {
		this.service = service;
	}
}

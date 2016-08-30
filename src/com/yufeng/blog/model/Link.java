package com.yufeng.blog.model;

import java.io.Serializable;

import javax.persistence.*;

/**
 * 友情链接
 * @author yufeng
 */
@Entity
public class Link implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6349378417460759195L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Integer lid;
	protected String picUrl;
	protected String label;
	protected String url;
	public Integer getLid() {
		return lid;
	}
	public void setLid(Integer lid) {
		this.lid = lid;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "Link [lid=" + lid + ", picUrl=" + picUrl + ", label=" + label
				+ ", url=" + url + "]";
	}
	public void copy(Link link) {
		this.lid = link.lid;
		this.picUrl = link.picUrl;
		this.label = link.label;
		this.url = link.url;
	}
	
}

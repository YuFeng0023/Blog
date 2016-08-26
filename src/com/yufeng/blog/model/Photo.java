package com.yufeng.blog.model;

import java.util.Date;

public class Photo {
	protected String pid;
	protected PhotoClsf pcid;
	protected String url;
	protected User uid;
	protected Date date;
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public PhotoClsf getPcid() {
		return pcid;
	}
	public void setPcid(PhotoClsf pcid) {
		this.pcid = pcid;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public User getUid() {
		return uid;
	}
	public void setUid(User uid) {
		this.uid = uid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}

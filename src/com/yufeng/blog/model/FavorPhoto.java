package com.yufeng.blog.model;

public class FavorPhoto {
	protected String faid;
	protected User uid;
	protected Photo pid;
	public String getFaid() {
		return faid;
	}
	public void setFaid(String faid) {
		this.faid = faid;
	}
	public User getUid() {
		return uid;
	}
	public void setUid(User uid) {
		this.uid = uid;
	}
	public Photo getPid() {
		return pid;
	}
	public void setPid(Photo pid) {
		this.pid = pid;
	}
}

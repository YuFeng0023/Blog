package com.yufeng.blog.model;

public class FavorArticle {
	protected String faid;
	protected User uid;
	protected Article aid;
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
	public Article getAid() {
		return aid;
	}
	public void setAid(Article aid) {
		this.aid = aid;
	}
}

package com.yufeng.blog.model;

import java.util.Date;
import java.util.List;

public class Article {
	protected String aid;
	protected String title;
	protected ArticleClsf acid;
	protected String content;
	protected User uid;
	protected Date date;
	protected List<Comment> comments;
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public ArticleClsf getAcid() {
		return acid;
	}
	public void setAcid(ArticleClsf acid) {
		this.acid = acid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
}

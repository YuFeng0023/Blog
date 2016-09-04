package com.yufeng.blog.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
@Entity
public class Article implements Serializable {
	private static final long serialVersionUID = -2904289241662026886L;
	@Id
	protected String aid;
	protected String title;
	protected ArticleClsf acid;
	protected String content;
	protected User uid;
	@Temporal(TemporalType.TIMESTAMP)
	protected Date date;
	@OneToMany(cascade=CascadeType.REMOVE)
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
	@Override
	public String toString() {
		return "Article [aid=" + aid + ", title=" + title + ", acid=" + acid
				+ ", content=" + content + ", uid=" + uid + ", date=" + date
				+ ", comments=" + comments + "]";
	}
}

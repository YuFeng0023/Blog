package com.yufeng.blog.model;

import java.util.Date;

import javax.persistence.*;
@Entity
public class Comment {
	@Id
	protected String cid;
	@ManyToOne
	@JoinColumn
	protected Article aid;
	protected String label;
	@Temporal(TemporalType.TIMESTAMP)
	protected Date date;
	@JoinColumn(nullable=true)
	@ManyToOne
	protected User uid;
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public Article getAid() {
		return aid;
	}
	public void setAid(Article aid) {
		this.aid = aid;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public User getUid() {
		return uid;
	}
	public void setUid(User uid) {
		this.uid = uid;
	}
	
}

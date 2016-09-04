package com.yufeng.blog.model;

import java.util.Date;

import javax.persistence.*;
@Entity
@Table
public class Contract {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int cid;
	protected String nickname;
	@Temporal(TemporalType.TIMESTAMP)
	protected Date date;
	protected String content;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public void copy(Contract contract) {
		this.cid = contract.cid;
		this.nickname = contract.nickname;
		this.date = contract.date;
		this.content = contract.content;
	}
}

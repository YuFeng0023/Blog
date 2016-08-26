package com.yufeng.blog.model;

public class User {
	protected int uid;
	protected String username;
	protected String password;
	protected String nickname;
	protected String hphoto;
	protected int level;
	protected UserDetail detail = new UserDetail();
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getHphoto() {
		return hphoto;
	}
	public void setHphoto(String hphoto) {
		this.hphoto = hphoto;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public UserDetail getDetail() {
		return detail;
	}
	public void setDetail(UserDetail detail) {
		this.detail = detail;
	}
}

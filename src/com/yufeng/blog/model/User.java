package com.yufeng.blog.model;

import java.io.Serializable;

import javax.persistence.*;

import org.apache.commons.lang.StringUtils;
@Entity
public class User implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8701904977274817184L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int uid;
	@Column(nullable=false,unique=true)
	protected String username="";
	protected String password = "";
	protected String nickname;
	protected String hphoto;
	protected int level;
	@OneToOne(cascade=CascadeType.REMOVE)
	@JoinColumn
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
		if(StringUtils.isBlank(password)){
			return ;
		}
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		if(StringUtils.isBlank(nickname)){
			return;
		}
		this.nickname = nickname;
	}
	public String getHphoto() {
		return hphoto;
	}
	public void setHphoto(String hphoto) {
		if(StringUtils.isBlank(hphoto)){
			return;
		}
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
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password="
				+ password + ", nickname=" + nickname + ", hphoto=" + hphoto
				+ ", level=" + level + ", detail=" + detail + "]";
	}
}

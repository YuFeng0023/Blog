package com.yufeng.blog.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.apache.commons.lang.StringUtils;
@Entity
public class UserDetail implements Serializable {
	private static final long serialVersionUID = -4763801938605028646L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int udid;
	@Column(nullable=true,unique=true)
	protected String email;
	protected String phone;
	@Temporal(TemporalType.DATE)
	protected Date brithday;
	protected String gender="男";
	protected String question;
	protected String answer;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if(StringUtils.isBlank(email)){
			return ;
		}
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		if(StringUtils.isBlank(phone)){
			return ;
		}
		this.phone = phone;
	}
	public Date getBrithday() {
		return brithday;
	}
	public void setBrithday(Date brithday) {
		if(brithday==null){
			return ;
		}
		this.brithday = brithday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		if(StringUtils.isBlank(gender)){
			return ;
		}
		this.gender = gender;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		if(StringUtils.isBlank(question)){
			return ;
		}
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		if(StringUtils.isBlank(answer)){
			return ;
		}
		this.answer = answer;
	}
	public int getId() {
		return udid;
	}
	public void setId(int id) {
		this.udid = id;
	}
}

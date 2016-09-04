package com.yufeng.blog.model;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="sq")
@ApplicationScoped
public class SecurityQuestion {
	private static List<String> questions = new ArrayList<String>();
	static{
		questions.add("你的第一个电话号码是什么？");
		questions.add("你的常用航旅号码是什么？");
	}
	public List<String> getQuestions() {
		return questions;
	}
} 

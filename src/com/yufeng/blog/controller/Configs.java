package com.yufeng.blog.controller;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="config")
@ApplicationScoped
public class Configs {
	private String baseUrl = "/Blog/";

	public String getBaseUrl() {
		return baseUrl;
	}
	
	
}

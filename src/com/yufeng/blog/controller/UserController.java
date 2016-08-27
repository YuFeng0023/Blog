package com.yufeng.blog.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.yufeng.blog.model.User;
import com.yufeng.blog.service.UserService;

@ManagedBean(name="user")
@SessionScoped
public class UserController {
	protected User user = new User();
	protected UserService service = new UserService();
	/**
	 * 注册
	 * @return
	 * 2016年8月25日  下午1:00:21
	 * @author yufeng
	 */
	public String regist(){
		try {
			service.regist(user);
		} catch (Exception e) {
			return "error.xhtml";
		}
		return "success.xhtml";
	}
	/**
	 * 更新
	 * @return
	 * 2016年8月25日  下午1:00:56
	 * @author yufeng
	 */
	public String update(){
		try {
			service.update(user);
		} catch (Exception e) {
			return "error.xhtml";
		}
		return "success.xhtml";
	}
	/**
	 * 登录
	 * @return
	 * 2016年8月25日  下午1:01:08
	 * @author yufeng
	 */
	public String login(){
		try {
			service.login(user);
		} catch (Exception e) {
			return "error.xhtml";
		}
		return "success.xhtml";
	}
	/**
	 * 找回密码
	 * @return
	 * 2016年8月25日  下午1:01:14
	 * @author yufeng
	 */
	public String find(){
		try {
			String findURL = service.find(user);
			if(findURL==null){
				return "error.xhtml";
			}else{
				FacesContext.getCurrentInstance().addMessage("findURL",new FacesMessage(findURL) );
			}
		} catch (Exception e) {
			return "error.xhtml";
		}
		return "success.xhtml";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}

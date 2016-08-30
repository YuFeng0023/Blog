package com.yufeng.blog.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.yufeng.blog.model.Article;
import com.yufeng.blog.model.Photo;
import com.yufeng.blog.model.User;
import com.yufeng.blog.service.UserService;

@ManagedBean(name="user")
@SessionScoped
public class UserController {
	protected User user = new User();
	@Inject
	protected UserService service;
	/**
	 * 注册
	 * @return
	 * 2016年8月25日  下午1:00:21
	 * @author yufeng
	 */
	public String regist(){
		try {
			service.register(user);
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
		//TODO 主页和错误页面还没完全写好
		
		try {
			User tmpUser = service.login(user);
			if(tmpUser!=null){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("currentUser", tmpUser);
				return "index.xhtml";//跳到主页
			}else{
				return "error.xhtml";
			}
		} catch (Exception e) {
			return "error.xhtml";
		}
	}
	/**
	 * 找回密码
	 * @return
	 * 2016年8月25日  下午1:01:14
	 * @author yufeng
	 */
	public String find(){
		try {
			String findURL = service.findPassword(user);
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
	/**
	 * 根据当前用户查找其收集文章
	 * @return
	 * 2016年8月30日  下午2:59:17
	 * @author yufeng
	 */
	public List<Article> getArticles() {
		user = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("currentUser");
		return service.getArticleCollection(user);
	}
	/**
	 * 需要从Session中先获取当前用户对象，根据当前用户获得收集图片
	 * @return
	 * 2016年8月30日  上午10:09:12
	 * @author yufeng
	 */
	public List<Photo> getPhotos() {
		user = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("currentUser");
		return service.getPhotoCollection(user);
	}

	
	public UserService getService() {
		return service;
	}
	public void setService(UserService service) {
		this.service = service;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}

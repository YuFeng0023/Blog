package com.yufeng.blog.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.model.UploadedFile;

import com.yufeng.blog.model.Article;
import com.yufeng.blog.model.Photo;
import com.yufeng.blog.model.User;
import com.yufeng.blog.service.UserService;
import com.yufeng.blog.utils.GetServerLocation;
import com.yufeng.blog.utils.WriteFileUtil;

@ManagedBean(name="user")
@SessionScoped
public class UserController {
	protected UploadedFile photo;//用于上传文件
	protected User user = new User();
	protected String url ;
	@Inject
	protected UserService service;
	@PostConstruct
	public void test(){
		System.out.println(service.getByUsername("user"));
	}
	/**
	 * 注册
	 * @return
	 * 2016年8月25日  下午1:00:21
	 * @author yufeng
	 */
	public String regist(){
		try {
			WriteFileUtil writer = new WriteFileUtil();
			if(photo!=null){
				try {
					//设置输入流
					writer.setInput(photo.getInputstream());
					//设置文件名
					String prefix = GetServerLocation.getServerLocation();
					prefix+="/upload/picture/"+UUID.randomUUID();
					String tmpName = photo.getFileName();
					tmpName = tmpName.substring( (tmpName.lastIndexOf('\\')<0?tmpName.lastIndexOf('/'):tmpName.lastIndexOf('\\'))+1 );
					writer.setFilename(prefix+tmpName);		
					//写文件
					writer.writeFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				String fileName = writer.getFileName();
				user.setHphoto(fileName.substring(fileName.indexOf("/upload/picture/")));
			}else{
				user.setHphoto("javascript:;");
			}
			System.out.println(user);
			service.register(user);
		} catch (Exception e) {
			return "error.xhtml";
		}
		return "showDetail.xhtml";
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
			boolean findURL = service.findPassword(user);
			if(findURL){
				return "error.xhtml";
			}else{
				FacesContext.getCurrentInstance().addMessage("findURL",new FacesMessage("asdfasdf") );
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
	public UploadedFile getPhoto() {
		return photo;
	}
	public void setPhoto(UploadedFile photo) {
		this.photo = photo;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}

package com.yufeng.blog.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import com.yufeng.blog.model.Article;
import com.yufeng.blog.model.ArticleClsf;
import com.yufeng.blog.service.ArticleClsfService;
import com.yufeng.blog.service.ArticleService;

/**
 * 
 * @author Feng
 *
 */
@ManagedBean(name="aclsf")
@RequestScoped
public class ArticleClsfController {
	protected ArticleClsf current = new ArticleClsf();//当前要处理的分类对象
	protected List<ArticleClsf> sons;//当前分类的子类，使用延迟加载，所以显示子类需要先查询（可以先不做，直接加载所有分类）
	protected List<ArticleClsf> parents = new ArrayList<ArticleClsf>();
	protected String pid;//记录父类ID，用于查找父类
	@Inject
	protected ArticleClsfService service;
	@Inject
	protected ArticleService articleService;
	
	public List<ArticleClsf> getAll(){
		return service.queryAll();
	}
	/**
	 * 添加新的分类
	 * @return
	 * 2016年8月29日  下午8:17:50
	 * @author yufeng
	 */
	public String add(){
		service.addClsf(current,pid);
		return "";
	}
	public String update(){
		service.updateClsf(current,pid);
		return "";
	}
	public String delete(){
		service.deleteClsf(pid);
		return "";
	}
	/**
	 * 获取当前分类的博文
	 * @return
	 * 2016年8月29日  下午9:08:04
	 * @author yufeng
	 */
	public List<Article> getArticle(){
		return articleService.queryByClsf(current.getAcid(), null);
	}
	public ArticleClsf getCurrent() {
		return current;
	}
	public void setCurrent(ArticleClsf current) {
		this.current = current;
	}
	public List<ArticleClsf> getSons() {
		return sons;
	}
	public void setSons(List<ArticleClsf> sons) {
		this.sons = sons;
	}
	public List<ArticleClsf> getParents() {
		return parents;
	}
	public void setParents(List<ArticleClsf> parents) {
		this.parents = parents;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public ArticleClsfService getService() {
		return service;
	}
	public void setService(ArticleClsfService service) {
		this.service = service;
	}
	public ArticleService getArticleService() {
		return articleService;
	}
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
}

package com.yufeng.blog.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import com.yufeng.blog.model.Article;
import com.yufeng.blog.model.ArticleClsf;
import com.yufeng.blog.model.Comment;
import com.yufeng.blog.model.PageBean;
import com.yufeng.blog.service.ArticleClsfService;
import com.yufeng.blog.service.ArticleService;
@ManagedBean(name="ac")
@RequestScoped
public class ArticleController {
	protected Article article = new Article();
	protected List<Article> arts ;
	protected PageBean page;//分页用,预留，可以不用
	protected String keyword;//检索关键字
	protected String aid;//博文ID，用于显示信息
	protected Comment comment;
	@Inject
	protected ArticleService service ;
	@Inject
	protected ArticleClsfService clsfservice;
	/**
	 * 添加图书
	 * @return
	 * 2016年8月25日  下午3:16:43
	 * @author yufeng
	 */
	public String add(){
		service.add(article);
		return "";
	}
	public String update(){
		service.add(article);
		return "";
	}
	/**
	 * 查询图书，将结果存入arts中
	 * 
	 * 2016年8月27日  上午10:05:37
	 * @author yufeng
	 */
	public void query(){
		this.arts = service.query(keyword, page);
	}
	/**
	 * 页面跳转，将结果写入arts中
	 * 
	 * 2016年8月27日  上午10:06:32
	 * @author yufeng
	 */
	public void toPage(int index){
		this.arts = service.list(page);
	}
	/**
	 * 获取博文对象，并存入article中,进行页面跳转
	 * @param index
	 * 2016年8月27日  上午10:09:41
	 * @author yufeng
	 */
	public String get(){
		article = service.find(aid);
		return "";
	}
	/**
	 * 添加评论
	 * @return
	 * 2016年8月30日  下午3:24:46
	 * @author yufeng
	 */
	public String addComment(){
		//TODO  获取当前查看的Article
		service.addComment(comment,article);
		return "";//跳转页面或是其他
	}
	/**
	 * 获取全部的分类信息
	 * @return
	 * 2016年8月30日  下午3:30:16
	 * @author yufeng
	 */
	public List<ArticleClsf> getClassifies(){
		return clsfservice.queryAll();
	}
	//getter 、 setter
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public List<Article> getArts() {
		return arts;
	}
	public void setArts(List<Article> arts) {
		this.arts = arts;
	}
	public PageBean getPage() {
		return page;
	}
	public void setPage(PageBean page) {
		this.page = page;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public ArticleService getService() {
		return service;
	}
	public void setService(ArticleService service) {
		this.service = service;
	}
	public ArticleClsfService getClsfservice() {
		return clsfservice;
	}
	public void setClsfservice(ArticleClsfService clsfservice) {
		this.clsfservice = clsfservice;
	}
}

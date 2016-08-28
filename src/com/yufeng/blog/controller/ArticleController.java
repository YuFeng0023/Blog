package com.yufeng.blog.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.yufeng.blog.model.Article;
import com.yufeng.blog.model.PageBean;
import com.yufeng.blog.service.ArticleService;
@ManagedBean(name="ac")
@RequestScoped
public class ArticleController {
	protected Article article = new Article();
	protected List<Article> arts ;
	protected PageBean page;
	protected String keyword;//检索关键字
	protected String aid;//博文ID，用于显示信息
	protected ArticleService service = new ArticleService();
	/**
	 * 添加图书
	 * @return
	 * 2016年8月25日  下午3:16:43
	 * @author yufeng
	 */
	public String add(){
		return "";
	}
	public String update(){
		return "";
	}
	/**
	 * 查询图书，将结果存入arts中
	 * 
	 * 2016年8月27日  上午10:05:37
	 * @author yufeng
	 */
	public void query(){
		
	}
	/**
	 * 页面跳转，将结果写入arts中
	 * 
	 * 2016年8月27日  上午10:06:32
	 * @author yufeng
	 */
	public void toPage(int index){
		if(page.isAllowed(index)){
			
		}
	}
	/**
	 * 获取博文对象，并存入article中,进行页面跳转
	 * @param index
	 * 2016年8月27日  上午10:09:41
	 * @author yufeng
	 */
	public String get(String aid){
		
		return "";
	}
}

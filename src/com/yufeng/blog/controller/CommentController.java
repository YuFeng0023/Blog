package com.yufeng.blog.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import com.yufeng.blog.model.Comment;
import com.yufeng.blog.model.PageBean;
import com.yufeng.blog.service.CommentService;
@ManagedBean(name="cc")
@RequestScoped
public class CommentController {
	protected Comment comment = new Comment();
	protected List<Comment> arts ;
	protected PageBean page;//分页用,预留，可以不用
	protected String keyword;//检索关键字
	protected String aid;//博文ID，用于显示信息
	@Inject
	protected CommentService service ;
	/**
	 * 添加图书
	 * @return
	 * 2016年8月25日  下午3:16:43
	 * @author yufeng
	 */
	public String add(){
		service.add(comment,aid);
		return "";
	}
	public String update(){
		service.update(comment);
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
	 * 获取博文对象，并存入comment中,进行页面跳转
	 * @param index
	 * 2016年8月27日  上午10:09:41
	 * @author yufeng
	 */
	public String get(String aid){
		comment = service.find(aid);
		return "";
	}
}

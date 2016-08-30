package com.yufeng.blog.service;

import java.util.List;

import com.yufeng.blog.model.Article;
import com.yufeng.blog.model.Comment;
import com.yufeng.blog.model.BlogCalendar;
import com.yufeng.blog.model.PageBean;

public interface CommentService {
	/**
	 * 添加评论
	 * @param atc
	 * @param article 
	 * @return
	 * 2016年8月30日  下午4:35:59
	 * @author yufeng
	 */
	public String add(Comment atc,String article);
	/**
	 * 根据博文ID查找博文
	 * @param aid 博文ID
	 * @return
	 * 2016年8月29日  下午7:12:00
	 * @author yufeng
	 */
	public Comment find(String aid);
	/**
	 * 更新博文
	 * @param atc
	 * @return
	 * 2016年8月25日  下午1:20:05
	 * @author yufeng
	 */
	public String update(Comment atc);
	/**
	 * 删除博文
	 * @param atc
	 * @return
	 * 2016年8月25日  下午1:20:05
	 * @author yufeng
	 */
	public String delete(String aid);
	/**
	 * 显示博文
	 * @param atc
	 * @return
	 * 2016年8月25日  下午1:20:05
	 * @author yufeng
	 */
	public List<Comment> list(PageBean page);
	/**
	 * 关键字查询
	 * @param atc
	 * @return
	 * 2016年8月25日  下午1:20:05
	 * @author yufeng
	 */
	public List<Comment> query(String keyword,PageBean num);
	/**
	 * 根据博文查找评论
	 * @param atc
	 * @return
	 * 2016年8月25日  下午1:20:05
	 * @author yufeng
	 */
	public List<Comment> queryByArticle(String aid,PageBean num);
}

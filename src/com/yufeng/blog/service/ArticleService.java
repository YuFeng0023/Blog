package com.yufeng.blog.service;

import java.util.List;

import com.yufeng.blog.model.Article;
import com.yufeng.blog.model.BlogCalendar;
import com.yufeng.blog.model.Comment;
import com.yufeng.blog.model.PageBean;

public interface ArticleService {
	/**
	 * 添加博文
	 * @param atc
	 * @return
	 * 2016年8月25日  下午1:20:05
	 * @author yufeng
	 */
	public String add(Article atc);
	/**
	 * 根据博文ID查找博文
	 * @param aid 博文ID
	 * @return
	 * 2016年8月29日  下午7:12:00
	 * @author yufeng
	 */
	public Article find(String aid);
	/**
	 * 更新博文
	 * @param atc
	 * @return
	 * 2016年8月25日  下午1:20:05
	 * @author yufeng
	 */
	public String update(Article atc);
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
	public List<Article> list(PageBean page);
	/**
	 * 关键字查询
	 * @param atc
	 * @return
	 * 2016年8月25日  下午1:20:05
	 * @author yufeng
	 */
	public List<Article> query(String keyword,PageBean page);
	/**
	 * 根据分类查询
	 * @param atc
	 * @return
	 * 2016年8月25日  下午1:20:05
	 * @author yufeng
	 */
	public List<Article> queryByClsf(String acid,PageBean num);
	/**
	 * 显示头条
	 * @return
	 * 2016年8月29日  下午1:27:21
	 * @author yufeng
	 */
	public List<Article> queryTop(int num);
	/**
	 * 查询博客日历
	 * @return
	 * 2016年8月29日  下午3:24:28
	 * @author yufeng
	 */
	public List<BlogCalendar> queryCalendar();
	/**
	 * 通过article的ID添加评论
	 * @param comment
	 * @param article
	 * 2016年8月30日  下午3:24:13
	 * @author yufeng
	 */
	public void addComment(Comment comment, Article article);
}

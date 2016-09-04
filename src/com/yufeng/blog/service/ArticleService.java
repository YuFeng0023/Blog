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
	public Article add(Article atc);
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
	public Article update(Article atc);
	/**
	 * 删除博文
	 * @param atc
	 * @return
	 * 2016年8月25日  下午1:20:05
	 * @author yufeng
	 */
	public boolean delete(String aid);
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
	/**
	 * 获取PageBean对象
	 * @return
	 * 2016年9月3日  下午2:04:31
	 * @author yufeng
	 */
	public PageBean getPageBean();
	/**
	 * 获取当前运行状态
	 * @return
	 * 2016年9月3日  下午2:04:57
	 * @author yufeng
	 */
	public int getState();
	/**
	 * 获取当前错误信息
	 * @return
	 * 2016年9月3日  下午2:05:23
	 * @author yufeng
	 */
	public String getMessage();
}

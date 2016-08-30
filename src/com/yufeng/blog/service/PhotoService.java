package com.yufeng.blog.service;

import java.util.List;

import com.yufeng.blog.model.Photo;
import com.yufeng.blog.model.BlogCalendar;
import com.yufeng.blog.model.PageBean;

public interface PhotoService {
	/**
	 * 添加博文
	 * @param atc
	 * @return
	 * 2016年8月25日  下午1:20:05
	 * @author yufeng
	 */
	public String add(Photo atc);
	/**
	 * 根据博文ID查找博文
	 * @param aid 博文ID
	 * @return
	 * 2016年8月29日  下午7:12:00
	 * @author yufeng
	 */
	public Photo find(String aid);
	/**
	 * 更新博文
	 * @param atc
	 * @return
	 * 2016年8月25日  下午1:20:05
	 * @author yufeng
	 */
	public String update(Photo atc);
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
	public List<Photo> list(PageBean page);
	/**
	 * 关键字查询
	 * @param atc
	 * @return
	 * 2016年8月25日  下午1:20:05
	 * @author yufeng
	 */
	public List<Photo> query(String keyword,PageBean num);
	/**
	 * 根据分类查询
	 * @param atc
	 * @return
	 * 2016年8月25日  下午1:20:05
	 * @author yufeng
	 */
	public List<Photo> queryByClsf(String acid,PageBean num);
	/**
	 * 显示头条
	 * @return
	 * 2016年8月29日  下午1:27:21
	 * @author yufeng
	 */
	public List<Photo> queryTop(int num);
}

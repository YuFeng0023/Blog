package com.yufeng.blog.service;

import java.util.List;

import com.yufeng.blog.model.Link;

public interface LinkService {
	/**
	 * 向数据库中添加新的Link对象
	 * @param link
	 * 2016年8月27日  下午9:22:25
	 * @author yufeng
	 */
	public void add(Link link);
	/**
	 * 查询数据库中所有的Link
	 * @return
	 * 2016年8月27日  下午9:23:16
	 * @author yufeng
	 */
	public List<Link> list();
	/**
	 * 更新
	 * @param link
	 * 2016年8月27日  下午10:06:07
	 * @author yufeng
	 */
	public void update(Link link);
	/**
	 * 删除
	 * @param lid
	 * 2016年8月27日  下午10:07:22
	 * @author yufeng
	 */
	public void delete(int lid);
	
}

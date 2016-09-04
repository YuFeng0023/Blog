package com.yufeng.blog.service;

import java.util.List;

import com.yufeng.blog.model.ArticleClsf;

public interface ArticleClsfService {
	/**
	 * 查询所有分类条目（用于添加、修改）
	 * @return
	 * 2016年8月29日  下午8:15:54
	 * @author yufeng
	 */
	public List<ArticleClsf> queryAll();
	/**
	 * 添加新的分类
	 * @param current
	 * 2016年8月29日  下午8:17:30
	 * @author yufeng
	 */
	public void addClsf(ArticleClsf current);
	/**
	 * 根据父类ID添加分类
	 * @param current
	 * @param pid
	 * 2016年8月29日  下午8:19:48
	 * @author yufeng
	 */
	public void addClsf(ArticleClsf current, String pid);
	/**
	 * 无需设置父类ID，直接更新
	 * @param current
	 * @param pid
	 * 2016年8月29日  下午8:21:25
	 * @author yufeng
	 */
	public void updateClsf(ArticleClsf current, String pid);
	/**
	 * 根据分类删除当前对象
	 * @param pid
	 * 2016年8月29日  下午8:24:32
	 * @author yufeng
	 */
	public void deleteClsf(String pid);
	/**
	 * 根据ID获取
	 * @param cid 当前分类ID
	 * 2016年8月31日  下午3:36:19
	 * @author yufeng
	 */
	public ArticleClsf get(String cid);
	/**
	 * 获取一级分类
	 * @return
	 * 2016年9月1日  下午1:49:52
	 * @author yufeng
	 */
	public List<ArticleClsf> queryTop();
	/**
	 * 查询某一分类的父类
	 * @param acid
	 * @return
	 * 2016年9月1日  下午10:43:41
	 * @author yufeng
	 */
	public List<ArticleClsf> queryFather(String acid);
	/**
	 * 查询子类
	 * @param pacid
	 * @return
	 * 2016年9月1日  下午11:00:21
	 * @author yufeng
	 */
	public List<ArticleClsf> querySons(String pacid);
}

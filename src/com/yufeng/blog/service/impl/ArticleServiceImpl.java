package com.yufeng.blog.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;



import com.yufeng.blog.model.Article;
import com.yufeng.blog.model.ArticleClsf;
import com.yufeng.blog.model.BlogCalendar;
import com.yufeng.blog.model.Comment;
import com.yufeng.blog.model.PageBean;
import com.yufeng.blog.service.ArticleService;
@Named
@ApplicationScoped
public class ArticleServiceImpl implements ArticleService {
	/**
	 * 添加博文
	 * @param atc
	 * @return
	 * 2016年8月25日  下午1:20:05
	 * @author yufeng
	 */
	public String add(Article atc){
		System.out.println(atc);
		return "a.html";
	}
	/**
	 * 添加博文
	 * @param atc
	 * @return
	 * 2016年8月25日  下午1:20:05
	 * @author yufeng
	 */
	public String update(Article atc){
		System.out.println(atc);
		return "a.html";
	}
	/**
	 * 添加博文
	 * @param atc
	 * @return
	 * 2016年8月25日  下午1:20:05
	 * @author yufeng
	 */
	public String delete(String aid){
		System.out.println(aid);
		return "a.html";
	}
	/**
	 * 添加博文
	 * @param atc
	 * @return
	 * 2016年8月25日  下午1:20:05
	 * @author yufeng
	 */
	public List<Article> list(PageBean num){
		List<Article> result = new ArrayList<Article>();
		for(int i = 0;i<num.getCounts();i++){
			Article art = new Article();
			art.setAcid(new ArticleClsf());
			art.setAid(i+1+"");
			art.setContent("test\test");
			art.setDate(new Date());
			art.setTitle("test"+i);
			result.add(art);
		}
		return result;
	}
	/**
	 * 关键字查询
	 * @param atc
	 * @return
	 * 2016年8月25日  下午1:20:05
	 * @author yufeng
	 */
	public List<Article> query(String keyword,PageBean page){
		List<Article> result = new ArrayList<Article>();
		for(int i = 0;i<page.getCounts();i++){
			Article art = new Article();
			art.setAcid(new ArticleClsf());
			art.setAid(i+1+"");
			art.setContent("test\test");
			art.setDate(new Date());
			art.setTitle("test"+i);
			result.add(art);
		}
		return result;
	}
	@Override
	public List<Article> queryByClsf(String acid,PageBean num) {
		List<Article> result = new ArrayList<Article>();
		for(int i = 0;i<num.getCounts();i++){
			Article art = new Article();
			art.setAcid(new ArticleClsf());
			art.setAid(i+1+"");
			art.setContent("test\test");
			art.setDate(new Date());
			art.setTitle("test"+i);
			result.add(art);
		}
		return result;
	}
	@Override
	public List<Article> queryTop(int num) {
		List<Article> result = new ArrayList<Article>();
		for(int i = 0;i<num;i++){
			Article art = new Article();
			art.setAcid(new ArticleClsf());
			art.setAid(i+1+"");
			art.setContent("test\test");
			art.setDate(new Date());
			art.setTitle("test"+i);
			result.add(art);
		}
		return result;
	}
	@Override
	public List<BlogCalendar> queryCalendar() {
		List<BlogCalendar> result = new ArrayList<BlogCalendar>();
		for(int i = 0;i<10;i++){
			BlogCalendar art = new BlogCalendar();
			art.setCondition("condition");
			art.setCount(10);
			art.setLabel("XX年"+i+"月");
			result.add(art);
		}
		return result;
	}
	@Override
	public Article find(String aid) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void addComment(Comment comment, Article article) {
		// TODO Auto-generated method stub
		
	}
	
}

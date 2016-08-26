package com.yufeng.blog.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.yufeng.blog.model.Article;
import com.yufeng.blog.model.ArticleClsf;

public class ArticleService {
	/**
	 * 添加博文
	 * @param atc
	 * @return
	 * 2016年8月25日  下午1:20:05
	 * @author yufeng
	 */
	public String add(Article atc){
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
		return "a.html";
	}
	/**
	 * 添加博文
	 * @param atc
	 * @return
	 * 2016年8月25日  下午1:20:05
	 * @author yufeng
	 */
	public String delete(Article atc){
		return "a.html";
	}
	/**
	 * 添加博文
	 * @param atc
	 * @return
	 * 2016年8月25日  下午1:20:05
	 * @author yufeng
	 */
	public List<Article> list(int num){
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
	/**
	 * 关键字查询
	 * @param atc
	 * @return
	 * 2016年8月25日  下午1:20:05
	 * @author yufeng
	 */
	public List<Article> query(String keyword){
		List<Article> result = new ArrayList<Article>();
		for(int i = 20;i > 0 ; i--){
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
	
}

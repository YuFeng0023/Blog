package com.yufeng.blog.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.TypedQuery;

import org.apache.commons.lang.StringUtils;

import com.yufeng.blog.model.Article;
import com.yufeng.blog.model.ArticleClsf;
import com.yufeng.blog.model.BlogCalendar;
import com.yufeng.blog.model.Comment;
import com.yufeng.blog.model.PageBean;
import com.yufeng.blog.service.ArticleService;

public class ArticleServiceImpl extends BaseService implements ArticleService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 819028298386905780L;
	private PageBean page ;
	private int state;
	private String message;
	@Override
	public Article add(Article atc) {
		if(atc==null||StringUtils.isBlank(atc.getContent())){
			return null;
		}
		begin();
		atc.setAid(UUID.randomUUID().toString());
		manager.persist(atc);
		atc.setDate(new Date());
		end();
		manager.clear();
		return atc;
	}
	@Override
	public Article find(String aid) {
		if(StringUtils.isBlank(aid)){
			throw new RuntimeException("传入ID为空！");
		}
		Article result = manager.find(Article.class, aid);
		manager.clear();
		return result;
	}
	@Override
	public Article update(Article atc) {
		Article result = manager.find(Article.class, atc.getAid());
		if(result != null){
			begin();
			copy(atc, result);
			manager.persist(result);
			end();
			manager.clear();
		}
		return result;
	}
	@Override
	public boolean delete(String aid) {
		if(StringUtils.isBlank(aid)){
			throw new RuntimeException("传入ID为空！");
		}
		Article result = manager.find(Article.class,aid);
		if(result==null){
			return false;
		}else{
			begin();
			manager.remove(result);
			end();
			manager.clear();
		}
		return true;
	}
	@Override
	public List<Article> list(PageBean page) {
		if(page==null){
			page = this.page = new PageBean();
			Long result = manager.createQuery("SELECT COUNT(a.aid) from Article a", Long.class).getResultList().get(0);
			page.setCounts(result);
			if(page.isAllowed(page.getCurrent())){
				return manager.createQuery("from Article a", Article.class).setFirstResult(page.getStart()).setMaxResults(page.getPer()).getResultList();
			}
			return null;
		}else{
			TypedQuery<Article> query = manager.createQuery("from Article a", Article.class);
			query.setFirstResult(page.getStart());
			query.setMaxResults(page.getPer());
			List<Article> result = query.getResultList();
			manager.clear();
			return result;
		}
	}

	@Override
	public List<Article> query(String keyword, PageBean page) {
		List<Article> result = manager.createQuery("from Article a where a.title like '%"+keyword+"%' or a.content like '%"+keyword+"%' ",Article.class).getResultList();
		return result;
	}

	@Override
	public List<Article> queryByClsf(String acid, PageBean num) {
//		ArticleClsf clsf= manager.find(ArticleClsf.class, acid);
//		if(clsf==null){
//			return null;
//		}else{
//			String ids = "'"+clsf.getAcid()+"'";
//			while(clsf.getFid()!=null){
//				clsf = clsf.getFid();
//				ids+=",'"+clsf.getAcid()+"'";
//			}
//			List<Article> result = manager.createQuery("from Article a where a.acid in ("+ids+")", Article.class).getResultList();
//			manager.clear();
//			return result;
//		}
		if(StringUtils.isBlank(acid)){
			return null;
		}
		List<Article> result = manager.createQuery("from Article a where a.acid ='"+acid+"'", Article.class).getResultList();
		manager.clear();
		return result;
	}

	@Override
	public List<Article> queryTop(int num) {
		return null;
	}

	@Override
	public List<BlogCalendar> queryCalendar() {
		List<Article> tmpList = manager.createQuery("from Article a", Article.class).getResultList();
		Map<String,BlogCalendar> map = new HashMap<String,BlogCalendar>(); 
		SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月");
		for (Article a:tmpList) {
			Date date = a.getDate();
			String key = format.format(date);
			if(map.containsKey(key)){
				BlogCalendar cal = map.get(key);
				cal.setCondition(cal.getCondition()+","+a.getAid());
				cal.setCount(cal.getCount()+1);
			}else{
				BlogCalendar cal = new BlogCalendar();
				cal.setLabel(key);
				cal.setCount(1);
				cal.setCondition(a.getAid());
			}
		}
		List<BlogCalendar> result = new ArrayList<BlogCalendar>();
		for (String key : map.keySet()) {
			result.add(map.get(key));
		}
		return result;
	}

	@Override
	public void addComment(Comment comment, Article article) {
		article = manager.find(article.getClass(), article.getAid());
		comment.setAid(article);
		comment.setDate(new Date());
		begin();
		manager.persist(comment);
		end();
		manager.clear();
	}
	public void copy(Article src, Article aim){
		aim.setAcid(manager.find(ArticleClsf.class, src.getAcid() ));
		aim.setContent(src.getContent());
		aim.setTitle(src.getTitle());
	}

	@Override
	public PageBean getPageBean() {
		return page;
	}

	@Override
	public int getState() {
		return state;
	}

	@Override
	public String getMessage() {
		return message;
	}
	@Override
	public String toString() {
		return "ArticleServiceImpl [page=" + page + ", state=" + state
				+ ", message=" + message + "]";
	}
}

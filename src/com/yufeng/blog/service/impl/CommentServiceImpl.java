package com.yufeng.blog.service.impl;

import java.util.List;

import javax.inject.Named;
import javax.persistence.TypedQuery;

import com.yufeng.blog.model.Article;
import com.yufeng.blog.model.Comment;
import com.yufeng.blog.model.PageBean;
import com.yufeng.blog.service.CommentService;
@Named
public class CommentServiceImpl extends BaseService  implements CommentService {
	private static final long serialVersionUID = 4973647144681734351L;
	private PageBean page;
	private int state;
	private String message;
	@Override
	public Comment add(Comment atc, String article) {
		Article art = manager.find(Article.class, article);
		begin();
		atc.setAid(art);
		manager.persist(atc);
		end();
		manager.clear();
		return atc;
	}

	@Override
	public Comment find(String aid) {
		Comment result = manager.find(Comment.class, aid);
		manager.clear();
		return result;
	}

	@Override
	public String update(Comment atc) {
		
		return null;
	}

	@Override
	public boolean delete(String aid) {
		Comment result = manager.find(Comment.class, aid);
		if(result!=null){
			begin();
			manager.remove(result);
			end();
			return true;
		}
		return false;
	}

	@Override
	public List<Comment> list(PageBean page) {
		if(page==null){
			page = this.page = new PageBean();
			Long result = manager.createQuery("SELECT COUNT(c.cid) from Comment c", Long.class).getResultList().get(0);
			page.setCounts(result);
			if(page.isAllowed(page.getCurrent())){
				return manager.createQuery("from Comment c", Comment.class).setFirstResult(page.getStart()).setMaxResults(page.getPer()).getResultList();
			}
			return null;
		}else{
			TypedQuery<Comment> query = manager.createQuery("from Comment c", Comment.class);
			query.setFirstResult(page.getStart());
			query.setMaxResults(page.getPer());
			List<Comment> result = query.getResultList();
			manager.clear();
			return result;
		}
	}

	@Override
	public List<Comment> query(String keyword, PageBean num) {
		List<Comment> result = manager.createQuery("from Comment c where c.content like '%"+keyword+"%'", Comment.class).getResultList();
		manager.clear();
		return result;
	}

	@Override
	public List<Comment> queryByArticle(String aid, PageBean num) {
		Article art = manager.find(Article.class, aid);
		if(art==null){
			throw new RuntimeException("文章ID不正确");
		}
		return art.getComments();
	}
	public PageBean getPageBean(){
		return page;
	}


	public int getState() {
		return state;
	}

	public String getMessage() {
		return message;
	}
	
}

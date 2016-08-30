package com.yufeng.blog.service.impl;

import java.util.List;

import javax.inject.Named;

import com.yufeng.blog.model.Comment;
import com.yufeng.blog.model.PageBean;
import com.yufeng.blog.service.CommentService;
@Named
public class CommentServiceImpl implements CommentService {

	@Override
	public String add(Comment atc, String article) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comment find(String aid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(Comment atc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(String aid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comment> list(PageBean page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comment> query(String keyword, PageBean num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comment> queryByArticle(String aid, PageBean num) {
		// TODO Auto-generated method stub
		return null;
	}

}

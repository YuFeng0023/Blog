package com.yufeng.blog.service.impl;

import java.util.List;

import javax.inject.Named;

import com.yufeng.blog.model.Article;
import com.yufeng.blog.model.Photo;
import com.yufeng.blog.model.User;
import com.yufeng.blog.service.UserService;
@Named
public class UserServiceImpl implements UserService{
	/**
	 * 注册用户
	 * @param user
	 * @return 如果注册失败则返回空
	 * 2016年8月25日  下午1:12:55
	 * @author yufeng
	 */
	public User register(User user)throws Exception{
		System.out.println(user);
		return user;
	}
	/**
	 * 登录
	 * @param user
	 * @return 如果登录失败返回空
	 * @throws Exception
	 * 2016年8月25日  下午1:14:55
	 * @author yufeng
	 */
	public User login(User user)throws Exception{
		System.out.println("login "+user);
		return user;
	}
	/**
	 * 更新
	 * @param user
	 * @return 更新失败返回空
	 * @throws Exception
	 * 2016年8月25日  下午1:16:06
	 * @author yufeng
	 */
	public User update(User user) throws Exception{
		System.out.println("update"+user);
		return user;
	}
	/**
	 * 找回密码
	 * @param user
	 * @return 返回密码链接，如果用户信息无效则返回空
	 * @throws Exception
	 * 2016年8月25日  下午1:17:37
	 * @author yufeng
	 */
	public String findPassword(User user) throws Exception{
		return "test.com";
	}
	@Override
	public List<Article> getArticleCollection(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Photo> getPhotoCollection(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public String findPasswordByQuestion(User user) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}

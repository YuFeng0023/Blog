package com.yufeng.blog.service;

import com.yufeng.blog.model.User;

public class UserService {
	/**
	 * 注册用户
	 * @param user
	 * @return 如果注册失败则返回空
	 * 2016年8月25日  下午1:12:55
	 * @author yufeng
	 */
	public User regist(User user)throws Exception{
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
	public String find(User user) throws Exception{
		return "test.com";
	}
}

package com.yufeng.blog.service;

import java.util.List;

import com.yufeng.blog.model.Article;
import com.yufeng.blog.model.Photo;
import com.yufeng.blog.model.User;

public interface UserService {
	/**
	 * 注册用户
	 * @param user
	 * @return 如果注册失败则返回空
	 * 2016年8月25日  下午1:12:55
	 * @author yufeng
	 */
	public User register(User user)throws Exception;
	/**
	 * 登录
	 * @param user
	 * @return 如果登录失败返回空
	 * @throws Exception
	 * 2016年8月25日  下午1:14:55
	 * @author yufeng
	 */
	public User login(User user)throws Exception;
	/**
	 * 更新
	 * @param user
	 * @return 更新失败返回空
	 * @throws Exception
	 * 2016年8月25日  下午1:16:06
	 * @author yufeng
	 */
	public User update(User user) throws Exception;
	/**
	 * 找回密码
	 * @param user
	 * @return 返回密码链接，如果用户信息无效则返回空
	 * @throws Exception
	 * 2016年8月25日  下午1:17:37
	 * @author yufeng
	 */
	public boolean findPassword(User user) throws Exception;
//	/**
//	 * 通过密保问题找回密码
//	 * @param user
//	 * @return 返回密码链接，如果用户信息无效则返回空
//	 * @throws Exception
//	 * 2016年8月25日  下午1:17:37
//	 * @author yufeng
//	 */
//	public String findPasswordByQuestion(User user) throws Exception;
	/**
	 * 获得收藏文章
	 * @return
	 * 2016年8月29日  下午3:35:03
	 * @author yufeng
	 */
	public List<Article> getArticleCollection(User user);
	/**
	 * 获取收藏图片
	 * @return
	 * 2016年8月29日  下午3:35:36
	 * @author yufeng
	 */
	public List<Photo> getPhotoCollection(User user);
	/**
	 * 通过ID获取User对象
	 * @param id
	 * @return
	 * 2016年8月29日  下午6:56:42
	 * @author yufeng
	 */
	public User findById(int id);
	/**
	 * 删除用户
	 * @param id
	 * @return
	 * 2016年8月29日  下午6:57:13
	 * @author yufeng
	 */
	public boolean deleteUser(int id);
	/**
	 * 通过用户名获取具体的对象
	 * @param username
	 * @return
	 * 2016年9月2日  下午3:21:02
	 * @author yufeng
	 */
	public User getByUsername(String username);
	/**
	 * 通过用户名获取对象
	 * @param email
	 * @return
	 * 2016年9月2日  下午10:00:58
	 * @author yufeng
	 */
	public User getByEmail(String email);
}

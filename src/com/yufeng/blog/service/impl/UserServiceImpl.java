package com.yufeng.blog.service.impl;

import java.util.List;

import javax.inject.Named;

import org.apache.commons.lang.StringUtils;

import com.yufeng.blog.model.Article;
import com.yufeng.blog.model.Photo;
import com.yufeng.blog.model.User;
import com.yufeng.blog.model.UserDetail;
import com.yufeng.blog.service.UserService;
@Named
public class UserServiceImpl extends BaseService implements UserService{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1038849308087839423L;
	/**
	 * 注册用户
	 * @param user
	 * @return 如果注册失败则返回空
	 * 2016年8月25日  下午1:12:55
	 * @author yufeng
	 */
	public User register(User user)throws Exception{
		begin();
		manager.persist(user.getDetail());
		manager.persist(user);
		end();
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
		if(user==null){
			return null;
		}
		User tmp = getByUsername(user.getUsername());
		if(tmp==null){
			return tmp;
		}
		if(tmp.getPassword().equals(user.getPassword())){
			return tmp;
		}else{
			throw new Exception("密码错误！");
		}
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
		if(user==null||StringUtils.isBlank(user.getUsername())){
			return null;
		}
		User tmp = manager.find(User.class, user.getUid());
		begin();
		copy(user,tmp);//避免空值的影响
		manager.merge(tmp);
		end();
		return user;
	}
	/**
	 * 回答正确密保问题后将新的密码存入数据库
	 * @param user
	 * @return 返回密码链接，如果用户信息无效则返回空
	 * @throws Exception
	 * 2016年8月25日  下午1:17:37
	 * @author yufeng
	 */
	public boolean findPassword(User user) throws Exception{
		User tmp = getByUsername(user.getUsername());
		if(tmp==null){
			tmp = getByEmail(user.getDetail().getEmail());
		}
		if(tmp==null){
			return false;
		}
		if(user.getDetail().getQuestion().equals(tmp.getDetail().getQuestion())){
			if(user.getDetail().getAnswer().equals(tmp.getDetail().getAnswer())){
				begin();
				tmp.setPassword(user.getPassword());
				end();
				return true;
			}
		}
		return false;
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
		User user = manager.find(User.class, id);
		manager.clear();
		return user;
	}
	@Override
	public boolean deleteUser(int id) {
		User user = manager.find(User.class, id);
		if(user != null){
			begin();
			manager.remove(user);
			end();
			return true;
		}else{
			return false;//无用户	
		}
	}
	public void copy(User src,User aim){
		aim.setHphoto(src.getHphoto());
		aim.setLevel(src.getLevel());
		aim.setNickname(src.getNickname());
		aim.setPassword(src.getPassword());
		UserDetail detail = aim.getDetail();
		if(detail!=null||src.getDetail()!=null){
			detail.setAnswer(src.getDetail().getAnswer());
			detail.setBrithday(src.getDetail().getBrithday());
			detail.setEmail(src.getDetail().getEmail());
			detail.setGender(src.getDetail().getGender());
			detail.setPhone(src.getDetail().getPhone());
			detail.setQuestion(src.getDetail().getQuestion());
		}
	}
	@Override
	public User getByUsername(String username) {
		if(StringUtils.isBlank(username)){
			return null;
		}
		List<User> result = manager.createQuery("from User u where u.username='"+username+"' ", User.class ).getResultList();
		if(result==null||result.size()==0){
			return null;
		}else{
			return result.get(0);
		}
	}
	@Override
	public User getByEmail(String email) {
		if(StringUtils.isBlank(email)){
			return null;
		}
		List<User> result = manager.createQuery("from User u where u.detail.email='"+email+"' ", User.class ).getResultList();
		if(result==null||result.size()==0){
			return null;
		}else{
			return result.get(0);
		}
	}
}

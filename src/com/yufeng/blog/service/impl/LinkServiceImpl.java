package com.yufeng.blog.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import com.yufeng.blog.model.Link;
import com.yufeng.blog.service.LinkService;

@ManagedBean(name = "linkService")
@RequestScoped
public class LinkServiceImpl implements LinkService,Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 271080014088355154L;
	
	@PersistenceContext(unitName="Blog")
	protected EntityManager manager ;
	@Resource
    private UserTransaction userTransaction;
	/**
	 * 开始事务，用于客户端测试
	 * 
	 * 2016年8月27日  下午9:21:59
	 * @author yufeng
	 */
	public void begin(){
		try {
			userTransaction.begin();
		} catch (NotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 提交事务
	 * 
	 * 2016年8月27日  下午9:22:52
	 * @author yufeng
	 */
	public void end(){
		try {
			userTransaction.commit();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 向数据库中添加新的Link对象
	 * @param link
	 * 2016年8月27日  下午9:22:25
	 * @author yufeng
	 */
	public void add(Link link){
		begin();
		manager.persist(link);
		end();
	}
	
	/**
	 * 查询数据库中所有的Link
	 * @return
	 * 2016年8月27日  下午9:23:16
	 * @author yufeng
	 */
	public List<Link> list(){
		List<Link> result = manager.createQuery("from Link l",Link.class).getResultList();
		manager.clear();
		return result;
	}
	/**
	 * 更新
	 * @param link
	 * 2016年8月27日  下午10:06:07
	 * @author yufeng
	 */
	public void update(Link link){
		begin();
		Link linkTmp = manager.find(Link.class,link.getLid());
		linkTmp.copy(link);
		manager.persist(linkTmp);
		end();
	}
	/**
	 * 删除
	 * @param lid
	 * 2016年8月27日  下午10:07:22
	 * @author yufeng
	 */
	public void delete(int lid){
		begin();
		Link linkTmp = manager.find(Link.class,lid);
		manager.remove(linkTmp);
		end();
	}
}

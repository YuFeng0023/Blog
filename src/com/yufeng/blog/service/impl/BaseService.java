package com.yufeng.blog.service.impl;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
public class BaseService implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1087299549931438887L;
	@PersistenceContext
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
}

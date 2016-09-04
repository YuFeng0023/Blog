package com.yufeng.blog.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import org.apache.commons.lang.StringUtils;

import com.yufeng.blog.model.ArticleClsf;
import com.yufeng.blog.service.ArticleClsfService;
@Named
public class ArticleClsfServiceImpl  implements ArticleClsfService {
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
	@Override
	public List<ArticleClsf> queryAll() {
		List<ArticleClsf> result = manager.createQuery("from ArticleClsf ac",ArticleClsf.class ).getResultList();
		manager.clear();
		return result;
	}

	@Override
	public void addClsf(ArticleClsf current) {
		begin();
		current.setAcid(UUID.randomUUID().toString());
		manager.persist(current);
		end();
		manager.clear();
	}

	@Override
	public void addClsf(ArticleClsf current, String pid) {
		begin();
		ArticleClsf father = getFather(current, pid);
		current.setFid(father);
		current.setAcid(UUID.randomUUID().toString());
		manager.persist(current);
		end();
	}

	@Override
	public void updateClsf(ArticleClsf current, String pid) {
		begin();
		ArticleClsf tmp = manager.find(ArticleClsf.class,current.getAcid());
		if(tmp==null){
			throw new RuntimeException("传入ID错误，未找到实体");
		}
		ArticleClsf father;
		father = getFather(current, pid);
		copy(tmp,current);
		tmp.setFid(father);
		manager.persist(tmp);
		end();
	}
	private ArticleClsf getFather(ArticleClsf current, String pid) {
		ArticleClsf father;
		if(StringUtils.isBlank(pid)){
			if(current.getFid()==null||StringUtils.isBlank(current.getFid().getAcid())){
				father = null;
			}else{
				father = manager.find(ArticleClsf.class,current.getFid().getAcid());
			}		
		}else{
			father = manager.find(ArticleClsf.class,pid);
		}
		return father;
	}

	@Override
	public void deleteClsf(String pid) {
		begin();
		ArticleClsf ac=manager.find(ArticleClsf.class, pid);
		manager.remove(ac);
		end();
	}
	public void copy(ArticleClsf aim ,ArticleClsf src){
		aim.setLabel(src.getLabel());
	}
	@Override
	public ArticleClsf get(String cid) {
		if(StringUtils.isBlank(cid)){
			return null;
		}
		ArticleClsf ac=manager.find(ArticleClsf.class, cid);
		manager.clear();
		return ac;
	}
	@Override
	public List<ArticleClsf> queryTop() {
		List<ArticleClsf> result = manager.createQuery("from ArticleClsf ac where ac.fid is null ", ArticleClsf.class).getResultList();
		manager.clear();
		return result;
	}
	@Override
	public List<ArticleClsf> queryFather(String acid) {
		List<ArticleClsf> result = new ArrayList<ArticleClsf>();
		ArticleClsf current = get(acid);
		if(current!=null){
			while(current.getFid()!=null){
				current = current.getFid();
				result.add(0,current);
			}
		}
		return result;
	}
	@Override
	public List<ArticleClsf> querySons(String pacid) {
		List<ArticleClsf> result = manager.createQuery("from ArticleClsf ac where ac.fid.acid = '"+pacid+"' ", ArticleClsf.class).getResultList();
		manager.clear();
		return result;
	}
}

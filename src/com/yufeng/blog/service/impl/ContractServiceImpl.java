package com.yufeng.blog.service.impl;

import java.io.Serializable;
import java.util.Date;
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

import com.yufeng.blog.model.Contract;
import com.yufeng.blog.service.ContractService;

@ManagedBean(name = "contractService")
@RequestScoped
public class ContractServiceImpl implements ContractService,Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 271080014088355154L;
	
	@PersistenceContext(unitName="Blog")
	protected EntityManager manager ;
	@Resource
    private UserTransaction userTransaction;
	
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

	public void add(Contract contract){
		begin();
		contract.setDate(new Date());
		manager.persist(contract);
		end();
	}
	
	public List<Contract> list(){
		List<Contract> result = manager.createQuery("from Contract l",Contract.class).getResultList();
		manager.clear();
		return result;
	}
	
	public void update(Contract contract){
		begin();
		Contract contractTmp = manager.find(Contract.class,contract.getCid());
		contractTmp.copy(contract);
		manager.persist(contractTmp);
		end();
	}

	public void delete(int lid){
		begin();
		Contract contractTmp = manager.find(Contract.class,lid);
		manager.remove(contractTmp);
		end();
	}
}

package com.yufeng.blog.service;

import java.util.List;

import com.yufeng.blog.model.Contract;

public interface ContractService {
	public void add(Contract contract);
	public List<Contract> list();
	public void update(Contract contract);
	public void delete(int lid);
}

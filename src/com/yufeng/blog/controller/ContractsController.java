package com.yufeng.blog.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.yufeng.blog.model.Contract;
import com.yufeng.blog.service.ContractService;

@ManagedBean(name="contract")
@SessionScoped
public class ContractsController {
	protected List<Contract> contracts ;
	protected Contract contract= new Contract();
	@ManagedProperty(value = "#{contractService}")
	protected ContractService service;
	public String addContract(){
		service.add(contract);
		return "/modules/contracts/listContracts.xhtml";
	}
	public List<Contract> getContracts() {
		return contracts;
	}
	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}
	public Contract getContract() {
		return contract;
	}
	public void setContract(Contract contract) {
		this.contract = contract;
	}
	public ContractService getService() {
		return service;
	}
	public void setService(ContractService service) {
		this.service = service;
	}
	
}

package com.yufeng.blog.model;

public class PageBean {
	protected int current;
	protected int total;
	protected int counts;
	protected int per ;
	public int getCurrent() {
		return current;
	}
	public void setCurrent(int current) {
		this.current = current;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getCounts() {
		return counts;
	}
	public void setCounts(int counts) {
		this.counts = counts;
	}
	public int getPer() {
		return per;
	}
	public void setPer(int per) {
		this.per = per;
	}
	public boolean isAllowed(int page){
		return page<=total&&page>=1; 
	}
}

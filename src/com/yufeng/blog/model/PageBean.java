package com.yufeng.blog.model;

public class PageBean {
	protected int current = 1;//当前页数
	protected int total;//总页数
	protected long counts;//数据条目
	protected int per = 10;//每页条目
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
	public long getCounts() {
		return counts;
	}
	public void setCounts(long counts) {
		this.counts = counts;
		total = (int) (counts%per==0?counts/per:counts/per+1);
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
	public int getStart(){
		return (current-1)*per;
	}
	public int getEnd(){
		return current*per;
	}
}

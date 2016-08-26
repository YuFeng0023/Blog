package com.yufeng.blog.model;

public class ArticleClsf {
	protected String acid;
	protected String label;
	protected ArticleClsf fid = null;
	public String getAcid() {
		return acid;
	}
	public void setAcid(String aid) {
		this.acid = aid;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public ArticleClsf getFid() {
		return fid;
	}
	public void setFid(ArticleClsf fid) {
		this.fid = fid;
	}
}

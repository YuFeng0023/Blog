package com.yufeng.blog.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class ArticleClsf implements Serializable {
	private static final long serialVersionUID = 4229022411427262554L;
	@Id
	protected String acid;
	protected String label;
	@ManyToOne(targetEntity=ArticleClsf.class,cascade=CascadeType.REMOVE)
	protected ArticleClsf fid;
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
	@Override
	public String toString() {
		return "ArticleClsf [acid=" + acid + ", label=" + label + ", fid="
				+ fid + "]";
	}
}

package com.douzone.jblog.vo;

public class CategoryVo {
	private int no;
	private String name;
	private String desc;
	private String blog_id;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getBlog_id() {
		return blog_id;
	}
	public void setBlog_id(String blog_id) {
		this.blog_id = blog_id;
	}
	@Override
	public String toString() {
		return "CategoryVo [no=" + no + ", name=" + name + ", desc=" + desc + ", blog_id=" + blog_id + "]";
	}
	
	
}

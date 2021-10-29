package com.douzone.jblog.vo;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

public class UserVo {
	
	@NotEmpty
	private String id;
	@NotEmpty
	private String name;
	@NotEmpty
	private String password;
	@NotEmpty
	private Date date_time;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDate_time() {
		return date_time;
	}
	public void setDate_time(Date date_time) {
		this.date_time = date_time;
	}
	
	
}

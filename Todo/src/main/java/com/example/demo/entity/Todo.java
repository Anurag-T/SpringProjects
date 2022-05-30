package com.example.demo.entity;

import java.util.Date;

import javax.validation.constraints.Size;

public class Todo {

	private int id;
	private String user;
	
	@Size(min=6, max=90, message = "Description length must be in Between 6 to 90")
	private String desc;
	private Date date;
	private boolean isCompleted;

	public Todo() {
	}

	public Todo(int id, String user, String desc, Date date, boolean isCompleted) {
		super();
		this.id = id;
		this.user = user;
		this.desc = desc;
		this.date = date;
		this.isCompleted = isCompleted;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", user=" + user + ", desc=" + desc + ", date=" + date + ", isCompleted="
				+ isCompleted + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

}

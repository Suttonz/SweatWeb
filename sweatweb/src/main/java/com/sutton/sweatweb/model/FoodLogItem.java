package com.sutton.sweatweb.model;

import java.util.Date;

public class FoodLogItem {
	
	private String user;
	private String logDate;
	private Food food;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getLogDate() {
		return logDate;
	}
	public void setLogDate(String logDate) {
		this.logDate = logDate;
	}
	public Food getFood() {
		return food;
	}
	public void setFood(Food food) {
		this.food = food;
	}
	public FoodLogItem(String user, String logDate, Food food) {
		super();
		this.user = user;
		this.logDate = logDate;
		this.food = food;
	}
	@Override
	public String toString() {
		return "FoodLogItem [user=" + user + ", logDate=" + logDate + ", food=" + food + "]";
	}
	
	

}

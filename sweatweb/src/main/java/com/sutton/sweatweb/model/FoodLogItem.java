package com.sutton.sweatweb.model;

public class FoodLogItem {


	private String user;
	private String logDate;
	private int foodID;
	
	public FoodLogItem(String user, String logDate, int foodID) {
		super();
		this.user = user;
		this.logDate = logDate;
		this.foodID = foodID;
	}
	
	public int getFoodID() {
		return foodID;
	}
	public void setFoodID(int foodID) {
		this.foodID = foodID;
	}
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

	@Override
	public String toString() {
		return "FoodLogItem [user=" + user + ", logDate=" + logDate + ", foodID=" + foodID + "]";
	}
	
	

}

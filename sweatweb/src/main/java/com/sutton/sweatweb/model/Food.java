package com.sutton.sweatweb.model;

public class Food {
	
	private int foodID;
	private String foodName;
	private String size;
	private String calories;
	
	public Food(int foodID, String foodName, String size, String calories) {
		
		this.foodID = foodID;
		this.foodName = foodName;
		this.size = size;
		this.calories = calories;
	}
	
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getCalories() {
		return calories;
	}
	public void setCalories(String calories) {
		this.calories = calories;
	}
	
	public int getFoodID() {
		return foodID;
	}
	public void setFoodID(int foodID) {
		this.foodID = foodID;
	}
	
	@Override
	public String toString() {
		return "Food [foodName=" + foodName + ", size=" + size + ", calories=" + calories + "]";
	}
	
	
	

}

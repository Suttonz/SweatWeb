package com.sutton.sweatweb.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import com.sutton.sweatweb.data.FoodDao;
import com.sutton.sweatweb.model.Food;
import com.sutton.sweatweb.model.FoodLogItem;

public class FoodService {

	public List<Food> searchFood(String foodName) {

		List<Food> foodList = FoodDao.getFood(foodName.toLowerCase());

		if (!CollectionUtils.isEmpty(foodList)) {

			return foodList;
		} else {

			return null;

		}
	}
	
	public boolean addFoodLogItem(String user, String date, int foodID) {
		// TODO Sutton : Validate user inputs - Except for user. We will do it later
		Food food = new Food(foodID,null, null, null);
		
		FoodLogItem newFoodLogItem = new FoodLogItem(user, date, food);
		
		boolean success = false;
		try {
			success = FoodDao.LogFood(newFoodLogItem);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return success;
	}
}

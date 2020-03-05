package com.sutton.sweatweb.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.sutton.sweatweb.data.FoodDao;
import com.sutton.sweatweb.data.FoodLogDao;
import com.sutton.sweatweb.data.UserDao;
import com.sutton.sweatweb.model.FoodLogItem;

public class FoodLogService {

	private boolean validateUser(String user) {

		return UserDao.getUser(user) == null;
	}

	private boolean validateDate(String date) {

		try {
			// check date format
			new SimpleDateFormat("yyyy-MM-dd").parse(date);

		} catch (ParseException e1) {

			return false;
		}
		return true;
	}

	private boolean validateFoodID(int foodID) {

		return FoodDao.getFood(foodID) == null;
	}

	public List<FoodLogItem> searchFoodlogItem(String user, String date) {

		// Validate user
		if (!validateUser(user)) {
			throw new IllegalArgumentException("No legit user found");
		}

		// Validate date
		if (!validateDate(date)) {
			throw new IllegalArgumentException("invaild date");
		}

		List<FoodLogItem> foodLogItemList = FoodLogDao.listFoodLogItems(user, date);

		return foodLogItemList;

	}

	public boolean addFoodLogItem(String user, String date, int foodID) {

		// Validate user
		if (!validateUser(user)) {
			throw new IllegalArgumentException("No legit user found");
		}

		// Validate date

		if (!validateDate(date)) {

			throw new IllegalArgumentException("invaild date");
		}

		// Validate food
		if (validateFoodID(foodID)) {

			throw new IllegalArgumentException("invaild foodID");
		}

		FoodLogItem newFoodLogItem = new FoodLogItem(user, date, foodID);

		boolean success = false;
		try {
			success = FoodLogDao.LogFood(newFoodLogItem);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return success;
	}
}

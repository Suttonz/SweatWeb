package com.sutton.sweatweb.service;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import com.sutton.sweatweb.data.FoodDao;
import com.sutton.sweatweb.model.Food;

public class FoodService {

	public List<Food> searchFood(String foodName) {

		List<Food> foodList = FoodDao.listFood(foodName.toLowerCase());

		if (!CollectionUtils.isEmpty(foodList)) {

			return foodList;
		} else {

			return null;

		}
	}
	
	
}

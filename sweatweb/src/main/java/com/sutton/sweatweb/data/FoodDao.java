package com.sutton.sweatweb.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sutton.sweatweb.model.Food;
import com.sutton.sweatweb.model.FoodLogItem;

public class FoodDao {

	public static List<Food> listFood(String foodName) {

		List<Food> foodList = new ArrayList<Food>();

		try {

			Connection conn = ConnectionHelper.getConn();
			String searchQuery = "SELECT * FROM foodList where FOODNAME = '" + foodName + "'";
			Statement sqs = conn.createStatement();
			conn.commit();
			ResultSet rs = sqs.executeQuery(searchQuery);

			while (rs.next()) {
				int foodIDDB = rs.getInt("FOODID");
				String foodNameDB = rs.getString("FOODNAME");
				String sizeDB = rs.getString("SIZE");
				String caloriesDB = rs.getString("CALORIES");
				Food food = new Food(foodIDDB,foodNameDB, sizeDB, caloriesDB);
				foodList.add(food);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return foodList;

	}

	public static Food getFood(int foodID) {

		

		try {

			Connection conn = ConnectionHelper.getConn();
			String searchQuery = "SELECT * FROM foodList where FOODID = '" + foodID + "'";
			Statement sqs = conn.createStatement();
			conn.commit();
			ResultSet rs = sqs.executeQuery(searchQuery);

			while (rs.next()) {
				int foodIDDB = rs.getInt("FOODID");
				String foodNameDB = rs.getString("FOODNAME");
				String sizeDB = rs.getString("SIZE");
				String caloriesDB = rs.getString("CALORIES");
				Food food = new Food(foodIDDB,foodNameDB, sizeDB, caloriesDB);
				return food;
			}
			

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;

	}
	
	

}

package com.sutton.sweatweb.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sutton.sweatweb.model.Food;
import com.sutton.sweatweb.model.FoodLogItem;

public class FoodDao {

	public static List<Food> getFood(String foodName) {

		List<Food> foodList = new ArrayList<Food>();

		try {

			Connection conn = ConnectionHelper.getConn();
			String searchQuery = "SELECT * FROM foodList where FOODNAME = '" + foodName + "'";
			Statement sqs = conn.createStatement();
			conn.commit();
			ResultSet rs = sqs.executeQuery(searchQuery);

			while (rs.next()) {
				String foodNameDB = rs.getString("FOODNAME");
				String sizeDB = rs.getString("SIZE");
				String caloriesDB = rs.getString("CALORIES");
				Food food = new Food(foodNameDB, sizeDB, caloriesDB);
				foodList.add(food);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return foodList;

	}

	public static boolean LogFood(FoodLogItem newFoodLogItem)throws SQLException {

		Connection conn;

		conn = ConnectionHelper.getConn();
		String user = newFoodLogItem.getUser();
		String logDate = newFoodLogItem.getLogDate();
		String foodName = newFoodLogItem.getFood().getFoodName();
		String size = newFoodLogItem.getFood().getSize();
		String calories = newFoodLogItem.getFood().getCalories();
		String insertQuery = "INSERT INTO userDietLog (USER,LOGDATE,FOODNAME,FOODSIZE,FOODCALORIES)VALUES "
				+ "('" + user + "','" + logDate + "','" + foodName +"','" + size +"','" + calories +"' );";
		Statement sqs = conn.createStatement();
		conn.commit();
		int returnCode = sqs.executeUpdate(insertQuery);
		return returnCode != 0;

	}

}

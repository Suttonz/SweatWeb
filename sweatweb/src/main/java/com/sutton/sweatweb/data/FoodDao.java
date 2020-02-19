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

	public static List<Food> getFood(String foodName) {

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

	public static boolean LogFood(FoodLogItem newFoodLogItem)throws SQLException {

		Connection conn;

		conn = ConnectionHelper.getConn();
		String user = newFoodLogItem.getUser();
		String logDate = newFoodLogItem.getLogDate();
		int foodID = newFoodLogItem.getFood().getFoodID();
		String insertQuery = "INSERT INTO userDietLog (USER,DATE,FOODID)VALUES "
				+ "('" + user + "','" + logDate + "'," + foodID +" );";
		Statement sqs = conn.createStatement();
		conn.commit();
		int returnCode = sqs.executeUpdate(insertQuery);
		return returnCode != 0;

	}

}

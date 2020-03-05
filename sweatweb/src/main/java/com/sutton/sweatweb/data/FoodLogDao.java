package com.sutton.sweatweb.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sutton.sweatweb.model.Food;
import com.sutton.sweatweb.model.FoodLogItem;

public class FoodLogDao {
	
	
	public static List<FoodLogItem> listFoodLogItems(String user,String date){
		
		
		
		List<FoodLogItem> foodLogItemList = new ArrayList<FoodLogItem>();

		try {

			Connection conn = ConnectionHelper.getConn();
			String searchQuery = "SELECT * FROM userdietlog where user = '" + user + "' and date = '"+date+"'";
			Statement sqs = conn.createStatement();
			conn.commit();
			ResultSet rs = sqs.executeQuery(searchQuery);

			while (rs.next()) {
				int foodID = rs.getInt("FOODID");				
				FoodLogItem foodLogItem = new FoodLogItem(user,date,foodID);
				foodLogItemList.add(foodLogItem);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return foodLogItemList;

	}
	
	
	public static boolean LogFood(FoodLogItem newFoodLogItem)throws SQLException {

		Connection conn;

		conn = ConnectionHelper.getConn();
		String user = newFoodLogItem.getUser();
		String logDate = newFoodLogItem.getLogDate();
		int foodID = newFoodLogItem.getFoodID();
		String insertQuery = "INSERT INTO userDietLog (USER,DATE,FOODID)VALUES "
				+ "('" + user + "','" + logDate + "'," + foodID +" );";
		Statement sqs = conn.createStatement();
		conn.commit();
		int returnCode = sqs.executeUpdate(insertQuery);
		return returnCode != 0;

	}

}

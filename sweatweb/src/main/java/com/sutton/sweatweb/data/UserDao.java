package com.sutton.sweatweb.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sutton.sweatweb.model.User;

public class UserDao {

	/**
	 * 
	 * @param userName
	 * @param password
	 * @return returns null if user not found
	 */
	public static User getUser(String userName, String password) {
		
		User user = null; 
		
		try {
			
			Connection conn = ConnectionHelper.getConn();
			
			String selectQuery = "SELECT * FROM userlist where USERNAME = '"+ userName + "'";
			ResultSet rs = null;

			Statement sqs = conn.createStatement();
			conn.commit();
			rs = sqs.executeQuery(selectQuery);
			if (rs.next())
			{
				String userDB = rs.getString("USERNAME");
				String passDB = rs.getString("PASSWORD");
				
				user = new User(userDB, passDB);
			} 

		} catch (SQLException e) {
			// TODO: log
			e.printStackTrace();
	    }
		
		return user;
	}
	
	public static boolean CreateUser(User newUser) throws SQLException{
		
		Connection conn;
		
		conn = ConnectionHelper.getConn();
		String userName = newUser.getUsername();
		String password = newUser.getPassword();
		String insertQuery ="INSERT INTO userList (USERNAME,PASSWORD)VALUES ('"+userName+"','"+password+"' );";
		Statement sqs = conn.createStatement();
		conn.commit();
		int returnCode = sqs.executeUpdate(insertQuery);
		
		// 0 is failure. We want to return true if success
		return returnCode != 0;
		
    }
}

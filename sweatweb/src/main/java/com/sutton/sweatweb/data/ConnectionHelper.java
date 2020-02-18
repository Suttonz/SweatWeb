package com.sutton.sweatweb.data;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {

	private static Connection conn;
	
	private final static String DATA_BASE_URL 	= "jdbc:h2:tcp://localhost/~/test";
	private final static String DATA_BASE_USER 	= "sa";
	private final static String DATA_BASE_PW 	= "";
	
	public static Connection getConn() throws SQLException
	{
		if (conn == null) {
			Driver d = new org.h2.Driver();
			DriverManager.registerDriver(d);
			conn = DriverManager.getConnection(DATA_BASE_URL, DATA_BASE_USER, DATA_BASE_PW);
		}
		return conn;
	}
}

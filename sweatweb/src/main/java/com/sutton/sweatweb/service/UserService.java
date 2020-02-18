package com.sutton.sweatweb.service;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException;

import com.sutton.sweatweb.data.UserDao;
import com.sutton.sweatweb.model.User;

public class UserService {

	private static final String PASSWORD_PATTERN = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40})";
    private Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
    private Matcher matcher;
	
	public boolean authenticateUser(String userName, String password) {
		
		User user = UserDao.getUser(userName, password);
		
		return user != null && user.getPassword().equals(password);
	}
	
	public boolean signUpUser(String userName, String password) throws Exception {
		
		// Validate pattern
		matcher = pattern.matcher(password);
		boolean isValid = matcher.matches();
		
		if(!isValid)
		{
			throw new IllegalArgumentException("Password format is invalid");
		} 
		
		// Try to insert
		User user = new User(userName, password);
		
		boolean success = false;
		try {
			success = UserDao.CreateUser(user);
			
		// User already exist
		} catch (JdbcSQLIntegrityConstraintViolationException e) {
			throw new IllegalArgumentException("Username already exisit");
			
		} catch (SQLException e) {
			throw new Exception("Something went wrong", e);
		} 
	
		return success;
	}
}

package com.sutton.sweatweb.model;

public class User {
	
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public User(String uN, String pW)
	{
		this.username = uN;
		this.password = pW;	
	}
}

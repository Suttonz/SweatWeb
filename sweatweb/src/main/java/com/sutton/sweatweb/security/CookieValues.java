package com.sutton.sweatweb.security;

import java.util.ArrayList;
import java.util.List;

public class CookieValues {
	
	public final static String COOKIE_NAME = "loginSafePin";
	public final static String USER_COOKIE_NAME = "userName";
	public final static int COOKIE_EXP = 120; // 2 minutes
	
	private static List<String> cookieVals = new ArrayList<String>();
	

	public synchronized static void AddValue(String value) {
		
		cookieVals.add(value);
		
	}

	public static boolean valueExist(String value)
	{
		return cookieVals.contains(value);
	}
	
	
	
}

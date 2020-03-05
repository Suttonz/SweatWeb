package com.sutton.sweatweb.controller.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.sutton.sweatweb.security.CookieValues;

public class RequestUtil {

	
	public static String getUserName(HttpServletRequest request) {

		String userName ="";
		Cookie[] cookies =  request.getCookies();

		for (Cookie cookie : cookies) {
			if (cookie.getName().equalsIgnoreCase(CookieValues.USER_COOKIE_NAME)) {

				 userName = cookie.getValue();
			}
		}
		return userName;
	}

}

package com.sutton.sweatweb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sutton.sweatweb.security.CookieValues;
import com.sutton.sweatweb.service.UserService;

@WebServlet(urlPatterns = "/login", name = "LoginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	
	private UserService userService = new UserService();

	/**
	 * 
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
       
		String userName = request.getParameter("username");
		String password = request.getParameter("password");

	
		boolean loginSuccessful = userService.authenticateUser(userName, password);
		
		PrintWriter out = response.getWriter();
		if (loginSuccessful) {
			
			// Unique id to set in our cookie
			UUID uuid = UUID.randomUUID();	
	        String randomUUIDString = uuid.toString();
			
	        // Keep a copie of this value in server memory
	        CookieValues.AddValue(randomUUIDString);
			
	        // Setup cookie
			Cookie cookie = new Cookie(CookieValues.COOKIE_NAME, randomUUIDString);
			cookie.setMaxAge(CookieValues.COOKIE_EXP); // cookie expires in 2 minutes
			
			
			// Put cookie in response
			response.addCookie(cookie);
			
			//Setup user Name cookie
			Cookie userNameCookie = new Cookie(CookieValues.USER_COOKIE_NAME,userName);
			
			//Put userName cookie into response 
			response.addCookie(userNameCookie);
			
			//redirect to main 
			response.sendRedirect("main.html");
			
			
		} else {
			
			out.println("password wrong!!");
		}
		
	}
}
package com.sutton.sweatweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			//out.println("login successed");
			response.sendRedirect("main.html");
			
		} else {
			
			out.println("password wrong!!");
		}
		
	}
}
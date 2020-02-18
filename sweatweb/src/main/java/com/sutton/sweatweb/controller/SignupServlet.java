package com.sutton.sweatweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sutton.sweatweb.service.UserService;

@WebServlet(urlPatterns = "/signup", name = "SignUpServlet")

public class SignupServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		

		String message = "";
		try {
			boolean success = userService.signUpUser(userName, password);
			if (success) {
				message = "yay you are a member now!";
			} else {
				
				message = "Something went wrong";
			}
			
		} catch (Exception e) {
			
			message = e.getMessage();
		}
		
		PrintWriter out = response.getWriter();
		out.println(message);

	}

}

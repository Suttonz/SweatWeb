package com.sutton.sweatweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sutton.sweatweb.service.FoodService;

@WebServlet(urlPatterns = "/foodLog", name = "FoodLogServlet")

public class FoodLogServlet extends HttpServlet {

	private FoodService foodService = new FoodService();

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String user = request.getParameter("user");
		String date = request.getParameter("date");
		String foodName = request.getParameter("foodName");
		String size = request.getParameter("size");
		String calories = request.getParameter("calories");

		boolean logSuccess = foodService.addFoodLogItem(user, date, foodName, size, calories);
		PrintWriter out = response.getWriter();
		if (logSuccess) {

			out.println("log food Success");
			//call front end to update info

		}else {
			out.println("log food failed");
		}
		

	}

}

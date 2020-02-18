package com.sutton.sweatweb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections4.CollectionUtils;

import com.sutton.sweatweb.model.Food;
import com.sutton.sweatweb.service.FoodService;

@WebServlet(urlPatterns = "/search", name = "SearchServlet")

public class SearchServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private FoodService foodService = new FoodService();

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String foodName = request.getParameter("foodname");
		List<Food> foodList = foodService.searchFood(foodName);
		PrintWriter out = response.getWriter();

		if (!CollectionUtils.isEmpty(foodList)) {
			for (Food food : foodList) {
				out.println(food.toString());
			}
		}else {
			out.println("No match found");
		}
	}

}

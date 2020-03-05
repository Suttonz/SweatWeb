package com.sutton.sweatweb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sutton.sweatweb.controller.util.RequestUtil;
import com.sutton.sweatweb.model.FoodLogItem;
import com.sutton.sweatweb.service.FoodLogService;

@WebServlet(urlPatterns = "/foodLog", name = "FoodLogServlet")

public class FoodLogServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FoodLogService foodLogService = new FoodLogService();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		//   retrieve user from cookie
	
		String user = RequestUtil.getUserName(request);	
		int foodID = Integer.parseInt(request.getParameter("foodID")); 
		String date = request.getParameter("date");
	
		boolean logSuccess = foodLogService.addFoodLogItem(user, date, foodID);
		PrintWriter out = response.getWriter();
		
		if (logSuccess) {

			out.println("log food Success");
			//call front end to update info

		}else {
			out.println("log food failed");
		}
		

	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String user = RequestUtil.getUserName(request);	
		String date = request.getParameter("date");
		List<FoodLogItem> foodLogItemList = foodLogService.searchFoodlogItem(user, date);
		
		PrintWriter out = response.getWriter();

		Gson gson = new Gson();
		String json = gson.toJson(foodLogItemList);
		out.println(json);
		response.setContentType("application/json");

		
	}

}

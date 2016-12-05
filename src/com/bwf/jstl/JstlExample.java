package com.bwf.jstl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JstlExample")
public class JstlExample extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//把List对象放入request
		request.setAttribute("list", initList());
		
		//把Map对象放入request
		request.setAttribute("map", initMap());
		
		//跳转
		request.getRequestDispatcher("/jstl/jstl.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	private List<String> initList(){
		List<String> list = new ArrayList<>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		list.add("five");
		list.add("two");
		return list;
	}
	
	private Map<String,String> initMap(){
		Map<String,String> map = new ConcurrentHashMap();
		map.put("one","一");
		map.put("two","二");
		map.put("three","三");
		map.put("four","四");
		map.put("five","五");
		map.put("two","六");
		return map;
	}

}

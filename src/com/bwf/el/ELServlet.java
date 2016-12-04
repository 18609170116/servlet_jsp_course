package com.bwf.el;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bwf.bean.User;

@WebServlet("/ELServlet")
public class ELServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("attr", "in request");
		request.getSession().setAttribute("attr", "in session");
		request.getServletContext().setAttribute("attr", "in application");
		//response.setHeader("el", "el表达式");
		
		Map<String, User> map = new HashMap<String,User>();
		User u = new User("tomato","password");
		map.put("tomato", u);
		
		request.setAttribute("userMap", map);
		
		request.getRequestDispatcher("/el/el.jsp?name=name123&hobby=book&hobby=e-sports").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

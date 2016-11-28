package com.bwf;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FormServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/form.jsp").forward(request, response);
		//response.getWriter().append("name="+(String)session.getAttribute("name"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		//原因是request会对中文字进行url编码（编码字符集是iso-8859-1），因此需要先解码，再用utf-8编码
		username = new String(username.getBytes("ISO-8859-1"),"UTF-8");
		request.setAttribute("username", username);
		
		String password = request.getParameter("password");
		request.setAttribute("password", password);
		
		request.getRequestDispatcher("/form_submitted.jsp").forward(request, response);
	}
}

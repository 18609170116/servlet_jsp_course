package com.bwf;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		//ServletContext context = config.getServletContext();
		
		// 演示获取所有初始化参数
		Enumeration<String> names = config.getInitParameterNames();
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			System.out.println(name + "=" + config.getInitParameter(name));
		}
		super.init(config);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ServletConfig config = getServletConfig();
		System.out.println(config);
		
		ServletContext context = getServletContext();
		System.out.println(context);
		
		String companyName = getServletConfig().getInitParameter("companyName");
		request.setAttribute("companyName", companyName);
		
		request.getRequestDispatcher("initParam.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

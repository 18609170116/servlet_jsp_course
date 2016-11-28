package com.bwf;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 测试Request和Response
 */
@WebServlet("/requestHeader")
public class RequestHeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RequestHeaderServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//getParameter(String strTextName) 获取表单提交的信息

		//getProtocol() 获取客户使用的协议
		String protocol  = request.getProtocol();

		//getServletPath() 获取客户提交信息的页面
		String servletPath = request.getServletPath();

		//getMethod() 获取客户提交信息的方式 
		String method=request.getMethod();

		//请求头keys数组
		String[] requestHeaders = new String[]{
				"Host",
				"Connection",
				"Cache-Control",
				"Upgrade-Insecure-Request",
				"User-Agent",
				"Accept",
				"Referer",
				"Accept-Encoding",
				"Accept-Language",
				"Cookie"
		};
		//存放获得的头keys及对应项
		String[] requestHeader_results = new String[requestHeaders.length];
		
		for (int i=0;i<requestHeaders.length;i++) {
			String header = requestHeaders[i];
			requestHeader_results[i] = requestHeaders[i] +" = " + request.getHeader(header);
		}

		//getRermoteAddr() 获取客户的IP地址。
		String clientIp = request.getRemoteAddr();

		//getRemoteHost() 获取客户机的名称。
		String clientName=request.getRemoteHost();

		//getServerName() 获取服务器名称。 
		String serverName=request.getServerName();

		//getServerPort() 获取服务器的端口号。 
		int serverPort=request.getServerPort();

		//getParameterNames() 获取客户端提交的所有参数的名字。 
		Map<String, String[]> params = request.getParameterMap();
		
		request.setAttribute("protocol", protocol);
		request.setAttribute("servletPath", servletPath);
		request.setAttribute("method", method);
		request.setAttribute("headers", requestHeader_results);
		request.setAttribute("clientIp", clientIp);
		request.setAttribute("clientName", clientName);
		request.setAttribute("serverName", serverName);
		request.setAttribute("serverPort", serverPort);
		request.setAttribute("params", params);
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("/requestHeader.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

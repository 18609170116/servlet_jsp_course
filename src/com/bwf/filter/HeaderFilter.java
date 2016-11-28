package com.bwf.filter;

import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/asdfasdfasdfasdf*")
public class HeaderFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 查看request中头信息
		HttpServletRequest req = (HttpServletRequest) request;
		Enumeration<String> req_head_names = req.getHeaderNames();
		procReqHeaders(req_head_names,req);

		// 查看response中头信息
		HttpServletResponse resp = (HttpServletResponse) response;
		Collection<String> resp_head_names = resp.getHeaderNames();
		procRespHeaders(resp_head_names,resp);
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

	//处理请求头
	private void procReqHeaders(Enumeration<String> head_names, HttpServletRequest req) {
		System.out.println("-----------请求头start--------------");
		while (head_names.hasMoreElements()) {
			String head_key = (String) head_names.nextElement();
			String head_value = req.getHeader(head_key);
			System.out.println(head_key + "=" + head_value);
		}
		System.out.println("-----------请求头end--------------");
	}
	
	//处理响应头
	private void procRespHeaders(Collection<String> head_names, HttpServletResponse resp) {
		System.out.println("-----------响应头start--------------");
		for (Iterator iterator = head_names.iterator(); iterator.hasNext();) {
			String head_key = (String) iterator.next();
			String head_value = resp.getHeader(head_key);
			System.out.println(head_key + "=" + head_value);
		}
		System.out.println("-----------响应头end--------------");
	}

}

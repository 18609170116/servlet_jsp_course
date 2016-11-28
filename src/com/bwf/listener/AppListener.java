package com.bwf.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppListener implements ServletContextListener {

	// 容器销毁的时候调用
	public void contextDestroyed(ServletContextEvent event) {

	}

	// 容器初始化的时候调用
	public void contextInitialized(ServletContextEvent event) {
		// 全局资源的初始化,比如说连接池
		ServletContext context = event.getServletContext();
		String au = context.getInitParameter("author");
		context.setAttribute("author", au);

	}

}

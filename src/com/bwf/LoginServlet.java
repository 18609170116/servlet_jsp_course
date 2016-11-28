package com.bwf;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bwf.bean.User;
import com.bwf.listener.SessionAttributeListener;
import com.bwf.listener.SessionCounterListener;
import com.bwf.model.UserService;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1、获取数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User(username,password);
		//业务逻辑处理
		UserService us = new UserService();
		boolean isLoginSuccess = us.valid(user);
		if (isLoginSuccess) {
			HttpSession session = request.getSession();
			if (session.isNew()) {
				request.setAttribute("sessionStatus", "新创建了session");
			}else{
				request.setAttribute("sessionStatus", "welcome back!");
			}
			//通常登陆成功后，把用户信息放入session中
			session.setAttribute("signInUser", user);
			
			//活跃的session数量
			session.setAttribute("activeSessions", SessionCounterListener.getActiveSessions());
			
			//在线用户数量
			session.setAttribute("onlineUserCount", SessionAttributeListener.getOnlineUserCount());
			
			//把当前登陆用户名放入cookie，可放多个Cookie对象
			response.addCookie(new Cookie("username", username));
			
			//转发视图
			request.setAttribute("isSuccess", isLoginSuccess);
			request.getRequestDispatcher("/loginSuccess.jsp").forward(request, response);
		}else{
			//失败时返回错误消息
			request.setAttribute("msg", "登陆失败，请检查用户名和口令");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

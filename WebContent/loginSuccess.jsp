<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java" import="com.bwf.bean.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆成功</title>
</head>
<body>
	<%
		String basePath = request.getContextPath();
	%>

	登陆成功
	<br> 状态：<%=request.getAttribute("sessionStatus")%>
	当前登陆用户：<%=((User) session.getAttribute("signInUser")).getUsername()%><br>
	活跃的session数：<%=session.getAttribute("activeSessions")%><br>
	在线用户数：<%=session.getAttribute("onlineUserCount")%><br>
	
	<!-- 超链接去另外一个页面，看会话中的信息是否存在 -->
	<%
		String info = response.encodeURL(basePath + "/info.jsp");
	%>
	<h3>
		<a href="<%=info%>">url重写</a>
	</h3>
	<a href="<%=basePath%>/logout"> 退出/重新登陆 </a>
</body>
</html>
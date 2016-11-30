<%@page import="org.eclipse.jdt.internal.compiler.ast.IfStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
</head>
<body>
	<%
		String basePath = request.getContextPath();
	%>

	<h1>用户登陆</h1>
	
	<!-- 从Cookie中取用户名 -->
	<%
	String username = "";
	Cookie[] cookies = request.getCookies();
	if(cookies != null){
		for(int i=0;i<cookies.length;i++){
			Cookie cookie = cookies[i];
			if(cookie.getName().equals("username")){
				username=cookie.getValue();
				break;
			}
		}
	}
	
	%>
	

	<!-- 错误信息显示 -->
	<%
		String msg = (String) request.getAttribute("msg");
		if (null != msg) {
			out.println("<h2 style=\"color:red\">" + msg + "</h2>");
		}
	%>

	<!-- 用户登陆表单 -->
	<form action="<%=basePath%>/login" method="post">
		用户名：<input type="text" name="username" value="<%=username%>"/><br> 
		密码：    <input	type="password" name="password" /><br> 
		<input type="submit" value="登陆" />
	</form>
</body>
</html>
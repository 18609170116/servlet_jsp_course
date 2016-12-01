<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>welcome</title>
</head>
<body>
	<%
		String basePath = request.getContextPath();
	%>
	<%
		String username = (String) request.getAttribute("username");
		String password = (String) request.getAttribute("password");
		out.println("hello, " + username + "<br>");
		out.println("加密后口令为 " + password);
	%>
	
</body>
</html>
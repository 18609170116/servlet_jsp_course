<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>





	有时候，一些参数在将来可能会变，就不适合写死在代码里，处理方式是配置在web.xml中的Servlet声明部分 比如本例中的公司名称：
	<hr>
	<%=(String) request.getAttribute("companyName")%>
	<br>
</body>
</html>
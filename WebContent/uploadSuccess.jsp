<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>smartupload文件上传</title>
</head>
<body>
	<%
		String basePath = request.getContextPath();
	%>
	
	<br>
	<h2>文件上传成功</h2>
	服务器端文件名：
	<%
		String filename = (String) request.getAttribute("fileName");
		out.println(filename);
	%>
	<br>
	--------------------------------------------------------<br>
	显示服务器端刚刚上传的图片
	<br>
	<%
		String imgUrl = (String) request.getAttribute("fileUrl");
		if(imgUrl != null){
			out.println("<img src='" + imgUrl +"' />");
		}
	%>
</body>
</html>
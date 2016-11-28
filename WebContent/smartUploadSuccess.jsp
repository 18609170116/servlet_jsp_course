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
	
	json格式上传结果：
	<br>
	<pre>
		<%
			String json = (String) request.getAttribute("json");
			out.println(json);
		%>
	</pre>
----------------------------------------------------------------------------------
	<br>
	文件上传成功，服务器端文件名为
	<%
		String filename = (String) request.getAttribute("fileName");
		out.println(filename);
	%>
	<br>
	<%
		String realPath = (String) request.getAttribute("realPath");
		out.println("服务端文件真实路径 " + realPath);
	%>
	<br>
	显示服务器端刚刚上传的图片
	<br>
	<%
		String imgUrl = (String) request.getAttribute("imgUrl");
		if(imgUrl != null){
			out.println("<img src='" + imgUrl +"' />");
		}
	%>
</body>
</html>
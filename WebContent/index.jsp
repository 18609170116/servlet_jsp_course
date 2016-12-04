<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>
</head>
<body>
	<%
		String basePath = request.getContextPath();
	%>

	<h1>Jsp/Servlet示例</h1>

	<h3>
		<a href="<%=basePath%>/requestHeader">request头信息</a>
	</h3>

	<h3>
		<a href="<%=basePath%>/form">表单提交</a>
	</h3>
	<h3>
		<a href="<%=basePath%>/upload">原生文件上传</a>
	</h3>
	<h3>
		<a href="<%=basePath%>/smartUpload">smartupload方式 文件上传</a>
	</h3>
	<h3>
		<a href="<%=basePath%>/servlet3Upload">Servlet3方式 文件上传</a>
	</h3>
	<h3>
		<a href="<%=basePath%>/downloadFile">图片显示与下载</a>
	</h3>
	<h3>
		<a href="<%=basePath%>/initParam">Servlet初始化参数</a>
	</h3>
	<h3>
		<a href="<%=basePath%>/getContextAttr.jsp">ServletContextLister示例</a>
	</h3>
	<h3>
		<a href="<%=basePath%>/#">HeaderFilter，请查看web.xml</a>
	</h3>
	<h3>
		<a href="<%=basePath%>/login.jsp">登陆例子</a>
	</h3>
	<h3>
		<a href="<%=basePath%>/ELServlet?name=123&hobby=book&hobby=e-sports">EL表达式</a>
	</h3>


	<br>
	<script type="text/javascript" src="js/md5.js"></script>
	<script>
		function checkForm() {
			var input_pwd = document.getElementById('input-password');
			var md5_pwd = document.getElementById('md5-password');
			// 把用户输入的明文变为MD5:
			md5_pwd.value = hex_md5(input_pwd.value);
			// 继续下一步:
			return true;
		}
	</script>

	<hr>
	<%
		String companyName = (String) request.getAttribute("companyName");
		out.print("此处演示application范围内的参数:<br>");
		out.print("tel:"+application.getInitParameter("tel"));
	%>

</body>
</html>
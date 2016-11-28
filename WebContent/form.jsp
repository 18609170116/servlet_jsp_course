<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<h3>欢迎，请输入用户名和口令</h3>
	<form id="login-form" action="<%=basePath%>/form" method="post" onsubmit="return checkForm()">
		<table>
			<tr>
				<td>用户名</td>
				<td><input type="text" id="username" name="username"></td>
			</tr>
			<tr>
				<td>口令</td>
				<td><input type="password" id="input-password"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="hidden" id="md5-password" name="password"></td>
			</tr>
		</table>

		<button type="submit">提交</button>
	</form>




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

</body>
</html>
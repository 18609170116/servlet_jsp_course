<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>el表达式</title>
<style>
.important {
	color: darkgreen;
	font-weight: bold;
	background-color: #eee;
	border: 1px solid red;
}

.normal {
	border: 1px solid #ddd;
}
</style>
</head>
<body>
	<!-- 测试移除属性后 	-->
	<%
		//session.removeAttribute("attr");
	%>

	<table>
		<caption>EL表达式获取属性值</caption>
		<tr>
			<td>当前页面所对应的类：</td>
			<td>
				<%
					pageContext.setAttribute("attr", "in pageScope", PageContext.PAGE_SCOPE);
					out.write(getClass().toString());
				%>
			</td>
		</tr>
		<tr>
			<td>不指派范围</td>
			<td class="important">${attr}</td>
		</tr>
		<tr>
			<td>指派pageScope范围</td>
			<td class="important">${pageScope.attr}</td>
		</tr>
		<tr>
			<td>指派requestScope范围</td>
			<td class="important">${requestScope.attr}</td>
		</tr>
		<tr>
			<td>指派sessionScope范围</td>
			<td class="important">${sessionScope.attr}</td>
		</tr>
		<tr>
			<td>指派applicationScope范围</td>
			<td class="important">${applicationScope.attr}</td>
		</tr>
		<tr>
			<td><br></td>
			<td><br></td>
		</tr>
		<tr>
			<td>获得参数1</td>
			<td class="important">${param.name}</td>
		</tr>
		<tr>
			<td>获得参数2</td>
			<td class="important">第一个爱好是${paramValues.hobby[0]},第二个爱好是${paramValues.hobby[1]}</td>
		</tr>
		<tr>
			<td>获得header中的Accept属性</td>
			<td class="normal">${header.Accept}</td>
		</tr>
		<tr>
			<td>获得header中的Accept-Encoding属性</td>
			<td class="normal">${header["Accept-Encoding"]}=<%=request.getHeader("Accept-Encoding")%></td>
		</tr>
		<tr>
			<td>获得session id</td>
			<td class="normal">${pageContext.session.id }</td>
		</tr>
		<tr>
			<td>获得initParam中的tel</td>
			<td class="important">${initParam.tel}</td>
		</tr>
		<tr>
			<td><br></td>
			<td><br></td>
		</tr>
		<tr>
			<td>访问Map及Bean的属性</td>
			<td class="important">用户名=${userMap.tomato.username },密码=${userMap.tomato.password }</td>
		</tr>
	</table>

</body>
</html>
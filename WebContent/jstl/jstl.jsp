<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>显示转义字符</h2>
	<c:out value="&lt要显示的数据对象（未使用转义字符）&gt" escapeXml="true" default="默认值"></c:out>
	<br />
	<c:out value="&lt要显示的数据对象（使用转义字符）&gt" escapeXml="false" default="默认值"></c:out>
	<br />

	<h2>变量为空时的显示效果</h2>
	<c:set var="salary" scope="page" value="${2000*2}" />
	<c:set var="salary" scope="session" value="8万" />
	<c:out value="${salary}">使用的表达式结果为null，则输出该默认值</c:out><br>
	<c:out value="${anotherVar}">使用的表达式结果为null，则输出该默认值</c:out><br>
	<c:remove var="salary" scope="page"/>
	移除page范围内的salary后<br>
	<c:out value="${salary}">使用的表达式结果为null，则输出该默认值</c:out><br>
	<br />

	<c:out value="<c:out /> Tag"></c:out>
</body>
</html>
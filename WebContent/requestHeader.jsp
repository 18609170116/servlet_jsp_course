<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试request and response</title>
</head>
<body>
<h1>request头信息</h1>
<h3><span>协议：<%=request.getAttribute("protocol") %></span></h3>
<h3><span>提交页面的路径：<%=request.getAttribute("servletPath") %></span></h3>
<h3><span>方法：<%=request.getAttribute("method") %></span></h3>
<h2>头headers：</h2>
<table style="border: 1px solid #cad9ea">
	<c:forEach var="var" items="${headers}" >
	<tr><td style="border: 1px dotted #eee"><c:out value="${var}"/></td></tr>
	</c:forEach>
</table>	
<h3><span>客户端IP：<%=request.getAttribute("clientIp") %></span></h3>
<h3><span>客户端名称：<%=request.getAttribute("clientName") %></span></h3>
<h3><span>服务器名称：<%=request.getAttribute("serverName") %></span></h3>
<h3><span>服务器端口：<%=request.getAttribute("serverPort") %></span></h3>
<h2>参数params:</h2>
<table style="border: 1px solid #cad9ea">
	<c:forEach var="map" items="${params}" >
		<tr>
			<td style="border: 1px solid #eee">${map.key} = </td>
		    <c:forEach var="items" items="${map.value}">
			    <td style="border: 1px solid #eee">
					${items}
				</td>
	    	</c:forEach>
		</tr>
	</c:forEach>
</table>
</body>
</html>
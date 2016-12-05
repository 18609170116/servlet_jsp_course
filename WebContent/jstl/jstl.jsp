<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL示例</title>
<style>
	div{
	border:1px solid orange;
	margin:10px 10px;
	background:#eee;
	}
</style>
</head>
<body>

<div>
	<h2>c:out显示转义字符</h2>
	<c:out value="&lt要显示的数据对象（未使用转义字符）&gt" escapeXml="true" default="默认值"></c:out>
	<br />
	<c:out value="&lt要显示的数据对象（使用转义字符）&gt" escapeXml="false" default="默认值"></c:out>
	<br />
</div>

<div>
	<h2>c:out变量为空时的显示效果,结合c:set c:remove</h2>
	<c:set var="salary" scope="page" value="${2000*2}" />
	<c:set var="salary" scope="session" value="8万" />
	<c:set target="${map}" property="school" value="成都博为峰"></c:set>
	
	
	<c:out value="${salary}">使用的表达式结果为null，则输出该默认值</c:out><br>
	<c:out value="${anotherVar}">使用的表达式结果为null，则输出该默认值</c:out><br>
	<c:remove var="salary" scope="page"/>
	移除page范围内的salary后<br>
	<c:out value="${salary}">使用的表达式结果为null，则输出该默认值</c:out><br>
	<br />

	<c:out value="<c:out /> Tag"></c:out>
</div>

<div>
	<h2>forEach</h2>
	<h3>数组及结合c:if c:choose c:when c:otherwise</h3>
	<!-- step指定步长 -->
	<c:forEach var="i" begin="1" end="10" step="2">
		<li>i=${i }
<%-- 			<c:if test="${i>3 }">
				比3大
			</c:if> --%>
			
<%-- 			<c:choose>
				<c:when test="${i<3}">比3小</c:when>
				<c:when test="${i<5}">比5小</c:when>
				<c:when test="${i==5}">OK,刚好是5</c:when>
				<c:otherwise>比5大</c:otherwise>
			</c:choose> --%>
		</li>
	</c:forEach>
	
	<!-- 访问List -->
	<h3>List</h3>
	<c:forEach var="item" items="${list}">
		<li>${item}</li>
	</c:forEach>
	
	<!-- 访问Map -->
	<h3>Map</h3>
	<c:forEach items="${map}" var="item"> 
		<li>${item.key }= ${item.value }</li> 
    </c:forEach> 
</div>

<div>
    <h2>forToken</h2>
    <!-- items指定原串，delims指定分隔符 -->
    <c:forTokens var="item" items="<Once)Upon,A(Time%There..." delims="<),(%">
    	<li>${item}</li>
    </c:forTokens>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path +"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<title>图片显示与下载</title>
<style>
table{
  border: 1px solid #cad9ea
}
td {
  text-align: center;
  border: 1px dotted #eee;
}
img{
  height:100px;
}
button{
  cursor:pointer;
}
</style>
</head>
<body>
	<h1>图片缩略图显示与下载</h1>
	<form name="downForm" method="post" action="">
		<table>
			<tr>
			    <td><img alt="图片" src="img/jd.gif" /></td>
				<td><button type="button" onclick="downloadFile('<%=basePath%>','jd.gif')">下载</button></td>
			</tr>
			<tr>
				<td><img alt="图片" src="img/图片1.jpg" /></td>
				<td><button type="button" onclick="downloadFile('<%=basePath%>','图片1.jpg')">下载</button></td>			
			</tr>
		</table>
	</form>
	
	<script>
		function downloadFile(filePath,fileName) {
			var url="download.jsp?filePath="+filePath+"&fileName="+fileName;
		      	document.all.downForm.action=url;
		      	document.all.downForm.submit();
		}
	</script>
</body>
</html>
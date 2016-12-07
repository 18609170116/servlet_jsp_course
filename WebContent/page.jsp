<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.bwf.page.Employee"%>
<jsp:useBean id="page2" scope="request" class="com.bwf.page.PageBean" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分页示例</title>
<script>
	function Jumping() {
		document.PageForm.submit();
		return;
	}

	function gotoPage(pagenum) {
		document.PageForm.jumpPage.value = pagenum;
		document.PageForm.submit();
		return;
	}
</script>
</head>
<body bgcolor="#ffffff">
	<table border="1">
		<%
			String s = String.valueOf(page2.getCurPage());
			try {
				ArrayList<Employee> list = page2.getResult(s).data;
				for (int i = 0; i < list.size(); i++) {
					Employee emp = list.get(i);
		%>
		<tr>
			<td><%=emp.getEmp_id()%></td>
			<td><%=emp.getFname()%></td>
			<td><%=emp.getHire_date()%></td>
			<td><%=emp.getJob_id()%></td>
			<td><%=emp.getJob_lvl()%></td>
			<td><%=emp.getLname()%></td>
			<td><%=emp.getStatus()%></td>
			<td></td>
		</tr>
		<%
			}
			} catch (Exception e) {
			}
		%>
	</table>
	<%
		if (page2.getMaxPage() != 1) {
	%>
	<form name="PageForm" action="pageservlet" method="post">
		每页
		<%=page2.rowsPerPage%>
		行 共
		<%=page2.getMaxRowCount()%>行 第
		<%=page2.getCurPage()%>
		页 共
		<%=page2.getMaxPage()%>页 <BR>
		<%
			if (page2.getCurPage() == 1) {
					out.print(" 首页 上一页");
				} else {
		%>
		<a HREF="javascript:gotoPage(1)">首页</A> <a
			HREF="javascript:gotoPage(<%=page2.getCurPage() - 1%>)">上一页</A>
		<%
			}
		%>
		<%
			if (page2.getCurPage() == page2.getMaxPage()) {
					out.print("下一页 尾页");
				} else {
		%>
		<a HREF="javascript:gotoPage(<%=page2.getCurPage() + 1%>)">下一页</A> <a
			HREF="javascript:gotoPage(<%=page2.getMaxPage()%>)">尾页</A>
		<%
			}
		%>
		转到第 <SELECT name="jumpPage" onchange="Jumping()">
			<%
				for (int i = 1; i <= page2.getMaxPage(); i++) {
						if (i == page2.getCurPage()) {
			%>
			<OPTION selected value="<%=i%>"><%=i%>
			</OPTION>
			<%
				} else {
			%>
			<OPTION value="<%=i%>"><%=i%>
			</OPTION>
			<%
				}
					}
			%>
		</SELECT> 页
	</form>
	<%
		}
	%>
</body>
</html>

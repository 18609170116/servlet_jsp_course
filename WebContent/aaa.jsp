<%@page import="java.io.FileFilter"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>成都博为峰</title>
</head>
<body>

<span>
    
    <h1>hello， 博为峰的小伙伴们，这是公司新购的阿里云web服务器的根路径。</h1>
    <strong><h2 style="color:red">云服务器是按流量计费的，每小时上传下载总流量不能超过100M，因此，请不要上传大文件哟！</h2><strong>
    <h2>目前有3个课程： <span style="background-color:#ccc">course</span>、<span style="background-color:#ccc">j2ee_lgm</span>和<span style="background-color:#ccc">Jsp/Servlet示例</span></h2>
    <h2>如果需要新增课程，请新建一个目录，并把访问入口以相对路径方式加到此页面，谢谢！~good luck</h2>
</span>

--------------------------------------------------------------------------------
<span>
    <h3>以下链接指向课程：</h3>
<%
	String path = application.getRealPath("/");
	File pathFile = new File(path);
	
	File[] dirs = pathFile.listFiles(new FileFilter(){
		public boolean accept(File f) {
			return f.isDirectory() && !f.getName().startsWith(".");
		}
	});
	
	
	for(File dir : dirs){
		String f = dir.getName();
		if(f.equals("docs")) {
			out.print("<h3><a href= \""+f+"\">" + "tomcat文档" + "</a></h3>");
		}else if(f.equals("examples")){
			out.print("<h3><a href= \""+f+"\">" + "tomcat例子" + "</a></h3>");
		}else{
		out.print("<h3><a href= \""+f+"\">"+f+"</a></h3>");
		}
	}
	
%>
</span>

</body>
</html>

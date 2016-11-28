<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>download</title>
</head>
<body>
	<%@ page import="java.io.OutputStream"%>
	<%@ page import="java.io.FileInputStream"%>
	<%! String name="梁广明"; %>
	<%

		//解决weblogic下报错问题
		response.reset();                                                                                                                                                                                                                                                                              

		String path = request.getParameter("filePath");

		String fileName = name + request.getParameter("fileName");

		response.setContentType("application/x-download");
		response.addHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\"");

		OutputStream ops = null;
		FileInputStream fis = null;
		try {
			ops = response.getOutputStream();
			fis = new FileInputStream(path + fileName);
			byte[] b = new byte[1024];
			int i = 0;
			while ((i = fis.read(b)) > 0) {
				ops.write(b, 0, i);
			}
			fis.close();
			ops.flush();
			ops.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				fis.close();
				fis = null;
			}
			if (ops != null) {
				ops.close();
				ops = null;
			}
		}
	%>
</body>
</html>
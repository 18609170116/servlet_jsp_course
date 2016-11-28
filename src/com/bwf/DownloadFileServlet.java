package com.bwf;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/downloadFile")
public class DownloadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DownloadFileServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/imgShowAndDownload.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//解决weblogic下报错问题
		response.reset();                                                                                                                                                                                                                                                                              

		String path = request.getParameter("filePath");

		String name = request.getParameter("fileName");

		response.setContentType("application/x-download");
		response.addHeader("Content-Disposition", "attachment;filename=\"" + name + "\"");

		OutputStream ops = null;
		FileInputStream fis = null;
		try {
			ops = response.getOutputStream();
			fis = new FileInputStream(path + name);
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
	}

}

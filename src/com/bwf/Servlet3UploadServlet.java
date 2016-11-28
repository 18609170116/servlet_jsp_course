package com.bwf;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.alibaba.fastjson.JSON;

@WebServlet("/servlet3Upload")
@MultipartConfig
public class Servlet3UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Servlet3UploadServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/servlet3Upload.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获得协议：主机名：端口/上下文路径
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath();

		// 格式：每天上传文件以日期分目录，文件名=原来文件名_时分秒_3位随机整数.原来后缀
		// 准备目录
		IPTimeStamp stamp = new IPTimeStamp();
		String uploadFolder = stamp.getDate() + File.separator;

		Part part = request.getPart("test-image-file");
		// 格式如：form-data; name="upload"; filename="YNote.exe"
		String disposition = part.getHeader("content-disposition");
		System.out.println(disposition);
		
		String fileName = disposition.substring(disposition.lastIndexOf("=") + 2, disposition.length() - 1);
		System.out.println(fileName);
		fileName = fileName.substring(fileName.lastIndexOf(File.separator) + 1);
		String fileType = part.getContentType();
		long fileSize = part.getSize();
		System.out.println("fileName: " + fileName);
		System.out.println("fileType: " + fileType);
		System.out.println("fileSize: " + fileSize);
		String uploadPath = request.getServletContext().getRealPath("/" + uploadFolder);
		System.out.println("uploadPath" + uploadPath);

		// 判断目录是否存在，不存在则新建目录
		if (!new java.io.File(uploadPath).isDirectory()) {
			new java.io.File(uploadPath).mkdirs();
		}

		part.write(uploadPath + File.separator + fileName);

		String url = basePath + "/" + uploadFolder + fileName;
		url = url.replace("\\", "/");

		UploadFileMessage msg = new UploadFileMessage();
		msg.setStatus(200);
		msg.setMessage("上传成功");
		msg.setUrl(url);
		request.setAttribute("json", JSON.toJSONString(msg));

		request.setAttribute("realPath", uploadPath);
		request.setAttribute("fileName", fileName);
		request.setAttribute("imgUrl", url);

		// 返回页面
		request.getRequestDispatcher("/servlet3UploadSuccess.jsp").forward(request, response);
	}
}

package com.bwf;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.jspsmart.upload.File;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;


@WebServlet("/smartUpload")
public class SmartUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SmartUploadServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/smartUpload.jsp").forward(request, response);
		// response.getWriter().append("name="+(String)session.getAttribute("name"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() + request.getContextPath();
		//System.out.println(basePath);
		
		//格式：每天上传文件以日期分目录，文件名=原来文件名_时分秒_3位随机整数.原来后缀
		//准备目录
		IPTimeStamp stamp = new IPTimeStamp();
		String uploadFolder = stamp.getDate()+SeparatorUtils.getFileSeparator();
		
		String url = null;
		
		//使用jsp smartload处理文件上传
		SmartUpload su = new SmartUpload();
		su.setCharset("UTF-8");
		//初始化上传操作
		su.initialize(this.getServletConfig(), request, response);
		try {
			//上传准备
			su.upload();

			//SmartUpload自己封装的request
			Request req = su.getRequest();
				
			//准备文件名
			File file = su.getFiles().getFile(0);
			String originalFileName = file.getFileName();
			originalFileName = originalFileName.substring(0, originalFileName.lastIndexOf("."));
			String fileName = originalFileName + "_" +stamp.getTimeStamp()+"_"+ new Random().nextInt(100) + "." + file.getFileExt();
			
			url = basePath + "/" + uploadFolder + fileName;
			url = url.replace("\\", "/");
			
			//放入请求，以备后用
			request.setAttribute("imgUrl", url);
			
			// 将上传文件全部保存到指定目录
			String uploadPath = request.getRealPath("/")+uploadFolder;//选定上传的目录此处为当前目录
			if(!new java.io.File(uploadPath).isDirectory()){
			   new java.io.File(uploadPath).mkdirs();
			}
			
			//文件保存
			file.saveAs(uploadFolder + fileName);
			String contextPath = this.getServletContext().getContextPath();
			String realPath = this.getServletContext().getRealPath("/uploadFiles");
			
			request.setAttribute("contextPath", contextPath);
			request.setAttribute("realPath", realPath);
			request.setAttribute("fileName", fileName);

		} catch (SmartUploadException e) {
			UploadFileMessage msg = new UploadFileMessage();
			msg.setStatus(400);
			msg.setMessage(e.getMessage());
			//返回json串
			//response.getWriter().append(JSON.toJSONString(msg));
			
			//返回页面
			request.setAttribute("json", JSON.toJSONString(msg));
			request.setAttribute("result", "上传失败了， 原因是:" + e.getMessage());
			request.getRequestDispatcher("/upload.jsp").forward(request, response);
		}

		UploadFileMessage msg = new UploadFileMessage();
		msg.setStatus(200);
		msg.setMessage("上传成功");
		msg.setUrl(url);
		
		//返回json串
		//response.getWriter().append(JSON.toJSONString(msg));
		
		//返回页面
		request.setAttribute("json", JSON.toJSONString(msg));
		request.getRequestDispatcher("/smartUploadSuccess.jsp").forward(request, response);
	}
}

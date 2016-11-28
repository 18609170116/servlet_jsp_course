package com.bwf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 普通方式文件上传
 */
@WebServlet("/upload")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/upload.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 先将文件上传至服务器端 ，作为临时文件
		
		String tempFileName = new String("tempFileName");
		String tempFilePath = request.getServletContext().getRealPath("/" + tempFileName);
		// tempfile 对象指向临时文件
		File tempFile = new File(tempFilePath);
		// outputfile 文件输出流指向这个临时文件
		FileOutputStream ops = new FileOutputStream(tempFile);
		// 得到客服端提交的所有数据
		InputStream ins = request.getInputStream();
		// 将得到的客服端数据写入临时文件
		byte b[] = new byte[1000];
		int n;
		while ((n = ins.read(b)) != -1) {
			ops.write(b, 0, n);
		}
		// 关闭输出流和输入流
		ops.close();
		ins.close();

		// 从临时文件中解析，获得原文件名和二进制文件的起始位置

		// randomFile对象指向临时文件
		RandomAccessFile randomFile = new RandomAccessFile(tempFile, "r");
		// 读取临时文件的第一行数据
		randomFile.readLine();
		// 读取临时文件的第二行数据，这行数据中包含了文件的路径和文件名
		String filePath = randomFile.readLine();
		// 得到文件名
		int position = filePath.lastIndexOf('=');

		//文件中的编码为iso8859-1,因此需要先转成
		String filename = codeString(filePath.substring(position+2, filePath.length() - 1),"ISO8859-1");
		// 重新定位读取文件指针到文件头
		randomFile.seek(0);
		// 得到第四行回车符的位置，这是上传文件数据的开始位置
		long forthEnterPosition = 0;
		int forth = 1;
		while ((n = randomFile.readByte()) != -1 && (forth <= 4)) {
			if (n == '\n') {
				forthEnterPosition = randomFile.getFilePointer();
				forth++;
			}
		}

		//向服务器正式写上传文件
		
		// 服务器端上传文件目录
		String uploadFolder = new String("uploads" + File.separator);
		// 服务器端实际上传目录路径
		String uploadPath = request.getServletContext().getRealPath("/" + uploadFolder);
		// 判断目录是否存在，不存在则新建目录
		if (!new java.io.File(uploadPath).isDirectory()) {
			new java.io.File(uploadPath).mkdirs();
		}
		
		// 上传后的文件名:年月日时分秒+3位随机数字+原文件名
		String fileName = generateFileName() + new Random().nextInt(100)+filename;

		// saveFile 对象指向要保存的文件
		File saveFile = new File(uploadPath, fileName);
		RandomAccessFile randomAccessFile = new RandomAccessFile(saveFile, "rw");
		// 找到上传文件数据的结束位置，即倒数第四行
		randomFile.seek(randomFile.length());
		long endPosition = randomFile.getFilePointer();

		// 从上传文件数据的开始位置到结束位置，把数据写入到要保存的文件中
		randomFile.seek(forthEnterPosition);
		long startPoint = randomFile.getFilePointer();
		while (startPoint < endPosition) {
			randomAccessFile.write(randomFile.readByte());
			startPoint = randomFile.getFilePointer();
		}
		// 关闭文件输入、输出
		randomAccessFile.close();
		randomFile.close();
		tempFile.delete();
		
		//如果前面没转，这里需要转一下
		request.setAttribute("fileName",  fileName);
		
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath();
		request.setAttribute("fileUrl", basePath+"/"+uploadFolder+fileName);
		request.getRequestDispatcher("/uploadSuccess.jsp").forward(request, response);
		
	}

	// 处理中文字符串编码
	public String codeString(String str,String charset) {
		String s = str;
		try {
			byte[] temp = s.getBytes(charset);
			s = new String(temp);
			return s;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return s;
		}
	}

	private String generateFileName() {
		// 格式：每天上传文件以日期分目录，文件名=原来文件名_时分秒_3位随机整数.原来后缀
		// 准备目录
		IPTimeStamp stamp = new IPTimeStamp();
		return stamp.getDateAndTime();
	}

}

package com.bwf;

public class UploadFileMessage {
	//状态
	private int status;
	//信息
	private String message;
	//文件URL
	private String url;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}

package com.bwf.bean;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class User implements HttpSessionBindingListener {
	private String username;
	private String password;
	private boolean login;

	public boolean isLogin() {
		return login;
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent evt) {
		System.out.println("我被加入到session中了，我要做点事");
		login = true;
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent evt) {
		// TODO Auto-generated method stub
		System.out.println("我已经被session移除了，55555");
		login = false;
	}

}

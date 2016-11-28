package com.bwf.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class SessionAttributeListener implements HttpSessionAttributeListener {
	private static int onlineUserCount;

	public static int getOnlineUserCount() {
		return onlineUserCount;
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent evt) {
		String name = evt.getName();
		System.out.println("add session attr:" + name + " 类：" + this.getClass().getSimpleName());
		if (name.equals("signInUser")) {
			onlineUserCount++;
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent evt) {
		String name = evt.getName();
		System.out.println("remove session attr:" + name + " 类：" + this.getClass().getSimpleName());
		if (name.equals("signInUser")) {
			onlineUserCount--;
		}
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent evt) {
	}

}

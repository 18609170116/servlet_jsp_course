package com.bwf.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionCounterListener implements HttpSessionListener {
	private static int activeSessions;
	
	//通过该方法查看活跃的session数量
	
    public static int getActiveSessions() {
		return activeSessions;
	}

	public void sessionCreated(HttpSessionEvent arg0)  { 
    	System.out.println("新建了session....");
    	activeSessions++;
    }

    public void sessionDestroyed(HttpSessionEvent arg0)  { 
    	System.out.println("销毁了session....");
    	activeSessions--;
    }
}

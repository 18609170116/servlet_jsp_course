package com.bwf.page;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {

	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/demo_test?user=root&password=whosyourdaddy&useUnicode=true&characterEncoding=UTF8";

	private static Connection conn = null;

	public static Connection getConnection() {
		if (conn == null) {
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url);
			} catch (ClassNotFoundException e) {
				System.out.println("无法找到驱动类");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}

	public static void closeStatement(Statement stat) {
		try {
			if (stat != null) {
				stat.close();
				stat = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void closeConnection(Connection conn) {
		try {
			if (conn != null && (!conn.isClosed())) {
				conn.close();
			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		}
	}

	public static void closeResultSet(ResultSet rset) {
		try {
			if (rset != null) {
				rset.close();
			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		}
	}
}
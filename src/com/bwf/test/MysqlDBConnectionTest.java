package com.bwf.test;

import java.sql.Connection;

import org.junit.Test;

import com.bwf.db.MysqlDBConnection;

public class MysqlDBConnectionTest {

	@Test
	public void test() {
		MysqlDBConnection connection = new MysqlDBConnection();
		Connection conn = connection.getConnection();
		System.out.println("获得数据库连接对象");
		connection.closeConnection(conn);
	}

}

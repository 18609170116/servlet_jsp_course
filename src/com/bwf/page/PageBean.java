package com.bwf.page;

import java.util.ArrayList;
import java.sql.*;

public class PageBean {

	private int curPage = 1; // 当前是第几页
	private int maxPage; // 一共有多少页
	private int maxRowCount; // 一共有多少行
	public int rowsPerPage = 10; // 每页多少行

	Connection conn;
	public ArrayList<Employee> data;

	public PageBean() throws Exception {
		this.setPageBean();
	}

	public int getCurPage() {
		return curPage;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public int getMaxRowCount() {
		return maxRowCount;
	}

	public int getRowsPerPage() {
		return rowsPerPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public void setMaxRowCount(int maxRowCount) {
		this.maxRowCount = maxRowCount;
	}

	public void setRowsPerPage(int rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}

	// 得到要显示于本页的数据
	public PageBean getResult(String page) throws Exception {
		try {
			PageBean pageBean = new PageBean();
			ArrayList<Employee> list = new ArrayList<>();
			int pageNum = Integer.parseInt(page);
			Statement stmt = conn.createStatement();
			String strSql = "select * from employee limit "+ (curPage-1) * rowsPerPage +","+ pageNum * rowsPerPage;
			ResultSet rset = stmt.executeQuery(strSql);
			while (rset.next()) {

				// 这里要和表的字段对应起来！！！！
				Employee employee = new Employee();
				employee.setEmp_id(rset.getString("emp_id"));
				employee.setFname(rset.getString("fname"));
				employee.setLname(rset.getString("lname"));
				employee.setJob_id(rset.getInt("job_id"));
				employee.setJob_lvl(rset.getInt("job_lvl"));
				employee.setHire_date(rset.getString("hire_date"));
				employee.setStatus(rset.getInt("status"));

				list.add(employee);
			}
			ConnectionManager.closeResultSet(rset);
			ConnectionManager.closeStatement(stmt);
			pageBean.setCurPage(pageNum);
			pageBean.data = list;
			return pageBean;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
	}

	// 获取总行数
	public int getAvailableCount() throws Exception {
		int ret = 0;
		conn = ConnectionManager.getConnection();
		Statement stmt = conn.createStatement();
		String strSql = "select * from employee";
		ResultSet rset = stmt.executeQuery(strSql);
		while (rset.next()) {
			ret++;
		}
		return ret;
	}

	// 初始化时对PageBean进行设置
	public void setPageBean() throws Exception {
		// 得到总行数
		this.setMaxRowCount(this.getAvailableCount());
		// 计算总页数
		if (this.maxRowCount % this.rowsPerPage == 0) { 
			this.maxPage = this.maxRowCount / this.rowsPerPage;
		} else {
			this.maxPage = this.maxRowCount / this.rowsPerPage + 1;
		}
	}

}
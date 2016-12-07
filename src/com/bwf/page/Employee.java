package com.bwf.page;

/** 雇员类 */
public class Employee {
	// id
	private String emp_id;
	// first name
	private String fname;
	// last name
	private String lname;
	// 工号
	private int job_id;
	// 级别
	private int job_lvl;
	// 入职时间年月日
	private String hire_date;
	// 状态，0为未正式员工，1为正式员工
	private int status;

	public String getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public int getJob_id() {
		return job_id;
	}

	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}

	public int getJob_lvl() {
		return job_lvl;
	}

	public void setJob_lvl(int job_lvl) {
		this.job_lvl = job_lvl;
	}

	public String getHire_date() {
		return hire_date;
	}

	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}

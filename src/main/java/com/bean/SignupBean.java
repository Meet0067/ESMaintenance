package com.bean;

public class SignupBean {
	
	private String fname,lname,mname,email,password,flate_no,type;
	//private int phone_no;
	private long  phone_no;
	
	public long getPhone_No() {		
		return phone_no;
	}

	public void setPhone_No(long phone_no) {
		this.phone_no = phone_no;
	}
	public double getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(long phone_no) {
		this.phone_no = phone_no;
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
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFlate_no() {
		return flate_no;
	}
	public void setFlate_no(String flate_no) {
		this.flate_no = flate_no;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}

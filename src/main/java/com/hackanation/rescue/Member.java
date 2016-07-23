package com.hackanation.rescue;


public class Member {
	
	private int userid;
	private String fullname;
	private String email;	
	private String password;
	private boolean isloggedin;
	private boolean isverified;
	private String contactnumber;
	

	public Member(int userid, String email, String password, 
			boolean isloggedin, boolean isverified, String contactnumber) {
		this.userid = userid;
		this.email = email;
		this.password = password;
		this.isloggedin = isloggedin;
		this.isverified = isverified;
		this.contactnumber = contactnumber;
	}
		
	public Member() {
		super();
	}


	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
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
	public boolean isIsloggedin() {
		return isloggedin;
	}
	public void setIsloggedin(boolean isloggedin) {
		this.isloggedin = isloggedin;
	}
	public String getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}
	public boolean isIsverified() {
		return isverified;
	}
	public void setIsverified(boolean isverified) {
		this.isverified = isverified;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
}

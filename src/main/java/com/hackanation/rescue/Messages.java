package com.hackanation.rescue;

public class Messages {
	
	private int messageid;
	private int userid;
	private String fullname;
	private String message;
	private double xcoord;
	private double ycoord;
	private int status;
	
	
	public Messages(int messageid, int userid, String message, 
			long xcoord, long ycoord, int status) {
		this.setMessageid(messageid);
		this.userid = userid;
		this.message = message;
		this.xcoord = xcoord;
		this.ycoord = ycoord;
		this.status = status;
	}
	
	public Messages() {
		super();
	}

	
	public int getMessageid() {
		return messageid;
	}
	public void setMessageid(int messageid) {
		this.messageid = messageid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public double getXcoord() {
		return xcoord;
	}
	public void setXcoord(double xcoord) {
		this.xcoord = xcoord;
	}
	public double getYcoord() {
		return ycoord;
	}
	public void setYcoord(double ycoord) {
		this.ycoord = ycoord;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
}

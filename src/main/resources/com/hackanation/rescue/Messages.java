package com.hackanation.rescue;

public class Messages {
	
	private int messageid;
	private int userid;
	private String message;
	private long xcoord;
	private long ycoord;
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
	public long getXcoord() {
		return xcoord;
	}
	public void setXcoord(long xcoord) {
		this.xcoord = xcoord;
	}
	public long getYcoord() {
		return ycoord;
	}
	public void setYcoord(long ycoord) {
		this.ycoord = ycoord;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}

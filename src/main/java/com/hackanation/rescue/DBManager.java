package com.hackanation.rescue;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hackanation.rescue.Database;
import com.hackanation.rescue.DBAccess;

public class DBManager {

	Database db;
	Connection con;
	DBAccess access;

	public DBManager() throws Exception {
		db = new Database();
		con = db.getConnection();
		access = new DBAccess();
	}

	public List<Member> getMembers() throws Exception {
		List<Member> memberList = new ArrayList<Member>();
		Database db = new Database();
		Connection con = db.getConnection();
		DBAccess access = new DBAccess();
		memberList = access.getMembers(con);
		return memberList;
	}

	public Member getMember(int id) throws Exception {
		return access.getMember(con, id);
	}

	public Member addMember(Member m) throws Exception {
		Member member = new Member();
		member = access.addMember(con, m);
		return member;
	}

	public void deleteMember(int id) throws Exception {
		access.deleteMember(con, id);
	}

	public Member updateMember(int userid, boolean isverified) throws Exception {
		Member member = new Member();
		member = access.getMember(con, userid);
		member.setIsverified(isverified);
		Connection con = db.getConnection();
		member = access.updateMember(con, member);
		return member;
	}

	public List<Messages> getMessages() throws Exception {
		List<Messages> messageList = new ArrayList<Messages>();
		Database db = new Database();
		Connection con = db.getConnection();
		DBAccess access = new DBAccess();
		messageList = access.getMessages(con);
		return messageList;
	}

	public Messages getMessage(int id) throws SQLException {
		return access.getMessage(con, id);
	}

	public Messages addMessage(Messages msg) throws SQLException {
		Messages message = new Messages();
		message = access.addMessage(con, msg);
		return message;
	}

	public void deleteMessage(int id) throws SQLException {
		access.deleteMessage(con, id);	
	}

	public Messages updateMessage(int messageid, int status) throws Exception {		
		Messages messages = new Messages();
		messages = access.getMessage(con, messageid);
		messages.setStatus(status);
		Connection con = db.getConnection();
		messages = access.updateMessage(con, messages);
		return messages;
	}
	
	public Member loginservice(String email, String pwd) throws SQLException {
		Member member = new Member();
		member = access.getMemberByEmail(con, email, pwd);
		return member;
	}
	
}

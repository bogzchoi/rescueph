package com.hackanation.rescue;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.PathParam;

import com.hackanation.rescue.Member;

public class MemberService {
			
	public List<Member> getAllMembers() { 
		List<Member> members = new ArrayList<Member>();
		try {
			members = new DBManager().getMembers();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return members; 
	} 
	
	public Member getMember(int id) { 
		Member member = new Member();
		try {
			member = new DBManager().getMember(id);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return member;
	} 
	
	public Member addMember(Member member) { 
		try {
			member = new DBManager().addMember(member);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return member; 
	} 
	
	public void deleteMember(int id) { 
		try {
			new DBManager().deleteMember(id);
		} catch(Exception e) {
			e.printStackTrace();
		} 
	} 
	
	public Member updateMember(int userid, boolean isverified) { 
		Member member = new Member();
		try {
			member = new DBManager().updateMember(userid, isverified);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return member; 
	} 
	
	public Member login(String email, String pwd) {
		Member member = new Member();
		try {
			member = new DBManager().loginservice(email, pwd);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return member;
	}
}

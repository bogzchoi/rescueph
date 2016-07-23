package com.hackanation.rescue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.hackanation.rescue.Member;

public class MemberService {
	
	static HashMap<Integer, Member> memberIdMap = getMemberIdMap();

	public List<Member> getAllMembers() { 
		List<Member> members = new ArrayList<Member>(memberIdMap.values()); 
		return members; 
	} 
	
	public Member getMember(int id) { 
		Member Member = memberIdMap.get(id); 
		return Member; 
	} 
	
	public Member addMember(Member member) { 
		member.setUserid(memberIdMap.size()+1); 
		memberIdMap.put(member.getUserid(), member); 
		return member; 
	} 
	
	public Member updateMember(Member member) { 
		if(member.getUserid() <= 0) return null; 
		memberIdMap.put(member.getUserid(), member); 
		return member; 
	} 
	
	public void deleteMember(int id) { 
		memberIdMap.remove(id); 
	} 
	
	public static HashMap<Integer, Member> getMemberIdMap() { 
		return memberIdMap; 
	}

}

package com.hackanation.rescue;

import java.util.List;

import javax.ws.rs.DELETE; 
import javax.ws.rs.GET; 
import javax.ws.rs.POST; 
import javax.ws.rs.PUT; 
import javax.ws.rs.Path; 
import javax.ws.rs.PathParam; 
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType;

@Path("/members")
public class MemberController {
	
	MemberService memberservice = new MemberService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	
	public List<Member> getMembers() { 
		List<Member> listOfMembers = memberservice.getAllMembers(); 
		return listOfMembers; 
	} 
	
	@GET 
	@Path("/{userid}") 
	@Produces(MediaType.APPLICATION_JSON) 
	public Member getMemberById(@PathParam("userid") int id) { 
		return memberservice.getMember(id); 
	} 
	
	@POST 
	@Produces(MediaType.APPLICATION_JSON) 
	public Member addMember(Member member) { 
		return memberservice.addMember(member); 
	} 
	
	@PUT 
	@Produces(MediaType.APPLICATION_JSON) 
	public Member updateMember(Member member) { 
		return memberservice.updateMember(member); 
	} 
	
	@DELETE 
	@Path("/{userid}") 
	@Produces(MediaType.APPLICATION_JSON) 
	public void deleteMember(@PathParam("userid") int id) { 
		memberservice.deleteMember(id); 
	} 
	

}

package com.hackanation.rescue;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE; 
import javax.ws.rs.GET; 
import javax.ws.rs.POST; 
import javax.ws.rs.Path; 
import javax.ws.rs.PathParam; 
import javax.ws.rs.Produces; 

@Path("/members")
public class MemberController {
	
	MemberService memberservice = new MemberService();
	
	@GET
	@Produces("application/json")
	public List<Member> getMembers() { 
		List<Member> listOfMembers = memberservice.getAllMembers(); 
		return listOfMembers; 
	} 
	
	@GET 
	@Path("/{userid}") 
    @Consumes("application/json")
	@Produces("application/json") 
	public Member getMemberById(@PathParam("userid") int id) { 
		return memberservice.getMember(id); 
	} 
	
	@POST
	@Path("/add")
    @Consumes("application/json")
	@Produces("application/json")
	public Member addMember(Member member) { 
		return memberservice.addMember(member); 
	}
	
	@DELETE 
	@Path("/delete/{userid}")
    @Consumes("application/json")
	public void deleteMember(@PathParam("userid") int id) { 
		memberservice.deleteMember(id); 
	} 
	
	@POST
	@Path("/update/{userid}/{isverified}")
    @Consumes("application/json")
	@Produces("application/json")
	public Member verifyMember(@PathParam("userid") int userid, @PathParam("isverified") boolean isverified) { 
		return memberservice.updateMember(userid, isverified); 
	}  
	
}

package com.hackanation.rescue;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/login")
public class LoginController {
	
	MemberService memberService = new MemberService();
	
	@GET
	@Path("/{email}/{password}")
	@Produces("application/json")
	public Member login(@PathParam("email") String email, @PathParam("password") String pwd) { 
		return memberService.login(email, pwd); 
	}
	
}

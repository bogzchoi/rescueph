package com.hackanation.rescue;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


@Path("messages")
public class MessagesController {
	
	MessageService msgService = new MessageService();
	
	@GET
	@Produces("application/json")
	public List<Messages> getAllMessages() { 
		List<Messages> listOfMsgs = msgService.getAllMessages(); 
		return listOfMsgs; 
	} 
	
	@GET 
	@Path("/{messageid}") 
    @Consumes("application/json")
	@Produces("application/json") 
	public Messages getMessageById(@PathParam("messageid") int id) { 
		return msgService.getMessage(id); 
	} 
	
	@POST
	@Path("/add")
    @Consumes("application/json")
	@Produces("application/json")
	public Messages addMessage(Messages msg) { 
		return msgService.addMessage(msg); 
	}
	
	@POST
	@Path("/update/{messageid}/{status}")
    @Consumes("application/json")
	@Produces("application/json")
	public Messages updateStatus(@PathParam("messageid") int messageid, @PathParam("status") int status) { 
		System.out.println("update " + messageid);
		return msgService.updateMessage(messageid, status); 
	}  
	
}

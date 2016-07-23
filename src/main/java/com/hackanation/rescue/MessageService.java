package com.hackanation.rescue;

import java.util.ArrayList;
import java.util.List;

public class MessageService {
	
	public List<Messages> getAllMessages() { 
		List<Messages> msgs = new ArrayList<Messages>();
		try {
			msgs = new DBManager().getMessages();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return msgs; 
	} 
	
	public Messages getMessage(int id) { 
		Messages msgs = new Messages();
		try {
			msgs = new DBManager().getMessage(id);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return msgs;
	} 
	
	public Messages addMessage(Messages msg) { 
		System.out.println("added message service");
		Messages msgs = new Messages();
		try {
			msgs = new DBManager().addMessage(msg);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return msgs; 
	} 
	
	public void deleteMessage(int id) { 
		try {
			new DBManager().deleteMessage(id);
		} catch(Exception e) {
			e.printStackTrace();
		} 
	} 
	
	public Messages updateMessage(int messageid, int status) { 
		Messages msg = new Messages();
		try {
			msg = new DBManager().updateMessage(messageid, status);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return msg; 
	}

}

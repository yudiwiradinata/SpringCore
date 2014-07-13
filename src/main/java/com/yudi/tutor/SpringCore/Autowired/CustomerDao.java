package com.yudi.tutor.SpringCore.Autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerDao {

	
	private String message;
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Hello Brooooo....!" + message;
	}
}

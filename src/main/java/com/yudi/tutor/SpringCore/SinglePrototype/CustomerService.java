package com.yudi.tutor.SpringCore.SinglePrototype;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


public class CustomerService {

	String message;
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}

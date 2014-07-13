package com.yudi.tutor.SpringCore.Autowired.common;

import org.springframework.stereotype.Component;

@Component
public class CustomerMase {

	
	public String message;
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
	public String printOut(){
		return message;
	}
	
}

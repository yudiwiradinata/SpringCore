package com.yudi.tutor.SpringCore.customer.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.yudi.tutor.SpringCore.Autowired.common.CustomerMase;

@Component("custe")
public class CustomerService {

	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	CustomerMase customer;
	
	private String name;
	private int type;
	private String address;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setType(int type) {
		this.type = type;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void printOutput() {
		// TODO Auto-generated method stub
		System.out.println(customer.getMessage() + "nah ini dia "+customerDao+" Name :"+name+" Adsress: "+address+" type :"+type);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "nah ini dia "+customerDao+" Name :"+name+" Adsress: "+address+" type :"+type;
	}
	
}

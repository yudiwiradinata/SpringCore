package com.yudi.tutor.SpringCore.customer.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yudi.tutor.SpringCore.Cons.Ambigu.Customer2;


public class Customer {

	int custId;
	String name;
	int age;

	
	public Customer(int custId, String name, int age) {	
		this.custId = custId;
		this.name = name;
		this.age = age;
	}

	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	public int getCustId() {
		return custId;
	}
	
	public void setCustId(int custId) {
		this.custId = custId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Id :"+custId+" Name :"+name+" Age :"+age;
	}
	

}

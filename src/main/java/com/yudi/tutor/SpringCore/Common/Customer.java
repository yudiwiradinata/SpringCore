package com.yudi.tutor.SpringCore.Common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yudi.tutor.SpringCore.Cons.Ambigu.Customer2;


public class Customer {

	private String action;
	private int type;
	private Customer2 customer2;

	
	public void setAction(String action) {
		this.action = action;
	}

	public String getAction() {
		return action;
	}
	
	
	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}

	@Autowired
	public void setCustomer2(Customer2 customer2) {
		this.customer2 = customer2;
	}

	public Customer2 getCustomer2() {
		return customer2;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Action :" + action + " \n type :" + type + " \n customer2 :"
				+ customer2;
	}

	public void initIt() throws Exception {
		System.out.println("Init method after properties are set : " + action);
	}

	public void cleanUp() throws Exception {
		System.out.println("Spring Container is destroy! Customer clean up");
	}

}

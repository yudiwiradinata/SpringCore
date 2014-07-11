package com.yudi.tutor.SpringCore.Cons.Ambigu;

public class Person {

	private Customer2 customer;
	
	public void setCustomer(Customer2 customer) {
		this.customer = customer;
	}
	
	public Customer2 getCustomer() {
		return customer;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "person :[ customer : "+customer+" ] ";
	}
}

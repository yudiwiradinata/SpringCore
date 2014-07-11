package com.yudi.tutor.SpringCore.Cons.Ambigu;

public class Customer {

	private String name;
	private String address;
	private int age;
	
	public Customer(String name, String address, int age) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.address = address;
		this.age = age;
	}
	
	public Customer(String name, int age, String address) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.age = age;
		this.address = address;		
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Name :"+name+" \n address :"+address+" \n age:"+age;
	}
	
	
	
	
}

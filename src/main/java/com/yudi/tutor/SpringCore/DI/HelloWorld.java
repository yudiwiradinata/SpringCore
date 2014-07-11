package com.yudi.tutor.SpringCore.DI;

public class HelloWorld {

	
	private String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void printHello() {
		// TODO Auto-generated method stub

		System.out.println("Hello Spring 3 "+name);
	}
}

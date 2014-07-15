package com.yudi.tutor.SpringCore.customer.dao;

import org.springframework.stereotype.Component;

import com.yudi.tutor.SpringCore.customer.model.Customer;


public interface CustomerDao {

	
	public int insert(Customer customer);
	
	public Customer findCustomerById(int custId);
	

}

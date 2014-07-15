package com.yudi.tutor.SpringCore.customer.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.yudi.tutor.SpringCore.customer.model.Customer;


public interface CustomerDao {

	
	public int insert(Customer customer);
	
	public Customer findCustomerById(int custId);
	
	public String findCustomerNameById(int id);

	public List<Customer> findAll();
	
	public Map<String, Object> find2ColumnById(int id);
	
	public List<Customer> findbyIdList(int id);
	
	public void insertBatch1(final List<Customer> customers);
	
	public void insertBatch2(final String sql);


}

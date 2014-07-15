package com.yudi.tutor.jdbc.spring;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mysql.fabric.xmlrpc.base.Array;
import com.yudi.tutor.SpringCore.customer.dao.impl.JdbcCustomerDao;
import com.yudi.tutor.SpringCore.customer.model.Customer;

public class testApp {

	ConfigurableApplicationContext context;
	JdbcCustomerDao jdbcCustomerDao ;

	@Before
	public void beforeBegin() {
		context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		jdbcCustomerDao = (JdbcCustomerDao) context
				.getBean("jdbcCustomerDao");
	}

	

	public void testInsertBatch1() {
		
		Customer customer1 = new Customer(8,"Wira8",29);
		Customer customer2 = new Customer(9,"Wira9",30);
		Customer customer3 = new Customer(10,"Wira10",31);
		
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(customer1);
		customers.add(customer2);
		customers.add(customer3);
		
		jdbcCustomerDao.insertBatch1(customers);
		System.out.println(" inserted rows: " + customers);

		System.out.println("Find All "+ jdbcCustomerDao.findAll());
		
		
		
	}
	
	@Test
	public void testInsertBatch2() {
		
		String sql = "UPDATE customer SET name ='Yudi Wira' ";
		
		jdbcCustomerDao.insertBatch2(sql);
		
		System.out.println("Find All "+ jdbcCustomerDao.findAll());
		
		
		
	}
	
	
	public void testFindbyIdList(){

		List<Customer>  customers = jdbcCustomerDao.findbyIdList(3);

		for(Customer c : customers){
			System.out.println("name "+c.getName()+" age "+c.getAge());
			
		}

	}
	
	
	public void testFindCustomerById() {
		

		Customer customer = jdbcCustomerDao.findCustomerById(1);

		System.out.println("Id " + customer.getCustId());
		System.out.println("Name " + customer.getName());
		System.out.println("Age " + customer.getAge());
	}

	
	public void testFind2ColumnById(){
		
		Map<String, Object> customers = jdbcCustomerDao.find2ColumnById(3);

		
			System.out.println("name "+customers.get("name")+" age "+customers.get("age"));
					
	}

	
	public void testFindCustomerAll() {
		

		List<Customer> customers = jdbcCustomerDao.findAll();

		for(Customer c : customers){
			System.out.println("name "+c.getName()+" age "+c.getAge());
			
		}

	}

	
	public void testFindCustomerNameById() {		

		Customer customer = new Customer();
		customer.setCustId(3);
		customer.setName("Yudio3");
		customer.setAge(14);

		String result = jdbcCustomerDao.findCustomerNameById(2);

		System.out.println(result);

	}
	
	
	public void testSelectJDBC() {
		JdbcCustomerDao jdbcCustomerDao = (JdbcCustomerDao) context
				.getBean("jdbcCustomerDao");

		Customer customer = jdbcCustomerDao.findCustomerById(1);

		System.out.println("Name " + customer.getName());
		System.out.println("Name " + customer.getAge());

	}

	
	
	public void testInsertJDBC() {
		JdbcCustomerDao jdbcCustomerDao = (JdbcCustomerDao) context
				.getBean("jdbcCustomerDao");

		Customer customer = new Customer();
		customer.setCustId(3);
		customer.setName("Yudio3");
		customer.setAge(14);

		int result = jdbcCustomerDao.insert(customer);

		Assert.assertEquals(1, result);

	}
}

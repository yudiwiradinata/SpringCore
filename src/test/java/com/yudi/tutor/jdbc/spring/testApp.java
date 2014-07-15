package com.yudi.tutor.jdbc.spring;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yudi.tutor.SpringCore.customer.dao.impl.JdbcCustomerDao;
import com.yudi.tutor.SpringCore.customer.model.Customer;

public class testApp {

	ConfigurableApplicationContext context;

	@Before
	public void beforeBegin() {
		context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
	}

	@Test
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
		customer.setCustId(2);
		customer.setName("Yudio2");
		customer.setAge(13);

		int result = jdbcCustomerDao.insert(customer);

		Assert.assertEquals(1, result);

	}
}

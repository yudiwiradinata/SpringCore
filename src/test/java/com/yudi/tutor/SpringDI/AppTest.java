package com.yudi.tutor.SpringDI;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yudi.tutor.SpringCore.Common.CustomerCollections;
import com.yudi.tutor.SpringCore.Cons.Ambigu.Customer;
import com.yudi.tutor.SpringCore.Cons.Ambigu.Person;
import com.yudi.tutor.SpringCore.LooselyCouple.OutputHelper;
import com.yudi.tutor.SpringCore.SinglePrototype.CustomerService;

/**
 * Unit test for simple App.
 */
public class AppTest {

	ApplicationContext context;
	@Before
	public void beforeBegin(){
		context = new ClassPathXmlApplicationContext("SpringBeans.xml");
	}
	
	@Test
	public void testCollection(){
		CustomerCollections customerCollections = (CustomerCollections) context.getBean("customerColl");
		System.out.println("Customer Collections :"+customerCollections);
		
		
	}
	
	public void testSingletonPrototype() {
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");

		CustomerService custA = (CustomerService) context.getBean("custService");
		custA.setMessage("tes broooo");
		System.out.println("message A :"+custA.getMessage());

		CustomerService custB = (CustomerService) context.getBean("custService");
		//custB.setMessage(" B tes broooo");
		System.out.println("message B :"+custB.getMessage());

	}

	public void testAmbiguCustomer() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"SpringBeans.xml");

		OutputHelper helper = (OutputHelper) context.getBean("OutputHelper");
		helper.generateOutput();

		Customer customer = (Customer) context.getBean("customer");
		System.out.println(customer);

		Assert.assertNotNull(customer);

		Person person = (Person) context.getBean("person2");
		System.out.println(person);

	}
}

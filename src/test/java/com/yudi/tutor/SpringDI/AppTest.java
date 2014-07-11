package com.yudi.tutor.SpringDI;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yudi.tutor.SpringCore.Cons.Ambigu.Customer;
import com.yudi.tutor.SpringCore.Cons.Ambigu.Person;
import com.yudi.tutor.SpringCore.LooselyCouple.OutputHelper;



/**
 * Unit test for simple App.
 */
public class AppTest {
   
    @Test
    public void testAmbiguCustomer(){
    	ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
    	
		OutputHelper helper = (OutputHelper) context.getBean("OutputHelper");
		helper.generateOutput();
		
    	Customer customer = (Customer) context.getBean("customer");
    	System.out.println(customer);
    	
    	Assert.assertNotNull(customer);
    	
    	Person person = (Person) context.getBean("person2");
    	System.out.println(person);
        
    }
}

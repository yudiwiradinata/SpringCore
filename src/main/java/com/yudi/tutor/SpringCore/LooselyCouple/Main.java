package com.yudi.tutor.SpringCore.LooselyCouple;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	
	public static void main(String[] args) {
		/*OutputHelper outputHelper = new OutputHelper();
		outputHelper.generateOutput();*/
		
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
		
		OutputHelper helper = (OutputHelper) context.getBean("OutputHelper");
		helper.generateOutput();
		
		/*
		OutputHelper helper2 = (OutputHelper) context.getBean("OutputHelperCons");
		helper2.generateOutput();
		*/
	}
}

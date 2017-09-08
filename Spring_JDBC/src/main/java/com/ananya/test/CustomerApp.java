package com.ananya.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ananya.dao.CustomerDAO;
import com.ananya.model.Customer;

public class CustomerApp {
	
	 public static void main( String[] args )
	    {
	    	ApplicationContext context =
	    		new ClassPathXmlApplicationContext("spring-module.xml");

	        CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
	        Customer customer = new Customer("ananya","batu",24,"bhubaneswar");
	        Customer customerOne = new Customer("sunanda","rana",23,"sonepur");
	        customerDAO.insert(customer);
	        customerDAO.insert(customerOne);

	        //System.out.println(customer1);

	    }

}

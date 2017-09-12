package com.ananya.test;

import java.util.List;
import java.util.Random;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ananya.dao.CustomerDAO;
import com.ananya.model.Customer;

public class CustomerApp {
	
	 public static void main( String[] args )
	    {
	    	ApplicationContext context = new ClassPathXmlApplicationContext("spring-module.xml");

	    	//get customer dao bean
	        CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
	        
	        //customer CRUD operations
	        Customer cust = new Customer();
	        int random = new Random().nextInt();
	        
	        cust.setCustomerId(random);
	        cust.setFirstName("C.S");
	        cust.setLastName("Lewis");
	        cust.setAddress("South Wales");
	        cust.setAge(45);
	        
	        //insert record
	        customerDAO.insertDetails(cust);
	        
	        //read record
	        Customer custOne = customerDAO.getDetailsById(random);
	        System.out.println("One record found: "+custOne);
	        
	        //update record
	        cust.setAddress("Wembley");
	        customerDAO.updateDetails(cust);
	        System.out.println("One record updated !");
	        
	        //get all records
	        List<Customer> custList = customerDAO.getAllDetails(); 
	        System.out.println("All records: "+"\n"+custList+"\n");
	        
	        //delete record
	        customerDAO.deleteByID(random);
	        System.out.println("One record deleted with id:"+random);

	    }

}

package com.ananya.dao;

import java.util.List;

import com.ananya.model.Customer;

public interface CustomerDAO {
		public void insertDetails(Customer customer);
		public Customer getDetailsById(int cust_id);
		public Customer updateDetails(Customer customer);
		public List<Customer> getAllDetails();
		public void deleteByID(int cust_id);
}

package com.ananya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.ananya.model.Customer;


public class CustomerDAOImpl implements CustomerDAO {
	private DataSource dataSource;
	Customer customer = null;
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insertDetails(Customer customer) {
		String sql = "INSERT INTO CUSTOMER " +
				"(customer_id,first_name,last_name, address,age) VALUES (?, ?, ?, ?, ?)";
		

		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1,customer.getCustomerId());
			ps.setString(2,customer.getFirstName());
			ps.setString(3,customer.getLastName());
			ps.setString(4,customer.getAddress());
			ps.setInt(5,customer.getAge());
			System.out.println("Record successfully inserted with id:"+customer.getCustomerId());
			
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}

	public Customer getDetailsById(int cust_id) {
		String sql = "SELECT * FROM CUSTOMER WHERE customer_id = ?";
		
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cust_id);
			rs = ps.executeQuery();
			while(rs.next()) {
				customer = new Customer();
				customer.setCustomerId(cust_id);
				customer.setFirstName(rs.getString("first_name"));
				customer.setLastName(rs.getString("last_name"));
				customer.setAddress(rs.getString("address"));
				customer.setAge(rs.getInt("age"));
			}
			//System.out.println("Record found with id:"+customer);
		} catch(Exception e) {
			System.out.println(e);
		}
		return customer;
	}

	public Customer updateDetails(Customer customer) {
		String sql = "UPDATE CUSTOMER SET address = ? WHERE customer_id = ?";
		
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, customer.getAddress());
			ps.setInt(2, customer.getCustomerId());
			ps.executeUpdate();
			
		} catch(Exception e) {
			System.out.println(e);
		}
		return customer;
	}

	public List<Customer> getAllDetails() {
		String sql = "SELECT * FROM CUSTOMER";
		List<Customer> customerList = new ArrayList<Customer>();
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Customer cust = new Customer();
				
				cust.setCustomerId(rs.getInt("customer_id"));
				cust.setFirstName(rs.getString("first_name"));
				cust.setLastName(rs.getString("last_name"));
				cust.setAddress(rs.getString("address"));
				cust.setAge(rs.getInt("age"));
				customerList.add(cust);
			}
		} catch(Exception e) {
			System.out.println(e);
		}
		return customerList;
	}

	public void deleteByID(int cust_id) {
		String sql = "DELETE FROM CUSTOMER WHERE customer_id = ?";
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cust_id);
			ps.executeUpdate();
		} catch(Exception e) {
			System.out.println(e);
		}
		
	}

}

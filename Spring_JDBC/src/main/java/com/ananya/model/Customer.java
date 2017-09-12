package com.ananya.model;

public class Customer {

	private String firstName;
	private String lastName;
	private int customerId;
	private String address;
	private int age;
	
	
	/*public Customer(String firstName, String lastName,int age, String address) {
		//this.customerId = int1;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.age = age;
		//System.out.println("Constructor of Customer.");
	}*/

	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString(){
		return "{ID="+customerId+",FirstName="+firstName+",LastName="+lastName+",Address="+address+",Age="+age+"}";
	}
}

package com.sportyshoes.serviceinterface;

import java.util.List;

import com.sportyshoes.model.Customer;


public interface CustomerService {
	public List<Customer> getCustomers();
	
	public Customer saveCustomer(Customer customer);
	
	public void deleteCustomerById(int Id);
	
	public Customer getCustomer(String emailId, String password);
	
	public List<Customer> getSignUpUsers();
		
	public List<Customer> searchUserByName(String userName);
	
}

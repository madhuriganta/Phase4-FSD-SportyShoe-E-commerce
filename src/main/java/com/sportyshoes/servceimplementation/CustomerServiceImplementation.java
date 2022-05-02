package com.sportyshoes.servceimplementation;

import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sportyshoes.dao.CustomerRepository;
import com.sportyshoes.model.Customer;
import com.sportyshoes.serviceinterface.CustomerService;

@Service
public class CustomerServiceImplementation implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
    EntityManager entityManager;

	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		
		return customerRepo.findAll();
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepo.save(customer);
		
	}

	@Override
	public void deleteCustomerById(int Id) {
		// TODO Auto-generated method stub
		customerRepo.deleteById(Id);
	}

	@Override
	public Customer getCustomer(String emailId, String password) {
		// TODO Auto-generated method stub
		return customerRepo.getCustomer(emailId, password);
	}

	@Override
	public List<Customer> getSignUpUsers() {
		// TODO Auto-generated method stub
		return customerRepo.getSignUpUsers();
	}
	
	@Override
	public List<Customer> searchUserByName(String userName) {
		// TODO Auto-generated method stub
		return customerRepo.searchByUserName(userName);
	}

}

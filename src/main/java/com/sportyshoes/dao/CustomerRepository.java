package com.sportyshoes.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sportyshoes.model.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{

	@Query("FROM Customer where emailId=emailId and password=password")
	public Customer getCustomer(String emailId, String password);
	
	@Query("SELECT c FROM Customer c WHERE c.isSignUp = true")
	public List<Customer> getSignUpUsers();
		
	@Query("SELECT c FROM Customer c WHERE c.name = :userName")
	public List<Customer> searchByUserName(@Param("userName") String userName);

}

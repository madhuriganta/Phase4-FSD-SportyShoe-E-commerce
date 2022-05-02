package com.sportyshoes.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.sportyshoes.model.Customer;
import com.sportyshoes.serviceinterface.CustomerService;


@RestController
@RequestMapping("/api")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/admin/customers")
	public ResponseEntity<List<Customer>> getCustomers(){

	    List<Customer> list = customerService.getCustomers();
	    return new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
	}
	
//	@PostMapping("/login")
//	public Customer getCustomer(@RequestParam(value="emailId") String emailId, @RequestParam(value="password") String password)  {
//
//	    return customerService.getCustomer(emailId, password);
//	}
	
    @PostMapping("/admin/signUp")
	public Customer signUpCustomer( @RequestBody Customer customer) {
		System.out.println("User added properly!");
		
		return customerService.saveCustomer(customer);
		
	}
   
    @GetMapping("admin/signUpUsers")
    public ResponseEntity<List<Customer>> getSignUpUsers()
    {
	    return new ResponseEntity<List<Customer>>(customerService.getSignUpUsers(), HttpStatus.OK);
    }
   
    @GetMapping("admin/searchByUserName")
    public ResponseEntity<List<Customer>> searchUserByName(@RequestParam(value="userName") String userName)
    {
	    return new ResponseEntity<List<Customer>>(customerService.searchUserByName(userName), HttpStatus.OK);
    }
}

package com.sportyshoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.model.Orders;
import com.sportyshoes.servceimplementation.OrderServiceImplementation;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class OrdersController {
	@Autowired
	private OrderServiceImplementation OrdersServiceImpl;
	private MultiValueMap<String, String> errorMap;
	
	@PostMapping("/saveOrder")
	public Orders saveOrder( @RequestBody Orders order) {
		System.out.println("Product save works properly!");
		
		return OrdersServiceImpl.saveOrder(order);
		
	}
	@GetMapping("/getOrderById/{id}")
	public ResponseEntity<Orders> getOrderById(@PathVariable int id){
		try {
			return new ResponseEntity<>(OrdersServiceImpl.getOrdersById(id),HttpStatus.OK);
		}catch(Exception ex)
		{
			errorMap=new LinkedMultiValueMap<>();
			errorMap.add("errorMessage:", ex.getMessage());
			return new ResponseEntity<>(null, errorMap, HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/getAllOrders")
	public List<Orders> findAllOrder(){
			return OrdersServiceImpl.getAllOrders();
	
	}
	@DeleteMapping("/orders/{id}")
	public ResponseEntity<String> deleteOrdersById(@PathVariable int id) {
		try {
			OrdersServiceImpl.deleteOrderById(id);
			return new ResponseEntity<>("Succesfully deleted Order with id: " + id, HttpStatus.OK);
		} catch (Exception ex) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage:", ex.getMessage());
			return new ResponseEntity<>(ex.getMessage(), errorMap, HttpStatus.BAD_REQUEST);
		}
	}
	@PutMapping("/updateOrder")
	public ResponseEntity<Orders> updateOrder(@RequestBody Orders order)
	{
		return new ResponseEntity<>(OrdersServiceImpl.updateOrders(order),HttpStatus.OK);
	}
	@GetMapping("/getOrdersByAsc")
	public List<Orders> findAllOrdersByOrderDate(){
		return OrdersServiceImpl.findAllOrdersByOrderDate();
	}

}

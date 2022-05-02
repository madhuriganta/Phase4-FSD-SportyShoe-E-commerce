package com.sportyshoes.servceimplementation;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.dao.OrdersRepository;
import com.sportyshoes.model.Orders;
import com.sportyshoes.serviceinterface.OrderServiceInterface;
@Service
public class OrderServiceImplementation implements OrderServiceInterface{
	@Autowired
	private OrdersRepository orderRepo;
	@Override
	public Orders saveOrder(Orders order) {
		// TODO Auto-generated method stub
		return orderRepo.save(order);
	}
	
	@Override
	public Orders getOrdersById(int id) throws Exception {
		// TODO Auto-generated method stub
		Orders order = null;
		try {
			if(id<=0) throw new Exception("Order Id can not be negative or zero");
			order = orderRepo.findById(id).get();
		}catch(NoSuchElementException e) {
			throw new Exception("Orders not found with Id: "+id);
		}
		return order;
	
	}

	@Override
	public Orders updateOrders(Orders order) {
		// TODO Auto-generated method stub
		return orderRepo.save(order);
	}

	@Override
	public void deleteOrderById(int id) {
		// TODO Auto-generated method stub
		orderRepo.deleteById(id);
	}

	@Override
	public List<Orders> getAllOrders() {
		// TODO Auto-generated method stub
		return orderRepo.findAll();
	}

	@Override
	public List<Orders> findAllOrdersByOrderDate() {
		// TODO Auto-generated method stub
		return orderRepo.findAllOrdersByOrderDate();
	}
	

}

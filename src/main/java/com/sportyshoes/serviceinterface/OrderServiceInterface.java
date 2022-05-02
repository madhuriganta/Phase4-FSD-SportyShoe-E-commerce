package com.sportyshoes.serviceinterface;

import java.util.List;

import com.sportyshoes.model.Orders;

public interface OrderServiceInterface {
	
	public Orders saveOrder(Orders order);
	
	public Orders getOrdersById(int id) throws Exception;
	
	public Orders updateOrders(Orders order);
	
	public void deleteOrderById(int id);
	
	public List<Orders> getAllOrders();

	public List<Orders> findAllOrdersByOrderDate();

}

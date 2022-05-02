package com.sportyshoes.dao;

//import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sportyshoes.model.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer>{
	@Query("FROM Orders ORDER BY orderDate ASC")
	public List<Orders> findAllOrdersByOrderDate();

}

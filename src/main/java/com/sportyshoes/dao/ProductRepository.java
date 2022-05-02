package com.sportyshoes.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sportyshoes.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

	
	 @Query("FROM Product ORDER BY productCode ASC")
		public List<Product> findAllProductsByProductCode();
}

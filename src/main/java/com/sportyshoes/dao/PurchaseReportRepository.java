package com.sportyshoes.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sportyshoes.model.PurchaseReport;

@Repository
public interface PurchaseReportRepository extends JpaRepository<PurchaseReport, Integer>{
	@Query("FROM PurchaseReport ORDER BY dateOfPurchase ASC")
	public List<PurchaseReport> findAllPurchaseReportByDateOfPurchase();
	
	public List<PurchaseReport> findByCategory(String category);
}

package com.sportyshoes.serviceinterface;

import java.util.List;
import com.sportyshoes.model.Product;
import com.sportyshoes.model.PurchaseReport;

public interface ProductServiceInterface {
	
    public Product saveProduct(Product product);
	
	public Product updateProduct(Product product);
	
	public void deleteProductById(int id);
	
	public Product getProductById(int id);
	
	public List<Product> findAllProducts();
	
	public List<Product> findAllProductsByProductCode();
	
	
    public PurchaseReport savePurchaseReport(PurchaseReport pr);
	
	public PurchaseReport updatePurchaseReport(PurchaseReport pr);
	
	public void deletePurchaseReportById(int id);
	
	public List<PurchaseReport> getAllPurchaseReportsByCategory(String category);
	
	public List<PurchaseReport> findAllPurchaseReportByDateOfPurchase();
	
	public List<PurchaseReport> getAllPurchaseReports();
	
	

}

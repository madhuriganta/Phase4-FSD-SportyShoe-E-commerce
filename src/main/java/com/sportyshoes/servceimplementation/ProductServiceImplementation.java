package com.sportyshoes.servceimplementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sportyshoes.dao.ProductRepository;
import com.sportyshoes.dao.PurchaseReportRepository;
import com.sportyshoes.model.Product;
import com.sportyshoes.model.PurchaseReport;
import com.sportyshoes.serviceinterface.ProductServiceInterface;

@Service
public class ProductServiceImplementation implements ProductServiceInterface {

	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private PurchaseReportRepository prRepo;
		
	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepo.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepo.save(product);
	}

	@Override
	public List<Product> findAllProducts() {
		// TODO Auto-generated method stub
		return (List<Product>) productRepo.findAll();
	}

	@Override
	public void deleteProductById(int id) {
		// TODO Auto-generated method stub
		productRepo.deleteById(id);
		
	}

	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		Product product=null;
		try {
			if(id<=0)
				System.out.println("Product Id can not be negative or zero");
			product= productRepo.findById(id).get();
		}catch(Exception ex) {
			System.out.println(ex);
		}
		return product;
	}

	@Override
	public List<Product> findAllProductsByProductCode() {
		// TODO Auto-generated method stub
		return productRepo.findAllProductsByProductCode();
		
	}

	@Override
	public PurchaseReport savePurchaseReport(PurchaseReport pr) {
		// TODO Auto-generated method stub
		return prRepo.save(pr);
	}

	@Override
	public PurchaseReport updatePurchaseReport(PurchaseReport pr) {
		// TODO Auto-generated method stub
		return prRepo.save(pr);
	}

	@Override
	public void deletePurchaseReportById(int id) {
		// TODO Auto-generated method stub
		prRepo.deleteById(id);
	}

	
	@Override
	public List<PurchaseReport> getAllPurchaseReportsByCategory(String category) {
		// TODO Auto-generated method stub
		return prRepo.findByCategory(category);
	}

	@Override
	public List<PurchaseReport> findAllPurchaseReportByDateOfPurchase() {
		// TODO Auto-generated method stub
		return prRepo.findAllPurchaseReportByDateOfPurchase();
	}
	@Override
	public List<PurchaseReport> getAllPurchaseReports() {
		// TODO Auto-generated method stub
		return (List<PurchaseReport>) prRepo.findAll();
	}
}

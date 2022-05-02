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


import com.sportyshoes.model.Product;
import com.sportyshoes.model.PurchaseReport;
import com.sportyshoes.servceimplementation.ProductServiceImplementation;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ProductController {
	@Autowired
	private ProductServiceImplementation productServiceImpl;
	
	private MultiValueMap<String, String> errorMap;
	 
	
	@PostMapping("/admin/saveProduct")
	public Product saveProduct( @RequestBody Product product) {
		System.out.println("Product save works properly!");
		
		return productServiceImpl.saveProduct(product);
		
	}
	@PutMapping("/admin/updateProduct")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product)
	{
		return new ResponseEntity<>(productServiceImpl.updateProduct(product),HttpStatus.OK);
	}
	@GetMapping("/admin/getAllProducts")
	public ResponseEntity<List<Product>> getAllProducts(){
		return new ResponseEntity<List<Product>>(productServiceImpl.findAllProducts(), HttpStatus.OK);
	}
	

	@DeleteMapping("/admin/product/{id}")
	public ResponseEntity<String> deleteProductById(@PathVariable int id) {
		try {
			productServiceImpl.deleteProductById(id);
			return new ResponseEntity<>("Succesfully deleted product with id: " + id, HttpStatus.OK);
		} catch (Exception ex) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage:", ex.getMessage());
			return new ResponseEntity<>(ex.getMessage(), errorMap, HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	@GetMapping("/admin/getProductById/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id){
		try {
			return new ResponseEntity<>(productServiceImpl.getProductById(id),HttpStatus.OK);
		}catch(Exception ex)
		{
			errorMap=new LinkedMultiValueMap<>();
			errorMap.add("errorMessage:", ex.getMessage());
			return new ResponseEntity<>(null, errorMap, HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/admin/getProductsByAsc")
	public List<Product> findAllProductsByProductCode(){
		return productServiceImpl.findAllProductsByProductCode();
	}
	
	
	
	@PostMapping("/admin/savePurchaseReport")
	public PurchaseReport savePurchaseReport( @RequestBody PurchaseReport pr) {
		System.out.println("PurchaseReport save works properly!");
		
		return productServiceImpl.savePurchaseReport(pr);
		
	}
	@DeleteMapping("/admin/purchaseReport")
	public ResponseEntity<String> deletePurchaseReportById(@PathVariable int id) {
		try {
			productServiceImpl.deletePurchaseReportById(id);
			return new ResponseEntity<>("Succesfully deleted PurchaseReport with id: " + id, HttpStatus.OK);
		} catch (Exception ex) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage:", ex.getMessage());
			return new ResponseEntity<>(ex.getMessage(), errorMap, HttpStatus.BAD_REQUEST);
		}
	}
	@PutMapping("/admin/updatePurchaseReport")
	public ResponseEntity<PurchaseReport> updatePurchaseReport(@RequestBody PurchaseReport pr)
	{
		return new ResponseEntity<>(productServiceImpl.updatePurchaseReport(pr),HttpStatus.OK);
	}
	
	@GetMapping("/admin/getAllPurchaseReport")
	public ResponseEntity<List<PurchaseReport>> getAllPurchaseReport(){
		return new ResponseEntity<List<PurchaseReport>>(productServiceImpl.getAllPurchaseReports(), HttpStatus.OK);
	}
	

	@GetMapping("/admin/purchaseReport/category/{category}")
	public ResponseEntity<List<PurchaseReport>> getAllPurchaseReportsByCategory(@PathVariable String category){
		return new ResponseEntity<List<PurchaseReport>>(productServiceImpl.getAllPurchaseReportsByCategory(category), HttpStatus.OK);
	}
	@GetMapping("/admin/purchaseReport/dateOfPurchase")
	public List<PurchaseReport> findAllPurchaseReportByDateOfPurchase(){
		return productServiceImpl.findAllPurchaseReportByDateOfPurchase();
	}
	
	
}

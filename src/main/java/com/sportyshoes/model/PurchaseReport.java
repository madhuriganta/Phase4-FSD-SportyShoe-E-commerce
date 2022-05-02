package com.sportyshoes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Table(name="purchaseReport_table", catalog="product_db")
public class PurchaseReport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String purchaseBy;
	private String category;
	@JsonFormat(pattern = "yyyy/MM/dd", shape=Shape.STRING)
	@Column(name="dateOfPurchase")
	private String dateOfPurchase;
	private String orderList;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPurchaseBy() {
		return purchaseBy;
	}
	public void setPurchaseBy(String purchaseBy) {
		this.purchaseBy = purchaseBy;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDateOfPurchase() {
		return dateOfPurchase;
	}
	public void setDateoOfPurchase(String dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}
	public String getOrderList() {
		return orderList;
	}
	public void setOrderList(String orderList) {
		this.orderList = orderList;
	}
	
	public PurchaseReport(int id, String purchaseBy, String category, String dateOfPurchase, String orderList) {
		super();
		this.id = id;
		this.purchaseBy = purchaseBy;
		this.category = category;
		this.dateOfPurchase = dateOfPurchase;
		this.orderList = orderList;
	}
	public PurchaseReport() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}

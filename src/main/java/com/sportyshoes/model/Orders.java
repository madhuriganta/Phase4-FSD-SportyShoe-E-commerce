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
@Table(name="order_table", catalog="product_db")      
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int orderNumber;
	@JsonFormat(pattern = "yyyy/MM/dd", shape=Shape.STRING)
	@Column(name="order_Date")
	private String orderDate;
	@JsonFormat(pattern = "yyyy/MM/dd", shape=Shape.STRING)
	@Column(name="required_Date")
	private String requiredDate;
	@JsonFormat(pattern = "yyyy/MM/dd", shape=Shape.STRING)
	@Column(name="shipped_Date")
	private String shippedDate;
	private int customerNumber;
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Orders(int id, int orderNumber, String orderDate, String requiredDate, String shippedDate, int customerNumber) {
		super();
		this.id = id;
		this.orderNumber = orderNumber;
		this.orderDate = orderDate;
		this.requiredDate = requiredDate;
		this.shippedDate = shippedDate;
		this.customerNumber = customerNumber;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getRequiredDate() {
		return requiredDate;
	}
	public void setRequiredDate(String requiredDate) {
		this.requiredDate = requiredDate;
	}
	public String getShippedDate() {
		return shippedDate;
	}
	public void setShippedDate(String shippedDate) {
		this.shippedDate = shippedDate;
	}
	public int getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}
	
	
	
}

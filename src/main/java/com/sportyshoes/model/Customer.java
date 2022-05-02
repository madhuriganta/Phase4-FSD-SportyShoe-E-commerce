package com.sportyshoes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer_table", catalog="product_db" )
public class Customer {
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="name")
	private String name;

	@Column(name="email_id")
	private String emailId;
	
	@Column(name="password")
	private String password;

	@Column(name="user_type")
	private String userType;
	
	@Column(name="user_signup")
	private Boolean isSignUp;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Boolean isSignUp() {
		return isSignUp;
	}

	public void setSignUp(Boolean isSignUp) {
		this.isSignUp = isSignUp;
	}

	public Customer(int id, String name, String emailId, String password, String userType, Boolean isSignUp) {
		super();
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.password = password;
		this.userType = userType;
		this.isSignUp = isSignUp;
	}

	

}

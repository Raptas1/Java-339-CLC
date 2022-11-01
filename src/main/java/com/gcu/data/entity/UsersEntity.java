package com.gcu.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("USERS")
public class UsersEntity {
	
	@Id
	Long id;
	
	@Column("USERNAME")
	String username;
	
	@Column("PASSWORD")
	String password;
	
	@Column("FIRST_NAME")
	String firstName;
	
	@Column("LAST_NAME")
	String lastName;
	
	@Column("EMAIL")
	String email;
	
	@Column("ADDRESS")
	String address;
	
	@Column("CITY")
	String city;
	
	@Column("STATE")
	String state;
	
	@Column("ZIPCODE")
	String zipCode;
	
	@Column("PHONE_NUMBER")
	String phoneNumber;
	
	@Column("TOTAL_NUM_LISTINGS")
	int totalNumListings;
	
	@Column("TOTAL_NUM_SALES")
	int totalNumSales;
	
	@Column("TOTAL_REVENUE")
	int totalRevenue;
	
	
	public UsersEntity(Long id, String username, String password, String firstName, String lastName, String email, String address, String city,
			String state, String zipCode, String phoneNumber, int totalNumListings, int totalNumSales,
			int totalRevenue) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.phoneNumber = phoneNumber;
		this.totalNumListings = totalNumListings;
		this.totalNumSales = totalNumSales;
		this.totalRevenue = totalRevenue;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getTotalNumListings() {
		return totalNumListings;
	}

	public void setTotalNumListings(int totalNumListings) {
		this.totalNumListings = totalNumListings;
	}

	public int getTotalNumSales() {
		return totalNumSales;
	}

	public void setTotalNumSales(int totalNumSales) {
		this.totalNumSales = totalNumSales;
	}

	public int getTotalRevenue() {
		return totalRevenue;
	}

	public void setTotalRevenue(int totalRevenue) {
		this.totalRevenue = totalRevenue;
	}
	
	
	
	
	

}

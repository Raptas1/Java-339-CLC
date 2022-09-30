package com.gcu.model;

import java.util.ArrayList;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
public class UserModel {
	
	//Imports
	private ListingModel listing;
	private ArrayList<ListingModel> allListings = new ArrayList<ListingModel>();
	
	//User Sensitive Information
	@NotNull(message="This field is required")
	private String firstName;
	
	@NotNull(message="This field is required")
	private String lastName;
	
	@NotNull(message="This field is required")
	private String username;
	
	@NotNull(message="This field is required")
	private String email;
	
	@NotNull(message="This field is required")
	private String password;
	
	private int totalNumListings;
	private int totalNumSales;
	private int totalRevenue;
	
	public UserModel() {
		
	}

	public UserModel(String firstName, String lastName, String username, String password, String email ) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		
		this.totalNumListings = 0;
		this.totalNumSales = 0;
	}
	
	public ListingModel getListing() {
		//remove this
		allListings.size();
		return listing;
	}
	public void setListing(ListingModel listing) {
		this.listing = listing;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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

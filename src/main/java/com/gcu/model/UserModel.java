package com.gcu.model;

import java.util.ArrayList;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class UserModel {
	
	//Imports
	private ListingModel listing;
	@Valid public CredentialModel credentials;

	private ArrayList<ListingModel> allListings = new ArrayList<ListingModel>();
	
	//User Sensitive Information
	@NotEmpty(message="This field is required")
	private String firstName;
	
	@NotEmpty(message="This field is required")
	private String lastName;
	
	@NotEmpty(message="This field is required")
	@Email
	private String email;
	
	@NotEmpty(message="This field is required")
	private String address;
	
	@NotEmpty(message="This field is required")
	private String city;
	
	@NotEmpty(message="This field is required")
	private String state;
	
	@Size(max=99999, min=1, message="Enter a valid Zipcode")
	private String zipcode;
	
	@Size(min=1, message="Enter a valid Phone Number")
	private String phoneNumber;
	
	
	private int totalNumListings;
	private int totalNumSales;
	private int totalRevenue;
	
	public UserModel() {
		credentials = new CredentialModel();
	}

	public UserModel(String firstName, String lastName,String email ) {
		credentials = new CredentialModel();
		
		this.firstName = firstName;
		this.lastName = lastName;
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
	
	public String getZipcode() {
		return zipcode;
	}
	
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
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
	
	public CredentialModel getCredentials() {
		return credentials;
	}

	public void setCredentials(CredentialModel credentials) {
		this.credentials = credentials;
	}

	
	
}

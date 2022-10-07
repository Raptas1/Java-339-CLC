package com.gcu.model;

import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class CredentialModel {
	
	@Size(min=1, max=32, message="Username must be between 1-32 characters")
	private String username;
	
	@Size(min=6, max=32, message="Password must be between 6-32 characters")
	private String password;
	
	public CredentialModel() {
		username = null;
		password = null;
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
	

}

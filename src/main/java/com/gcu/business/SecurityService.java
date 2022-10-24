package com.gcu.business;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.gcu.model.UserModel;

@Service
public class SecurityService {
	
	//LoginController
	public boolean authenticate(String username, String password) {

		if(username.equals("admin") && password.equals("password")) {
			return true;
		}
		return false;
	}
	
	public boolean verify(UserModel userModel, BindingResult bindingResult) {
		if(userModel.credentials.getUsername().equals("admin")) {
			bindingResult.rejectValue("credentials.username", "error.username", "Username already exists");
		}
		
		if(userModel.getEmail().equals("igudino2002@gmail.com")) {
			bindingResult.rejectValue("email", "error.email", "Email already exists");
		}
		
		return true;
	}

}

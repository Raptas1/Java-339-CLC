package com.gcu.business;

import java.util.List;

import org.springframework.validation.BindingResult;

import com.gcu.model.UserModel;


public interface UsersBusinessServiceInterface {
	
	public List<UserModel> createUser(UserModel userModel);
	public boolean verifyUser(UserModel userModel, BindingResult bindingResult);

}

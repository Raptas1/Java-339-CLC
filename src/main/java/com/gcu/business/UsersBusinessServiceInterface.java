package com.gcu.business;

import com.gcu.model.UserModel;


public interface UsersBusinessServiceInterface {
	
	public int createUser(UserModel userModel);
	public int verifyUsername(UserModel userModel);
	public int verifyEmail(UserModel userModel);

}

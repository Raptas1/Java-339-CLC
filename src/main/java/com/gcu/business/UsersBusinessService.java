package com.gcu.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.UsersDataService;
import com.gcu.data.entity.UsersEntity;
import com.gcu.model.UserModel;

@Service
public class UsersBusinessService implements UsersBusinessServiceInterface {

	@Autowired
	UsersDataService usersDataService;
	
	@Override
	/**
	 * This method creates a user Entity from a user model to add to the database
	 */
	public int createUser(UserModel userModel) {
		
		UsersEntity usersEntity = new UsersEntity(userModel.getId(),
									userModel.credentials.getUsername(),
									userModel.credentials.getPassword(),
									userModel.getFirstName(), 
									userModel.getLastName(), 
									userModel.getEmail(), 
									userModel.getAddress(), 
									userModel.getCity(), 
									userModel.getState(), 
									userModel.getZipcode(), 
									userModel.getPhoneNumber(),
									userModel.getTotalNumListings(),
									userModel.getTotalNumSales(),
									userModel.getTotalRevenue());
		usersDataService.create(usersEntity);
		return 0;
	}

	@Override
	/**
	 * This method verifies the username to see if it exists
	 */
	public int verifyUsername(UserModel userModel) {
		if(usersDataService.findByUsername(userModel.credentials.getUsername()) == null) {
			return 0;
		}
		return 1;
	}
	
	@Override
	/**
	 * This method verifies the email to see if it exists
	 */
	public int verifyEmail(UserModel userModel) {
		if(usersDataService.findByEmail(userModel.getEmail()) == null) {
			return 0;
		}
		return 1;
	}
	

}

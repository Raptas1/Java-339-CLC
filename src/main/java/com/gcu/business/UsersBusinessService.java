package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.gcu.data.UsersDataService;
import com.gcu.data.entity.UsersEntity;
import com.gcu.model.UserModel;

@Service
public class UsersBusinessService implements UsersBusinessServiceInterface {

	@Autowired
	UsersDataService usersDataService;
	
	@Override
	public List<UserModel> createUser(UserModel userModel) {
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
		return null;
	}

	@Override
	public boolean verifyUser(UserModel userModel, BindingResult bindingResult) {
		if(usersDataService.findByUsername(userModel.credentials.getUsername()) == null) {
			return true;
		}
		bindingResult.rejectValue("credentials.username", "error.username", "Username already exists");
		return false;
	}

}

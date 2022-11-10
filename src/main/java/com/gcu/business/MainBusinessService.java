package com.gcu.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.UsersDataService;
import com.gcu.data.entity.UsersEntity;
import com.gcu.model.UserModel;

@Service
public class MainBusinessService implements MainBusinessServiceInterface {
	
	@Autowired
	UsersDataService usersDataService;
	
	@Autowired
	UserModel userModel;

	@Override
	public UserModel findUser(String username) {
		UsersEntity usersEntity = usersDataService.findByUsername(username);
		userModel.setId(usersEntity.getId());
		userModel.credentials.setUsername(usersEntity.getUsername());
		userModel.credentials.setPassword(usersEntity.getPassword());
		userModel.setFirstName(usersEntity.getFirstName());
		userModel.setLastName(usersEntity.getLastName());
		userModel.setEmail(usersEntity.getEmail());
		userModel.setAddress(usersEntity.getAddress());
		userModel.setCity(usersEntity.getCity());
		userModel.setState(usersEntity.getState());
		userModel.setZipcode(usersEntity.getZipcode());
		userModel.setPhoneNumber(usersEntity.getPhoneNumber());
		userModel.setTotalNumListings(usersEntity.getTotalNumListings());
		userModel.setTotalNumSales(usersEntity.getTotalNumSales());
		userModel.setTotalRevenue(usersEntity.getTotalRevenue());
		
		return userModel;
	}

}

package com.gcu.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.UsersDataService;
import com.gcu.data.entity.UsersEntity;
import com.gcu.model.UserModel;

@Service
public class SecurityService implements SecurityServiceInterface {
	
	@Autowired
	UsersDataService usersDataService;
	
	@Autowired
	UserModel userModel;

	@Override
	/**
	 * This method checks if the username equals to the password of that username.
	 */
	public int authenticateUser(UserModel userModel) {
		UsersEntity usersEntity;
		if(usersDataService.findByUsername(userModel.credentials.getUsername()) == null) {
			return 1;
		} else {
			usersEntity = usersDataService.findByUsername(userModel.credentials.getUsername());
			if(userModel.credentials.getPassword().equals(usersEntity.getPassword())) {
				this.userModel.credentials.setUsername(usersEntity.getUsername());
				return 0;
			} else {
				return 1;
			}
		}
	}


}

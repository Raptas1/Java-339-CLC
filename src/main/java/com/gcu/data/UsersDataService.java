package com.gcu.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.UsersEntity;
import com.gcu.data.repository.UsersRepository;

@Service
public class UsersDataService implements DataAccessInterface<UsersEntity> {

	@Autowired
	private UsersRepository usersRepository;
	
	public UsersDataService(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	@Override
	public List<UsersEntity> findAll() {
		return null;
	}

	@Override
	public boolean create(UsersEntity user) {
		try {
			this.usersRepository.save(user);
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(UsersEntity user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(UsersEntity user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UsersEntity findByUsername(String username) {
		UsersEntity usersEntity = usersRepository.findByUsername(username);
		return usersEntity;
	}

	@Override
	public UsersEntity findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}

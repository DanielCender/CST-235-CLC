package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.UserDataInterface;
import com.gcu.models.RegisterUserModel;
import com.gcu.models.UserModel;

public class UserBusinessService implements UserBusinessInterface {
	@Autowired
	UserDataInterface service;
	
	public void setUserDataInterface(UserDataInterface service) {
		this.service = service;
	}
	
	@Override
	public List<UserModel> getAll() {
		return service.findAll();
	}

	@Override
	public UserModel findById(int id) {
		return service.findByID(id);
	}

	@Override
	public boolean create(UserModel user) {
		return service.create(user);
	}

	@Override
	public boolean Login(String email, String password) {
		return service.Login(email, password);
	}

	@Override
	public boolean Register(RegisterUserModel registration) {
		return service.Register(registration);
	}

	@Override
	public boolean isAvailable(RegisterUserModel registration) {
		return service.isAvailable(registration);
	}

	@Override
	public boolean update(UserModel t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}
}

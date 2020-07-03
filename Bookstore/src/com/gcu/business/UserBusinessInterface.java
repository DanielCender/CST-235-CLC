package com.gcu.business;

import java.util.List;

import com.gcu.models.RegisterUserModel;
import com.gcu.models.UserModel;

public interface UserBusinessInterface extends DataBusinessInterface<UserModel> {
	public List<UserModel> getAll();
	public UserModel findById(int id);
	public boolean create(UserModel user);
	public boolean Register(RegisterUserModel registration);
	public boolean Login(String email, String password);
	public boolean isAvailable(RegisterUserModel registration);
}

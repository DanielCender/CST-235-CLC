package com.gcu.data;

import java.util.List;

import com.gcu.models.RegisterUserModel;
import com.gcu.models.UserModel;

public interface UserDataInterface extends DataInterface<UserModel> {
	public boolean create(UserModel y);
	public boolean update(UserModel y);
	public boolean delete(int id);
	public UserModel findByID(int ID);
	public List<UserModel> findAll();
	public boolean Register(RegisterUserModel registration);
	public boolean Login(String email, String password);
	public boolean isAvailable(RegisterUserModel registration);
}

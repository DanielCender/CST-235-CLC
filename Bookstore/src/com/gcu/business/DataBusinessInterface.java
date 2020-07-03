package com.gcu.business;

import java.util.List;

//import com.gcu.models.UserModel;

public interface DataBusinessInterface<T> {
	public List<T> getAll();	
	public T findById(int id);
	public boolean create(T t);
	public boolean update(T t);
	public boolean delete(int id);
}

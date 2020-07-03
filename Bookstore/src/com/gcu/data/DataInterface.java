package com.gcu.data;

import java.util.List;

public interface DataInterface<T> {
	public boolean create(T t);
	public boolean update(T t);
	public boolean delete(int id);
	public T findByID(int ID);
	public List<T> findAll();
}

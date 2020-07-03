package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.DataInterface;
import com.gcu.models.BookModel;

public class BookBusinessService implements DataBusinessInterface<BookModel> {
	@Autowired
	DataInterface<BookModel> service;
	
	public void setDataInterface(DataInterface<BookModel> service) {
		this.service = service;
	}

	@Override
	public List<BookModel> getAll() {
		return service.findAll();
	}

	@Override
	public BookModel findById(int id) {
		return service.findByID(id);
	}

	@Override
	public boolean create(BookModel t) {
		return service.create(t);
	}
	
	@Override
	public boolean update(BookModel t) {
		// TODO Auto-generated method stub
		return service.update(t);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return service.delete(id);
	}
	
}

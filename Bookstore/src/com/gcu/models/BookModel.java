package com.gcu.models;

import javax.validation.constraints.NotNull;

public class BookModel {
	
	//Basic variables for books along with an identification number
	@NotNull
	private String author;
	
	@NotNull
	private String title;
	
	@NotNull
	private String ISBN;
	
	@NotNull
	private String publisher;
	
	@NotNull
	private int appId;
	
	public BookModel() {
		// Empty initializer
	}
	
	public BookModel(String author, String title, String ISBN, String publisher) {
		super();
		this.author = author;
		this.title = title;
		this.ISBN = ISBN;
		this.publisher = publisher;
	}
	
	//Getter and setter's for the variables.

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}
	
	
	
	
}

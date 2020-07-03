package com.gcu.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginCModel {
	
	@NotNull @Size(min=4,max=200,message="Email must be between 4 and 200 chars")
	private String email;
	
	@NotNull @Size(min=6,max=20,message="Password must be between 6 and 20 chars")
	private String password;

	public LoginCModel(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public LoginCModel() {
		// stub
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

package com.gcu.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegisterUserModel extends UserModel {
	@NotNull @Size(min=6,max=200,message="Password confirmation must be between 6 and 200 chars")
	private String passwordConfirmation;
	
	public RegisterUserModel() {
		super();
	}

	public RegisterUserModel(@NotNull(message = "First Name is required") String firstName,
			@NotNull(message = "Middle Initial is required") String middleInitial,
			@NotNull(message = "Last Name is required") String lastName,
			@NotNull(message = "Username is required") String username,
			@NotNull(message = "Password is required") String password,
			@Email @NotNull(message = "Email is required") String email,
			@NotNull(message="Password Confirmation is needed") String passwordConfirmation) {
		super(firstName, middleInitial, lastName, username, password, email);
		this.passwordConfirmation = passwordConfirmation;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}


}

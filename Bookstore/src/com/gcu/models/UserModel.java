package com.gcu.models;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserModel {

	@NotNull(message="First Name is required") @Size(min=1,max=200,message="First Name should be between 1 and 200 characters")
	private String firstName;
	
	@NotNull(message="Middle Initial is required") @Size(min=1,max=2,message="Middle Initial should be 1 or 2 characters")
	private String middleInitial;
	
	@NotNull(message="Last Name is required") @Size(min=1,max=200,message="Last Name should be between 1 and 200 characters")
	private String lastName;	
	
	@NotNull(message="Username is required") @Size(min=3,max=20,message="Username should be between 3 and 20 characters")
	private String username;
	
	@NotNull(message="Password is required") @Size(min=6,max=200,message="Password should be between 6 and 200 characters")
	private String password;
	
	@NotNull(message="Email is required") @Size(min=4,max=200,message="Password should be between 4 and 200 characters")
	private String email;
	
	/*getters and setters*/
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	public String getMiddleInitial() {
		return middleInitial;
	}
	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}
	
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	/*constructor with params*/
	public UserModel(@NotNull(message = "First Name is required") String firstName,
			@NotNull(message = "Middle Initial is required") String middleInitial,
			@NotNull(message = "Last Name is required") String lastName,
			@NotNull(message = "Username is required") String username,
			@NotNull(message = "Password is required") String password,
			@NotNull(message = "Email is required") String email) {
		super();
		this.firstName = firstName;
		this.middleInitial = middleInitial;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	/*constructor without params*/
	public UserModel() { }
	
}

package controllers;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import beans.User;
import beans.UserAuthentication;

@ManagedBean(name="registrationFormController")
@ViewScoped
public class RegistrationFormController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	// temporary field to hold persistent list of users. Probably will not hold new
	// values between runs. Must have a setter to work properly.
	@ManagedProperty(value = "#{userAuthentication}")
	private UserAuthentication users;

	/**
	 * Takes in submit request from registration form
	 * @param newUser The user the is going to be added
	 * @return A String to either the login.xhtml page for success or a return to the register.xhtml page on failure
	 */
	public String onSubmit(User newUser) {
		FacesContext fc = FacesContext.getCurrentInstance();
		
		// simulate database check for duplicate user. Some of the logic here will be
		// moved into the DAO classes later
		for (User user : users.getUserList()) {
			if(checkDuplicateUser(fc, user, newUser)) {
				// add the user back to the request before we return to the registration page
				fc.getExternalContext().getRequestMap().put("user", newUser);
				//failed, return to registration page
				return ("register.xhtml");
			}
		}
		
		//add the user
		users.addUser(newUser);
		
		// TODO: success message can be added here to show on the login page
		
		// on success go immediately to login
		return ("login.xhtml");
	}
	
	/**
	 * Checks if two users match via there userName and email fields
	 * @param fc current FacesContext to send messages to.
	 * @param user The existing user to check data against
	 * @param newUser The new user that is attempting to be added
	 * @return true for a duplicate match
	 */
	private boolean checkDuplicateUser(FacesContext fc, User user, User newUser) {
		boolean result = false;
		
		//check for duplicate userName
		if (user.getUserName().equals(newUser.getUserName())) {
			// add the error message to the page "registrationForm:userName" needs to be the
			// id of the form and the id of the userName field
			fc.addMessage("registrationForm:userName", new FacesMessage("That Username has already been taken!"));
			// Duplicate was found
			result = true;
		}
		
		// check for duplicate email
		if (user.getEmail().equals(newUser.getEmail())) {
			// add the error message to the page "registrationForm:email" needs to be the id
			// of the form and the id of the email field
			fc.addMessage("registrationForm:email", new FacesMessage("That Email is being used by another person!"));
			// Duplicate was found
			result = true;
		}
		
		return result;
	}

	// Setter for injected bean
	public void setUsers(UserAuthentication users) {
		this.users = users;
	}
}

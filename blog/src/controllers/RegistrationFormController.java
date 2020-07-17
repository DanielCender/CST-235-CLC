package controllers;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import beans.User;

@ManagedBean
@ViewScoped
public class RegistrationFormController {
	
	//temporary field to hold persistent list of users. Probably will not hold new values between runs.
	@ManagedProperty(value = "#{users}")
	private List<User> users;
	
	String onSubmit(User newUser) {
	
		FacesContext fc = FacesContext.getCurrentInstance();
		
		//simulate database check for duplicate user. Some of the logic here will be moved into the DAO classes later
		for(User user : users) {
			//check for duplicate userName
			if(user.getUserName().equals(newUser.getUserName())) {
				
				//add the error message to the page "registrationForm:userName" needs to be the id of the form and the id of the userName field
				fc.addMessage("registrationForm:userName", new FacesMessage("That Username has already been taken!"));
				
				//add the user back to the request before we return to the registration page
				fc.getExternalContext().getRequestMap().put("user", newUser);
				
				//failed return to registration page
				return ("register.xhtml");
			}
			//check for duplicate email
			else if(user.getEmail().equals(newUser.getEmail())) {
				
				//add the error message to the page "registrationForm:email" needs to be the id of the form and the id of the email field
				fc.addMessage("registrationForm:userName", new FacesMessage("That Email is being used by another person!"));
				
				//add the user back to the request before we return to the registration page
				fc.getExternalContext().getRequestMap().put("user", newUser);
				
				//failed return to registration page
				return ("register.xhtml");
			}
		}
		
		users.add(newUser);
			
		//if success go immediately to login
		return ("login.xhtml");
	}
}

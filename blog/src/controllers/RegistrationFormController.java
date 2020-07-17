package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import beans.UserAuthentication;
import beans.User;

@ManagedBean
@ViewScoped
public class RegistrationFormController {
	@Inject
	public UserAuthentication auth;
		
	public String onSubmit(User user) {
		auth.addUser(user);
		// Successful registration redirects to index page
		return "index.xhtml";
	}
}

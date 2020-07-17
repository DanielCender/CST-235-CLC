package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import beans.UserAuthentication;
import beans.User;

@ManagedBean
@ViewScoped
public class LoginFormController {
    @Inject
    public UserAuthentication auth;
	
	public String onSubmit(User user) {
		if(auth.validateLogin(user.getEmail(), user.getPassword())) {
			// Successful login redirects to index page
			return "index.xhtml";
		} else {
			// TODO: Set some validation error for the form
		}
		return "login.xhtml";
	}
}

package controllers;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.UserAuthentication;
import beans.User;

@ManagedBean
@ViewScoped
public class LoginFormController {
    @Inject
    public UserAuthentication auth;
	
	public String onSubmit(User user) {
		FacesContext fc = FacesContext.getCurrentInstance();
		if(auth.validateLogin(user.getEmail(), user.getPassword())) {
			// Successful login redirects to index page
			return "index.xhtml";
		} else {
			fc.addMessage("loginForm:password", new FacesMessage("That email and password combination is invalid."));
		}
//		return "login.xhtml";
		return "";
	}
}

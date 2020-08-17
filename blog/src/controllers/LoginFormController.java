package controllers;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import business.UserAuthenticationInterface;
import beans.User;

/**
 * 
 * Managed bean to handle login form requests.
 *
 */
@ManagedBean
@ViewScoped
public class LoginFormController {
	
    @Inject
    private UserAuthenticationInterface auth;
   
    /**
     * Attempts to login a user with the given credentials.
     * @param user the credentials to use for login attempt.
     * @return String indicating which page to return to after login attempt.
     */
	public String onSubmit(User user) {
		FacesContext fc = FacesContext.getCurrentInstance();
		if(auth.validateLogin(user.getEmail(), user.getPassword())) {
			user = auth.getUser(user.getEmail());
			fc.getExternalContext().getSessionMap().put("sessionUser", user);
			fc.addMessage("index", new FacesMessage("You have been logged in as " + user.getUserName() + "!"));
			
			// Successful login redirects to index page
			return "index.xhtml";
		} else {
			fc.addMessage("loginForm:password", new FacesMessage("That email and password combination is invalid."));
		}
		// Go back to login if unsuccessful
		return "login.xhtml";
	}
	
	/**
	 * Logs the current session user out and ends the current session.
	 * @return String for the page to navigate to after ending the session.
	 */
	public String onLogout() {
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.getExternalContext().invalidateSession();
		fc.addMessage("index", new FacesMessage("You have been logged out!"));
		return "index?faces-redirect=true";
	}
}

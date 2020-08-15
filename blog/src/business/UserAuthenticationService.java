package business;

import beans.User;
import data.UserDataAccessInterface;

import java.util.List;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
//import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

/**
 * Session Bean implementation class UserAuthenticationService
 */
@Stateless
@Local(UserAuthenticationInterface.class)
@LocalBean
public class UserAuthenticationService implements UserAuthenticationInterface {

	@Inject
	private UserDataAccessInterface<User> dao;
	
    /**
     * Default constructor. 
     */
    public UserAuthenticationService() {
    	// TODO: For now, just populating a static list of users on instantiation
		/*this.addUser(new User("daniel", "cender", "danc", "danc", "dan@gmail.com"));
		this.addUser(new User("marc", "teixeira", "marct", "marct", "marc@gmail.com"));
		this.addUser(new User("tim", "james", "timj", "timj", "tim@gmail.com"));
		this.addUser(new User("chance", "anderson", "chancea", "chancea", "chance@gmail.com"));*/
    }

    /**
     * Method to get all users in the database as a List.
     * @return List<User> all the users found in the database.
     */
    @Override
    public List<User> getUserList() {
        return dao.getAll();
    }
    
    /**
     * Method to retrieve a single user by their email.
     * @param email the email used for the search.
     * @return User retrieved from the database with matching email.
     */
    @Override
    public User getUser(String email) {
    	return dao.get(email);
    }
    
    /**
     * Method for checking if a duplicate username exists
     * @param username the given username to check for
     * @return true if there is a duplicate username.
     */
    @Override
    public boolean checkDuplicateUsername(String username) {
    	for(User u : this.getUserList()) {
    		if(u.getUserName().equals(username)) {
    			return true;
    		}
    	}
    	return false;
    }
    
    /**
     * Method for checking duplicate email.
     * @param email the given email to check for
     * @return true if there is a duplicate email.
     */
    @Override
    public boolean checkDuplicateEmail(String email) {
    	for(User u : this.getUserList()) {
    		if(u.getEmail().equals(email)) {
    			return true;
    		}
    	}
    	return false;
    }
	
    /**
     * Method for adding a user to the database
     * @param newUser the user to add to the database.
     */
    @Override
    public void addUser(User newUser) {
        dao.save(newUser);
    }

    /**
     * Method to validate a login with an email and password.
     * @param email the users email.
     * @param password the users password.
     * @return true if the user was logged in.
     */
	@Override
	public boolean validateLogin(String email, String password) {
		boolean loginVerified = false;
		for (User u : this.getUserList()) {
			if (u.getEmail().equalsIgnoreCase(email)) {
				if (u.getPassword().equals(password))
					loginVerified = true;
			}
		}
		return loginVerified;
	}
}

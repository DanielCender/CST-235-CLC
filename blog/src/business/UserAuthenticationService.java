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

    @Override
    public List<User> getUserList() {
        return dao.getAll();
    }
    
    @Override
    public User getUser(String email) {
    	return dao.get(email);
    }
    
    @Override
    public boolean checkDuplicateUsername(String username) {
    	for(User u : this.getUserList()) {
    		if(u.getUserName().equals(username)) {
    			return true;
    		}
    	}
    	return false;
    }
    
    @Override
    public boolean checkDuplicateEmail(String email) {
    	for(User u : this.getUserList()) {
    		if(u.getEmail().equals(email)) {
    			return true;
    		}
    	}
    	return false;
    }
	
    @Override
    public void addUser(User newUser) {
        dao.save(newUser);
    }

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

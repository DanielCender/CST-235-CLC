package business;

import beans.User;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
//import javax.enterprise.inject.Alternative;

/**
 * Session Bean implementation class UserAuthenticationService
 */
@Stateless
@Local(UserAuthenticationInterface.class)
@LocalBean
public class UserAuthenticationService implements UserAuthenticationInterface {
	
	private List<User> userList = new ArrayList<>();

    /**
     * Default constructor. 
     */
    public UserAuthenticationService() {
    	// TODO: For now, just populating a static list of users on instantiation
		userList.add(new User("daniel", "cender", "danc", "danc", "dan@gmail.com"));
		userList.add(new User("marc", "teixeira", "marct", "marct", "marc@gmail.com"));
		userList.add(new User("tim", "james", "timj", "timj", "tim@gmail.com"));
		userList.add(new User("chance", "anderson", "chancea", "chancea", "chance@gmail.com"));
    }

	
    @Override
    public List<User> getUserList() {
        return userList;
    }

	
    @Override
    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

	
    @Override
    public void addUser(User newUser) {
        userList.add(newUser);
    }


	@Override
	public boolean validateLogin(String email, String password) {
		boolean loginVerified = false;
		for (User u : userList) {
			if (u.getEmail().equalsIgnoreCase(email)) {
				if (u.getPassword().equals(password))
					loginVerified = true;
			}
		}
		return loginVerified;
	}

}

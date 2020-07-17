package beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;

@ManagedBean
@ApplicationScoped
public class UserAuthentication {
	
	private List<User> userList;
	
	public UserAuthentication() {
		userList = new ArrayList<>();
	}
	
	public void addUser(User user) {
		userList.add(user);
	}
	
	public boolean validateLogin(String userName, String password) {
		boolean permission = false;
		for (User u : userList) {
			if (u.getUserName().equals(userName) && u.getPassword().equals(password))
				permission = true;
		}
		
		return permission;
	}
	
}

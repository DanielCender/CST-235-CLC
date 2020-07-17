package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;



@ManagedBean(name="userAuthentication", eager=true)
@ApplicationScoped
public class UserAuthentication {
	
	private List<User> userList;
	
	public UserAuthentication() {
		userList = new ArrayList<>();
		
		// TODO: For now, just populating a static list of users on instantiation
		userList.add(new User("daniel", "cender", "danc", "danc", "dan@gmail.com"));
		userList.add(new User("marc", "teixeira", "marct", "marct", "marc@gmail.com"));
		userList.add(new User("tim", "james", "timj", "timj", "tim@gmail.com"));
		userList.add(new User("chance", "anderson", "chancea", "chancea", "chance@gmail.com"));
	}
	
	public void addUser(User user) {
		userList.add(user);
	}
	
	public boolean validateLogin(String email, String password) {
		boolean permission = false;
		for (User u : userList) {
			if (u.getEmail().equals(email) && u.getPassword().equals(password))
				permission = true;
		}
		
		return permission;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
}

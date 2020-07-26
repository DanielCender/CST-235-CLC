package business;

import java.util.List;

import javax.ejb.Local;

import beans.User;

@Local
public interface UserAuthenticationInterface {
	
	public List<User> getUserList();
	
	public void setUserList(List<User> userList);
	
	public void addUser(User newUser);
	
	public boolean validateLogin(String email, String password);

}

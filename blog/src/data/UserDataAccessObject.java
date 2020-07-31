package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import beans.User;

@Stateless
@Local(DataAccessInterface.class)
@LocalBean
public class UserDataAccessObject implements DataAccessInterface<User> {

	@Inject 
	private User user;
	
	@Override
	public User get(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAll() {
		Connection conn = DataAccessInterface.getConnection();
		List<User> userList = new ArrayList<User>();
		
		try {
			String statement = "SELECT * FROM GCU.Users";
			Statement query = conn.createStatement();
			ResultSet rs = query.executeQuery(statement);
			
			while(rs.next()) {
				user.setUserName(rs.getString("UserName"));
				user.setEmail(rs.getString("Email"));
				user.setFirstName(rs.getString("FirstName"));
				user.setLastName(rs.getString("LastName"));
				user.setPassword(rs.getString("Password"));
				userList.add(new User(user));
			}
			System.out.println("Finished generating user list!");
		}
		catch(SQLException ex) {
			System.out.println("Error trying to get user list: " + ex.getMessage());
		}
		finally {
			if(conn != null) {
				try {
					conn.close();
					System.out.println("Connection Closed!");
				}
				catch(SQLException ex) {
					System.out.println("Problem Closing Connection!");
				}
			}
		}
		
		return userList;
	}

	@Override
	public void save(User t) {
		Connection conn = DataAccessInterface.getConnection();
		try {
			String query = "INSERT INTO GCU.Users (FirstName, LastName, Username, Password, Email) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, t.getFirstName());
			ps.setString(2, t.getLastName());
			ps.setString(3, t.getUserName());
			ps.setString(4, t.getPassword());
			ps.setString(5, t.getEmail());
			
			int rows = ps.executeUpdate();
			if(rows < 1) {
				System.out.println("Could not register user!");
			}
			else {
				System.out.println("Registered user!");
			}
		}
		catch(SQLException ex) {
			System.out.println("Could not add new user: " + ex.getMessage());
		}
		finally {
			if(conn != null) {
				try {
					conn.close();
					System.out.println("Connection Closed!");
				}
				catch(SQLException ex) {
					System.out.println("Problem Closing Connection!");
				}
			}
		}
	}

	@Override
	public void update(User t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User t) {
		// TODO Auto-generated method stub
		
	}

}

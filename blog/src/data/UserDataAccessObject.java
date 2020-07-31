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
	
	//Gets a single user by their email
	@Override
	public User get(String email) {
		Connection conn = DataAccessInterface.getConnection();
		user = new User();
		
		try {
			String query = "SELECT * FROM GCU.Users WHERE EMAIL = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				user.setUserName(rs.getString("UserName"));
				user.setEmail(rs.getString("Email"));
				user.setFirstName(rs.getString("FirstName"));
				user.setLastName(rs.getString("LastName"));
				user.setPassword(rs.getString("Password"));
			}
			
			rs.close();
			ps.close();
			
			System.out.println("Finished finding user by email!");
		}
		catch(SQLException ex) {
			System.out.println("Error trying to get user by email: " + ex.getMessage());
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
		
		return new User(user);
	}

	@Override
	public List<User> getAll() {
		Connection conn = DataAccessInterface.getConnection();
		List<User> userList = new ArrayList<User>();
		
		try {
			String query = "SELECT * FROM GCU.Users";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				user.setUserName(rs.getString("UserName"));
				user.setEmail(rs.getString("Email"));
				user.setFirstName(rs.getString("FirstName"));
				user.setLastName(rs.getString("LastName"));
				user.setPassword(rs.getString("Password"));
				userList.add(new User(user));
			}
			
			rs.close();
			statement.close();
			
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

	//Saves a single user to the database
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
			
			ps.close();
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

	//updates a users with the given email to the new information in t
	@Override
	public void update(String email, User t) {
		Connection conn = DataAccessInterface.getConnection();
		try {
			String query = "UPDATE GCU.Users SET FirstName=?, LastName=?, Username=?, Password=?, Email=? WHERE Email=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, t.getFirstName());
			ps.setString(2, t.getLastName());
			ps.setString(3, t.getUserName());
			ps.setString(4, t.getPassword());
			ps.setString(5, t.getEmail());
			ps.setString(6, email);
			
			int rows = ps.executeUpdate();
			if(rows < 1) {
				System.out.println("Could not update user!");
			}
			else {
				System.out.println("Updated user!");
			}
			
			ps.close();
		}
		catch(SQLException ex) {
			System.out.println("Could not update user: " + ex.getMessage());
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

	//deletes a single user with the given email
	@Override
	public void delete(User t) {
		Connection conn = DataAccessInterface.getConnection();
		try {
			String query = "DELETE FROM GCU.Users WHERE Email=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, t.getEmail());
			
			int rows = ps.executeUpdate();
			if(rows < 1) {
				System.out.println("Could not delete user!");
			}
			else {
				System.out.println("User Deleted!");
			}
			
			ps.close();
		}
		catch(SQLException ex) {
			System.out.println("Could not delete user: " + ex.getMessage());
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
}

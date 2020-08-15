package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.Local;

/**
 * 
 * Interface designed for implementing different Database Access Objects.
 *
 * @param <T> generic type for CRUD operations of each Data Access Object.
 */
@Local
public interface DataAccessInterface<T> {
	
	//TODO: these need to be changed based on individual connection username and password
	public static final String dbURL = "jdbc:postgresql://localhost:5432/postgres"; //this is the string for postgres
	public static final String username = "postgres"; //admin username when setting up postgres
	public static final String password = "root"; //password for postgres connection
			
	/**
	 * retrieves a connection to the current database
	 * @return the given connection to use for the dao methods, must be closed manually outside of this method.
	 */
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(dbURL, username, password);
			System.out.println("Connection Made!");
		}
		catch(SQLException ex) {
			System.out.println("Failure! " + ex.getMessage());
		}
		return conn;
	}
	
	// CRUD pattern methods
	public T get(String id);
	List<T> getAll();
	void save(T t);
	void update(String id, T t);
	void delete(T t);
}

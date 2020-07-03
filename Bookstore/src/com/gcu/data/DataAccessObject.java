package com.gcu.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.gcu.models.RegisterUserModel;
import com.gcu.models.UserModel;

@Component
public class DataAccessObject implements UserDataInterface {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean Login(String Email, String Password) {
		// create string for logging in using email and password
		String LoginString = "SELECT COUNT (DISTINCT Email) AS Count FROM GCU.Users WHERE Email = ? AND Password = ?";

		int rowsEffected = jdbcTemplate.queryForObject(LoginString, Integer.class, Email, Password);

		System.out.println("Rows found: " + rowsEffected);

		Boolean isAuthed = rowsEffected == 1;

		return isAuthed;
	}

	@Override
	public boolean isAvailable(RegisterUserModel user) {
		String checkExists = "SELECT COUNT (DISTINCT Email) AS Count from GCU.Users WHERE Email = ?";

		System.out.println("To be executed: " + checkExists);
		Integer rowsEffected = jdbcTemplate.queryForObject(checkExists, Integer.class, user.getEmail());
		System.out.println("Rows found: " + rowsEffected);

		Boolean isAvailable = rowsEffected == 0;

		return isAvailable;
	}

	@Override
	public boolean Register(RegisterUserModel user) {
		String InsertUser = "INSERT INTO GCU.Users (Email, Password, FirstName, MiddleInitial, LastName, Username) Values (?,?,?,?,?,?)";

		// execute update using sql string and save result
		int result = jdbcTemplate.update(InsertUser, user.getEmail(), user.getPassword(), user.getFirstName(), user.getMiddleInitial(), user.getLastName(),
				user.getUsername());

		return result > 0;
	}

	@Override
	public boolean create(UserModel y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(UserModel y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserModel findByID(int ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserModel> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}

package com.gcu.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gcu.models.UserModel;

public class UserRowMapper implements RowMapper<UserModel> {
	@Override
	public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserModel user = new UserModel();
		user.setEmail(rs.getString("Email"));
		user.setFirstName(rs.getString("FirstName"));
		user.setMiddleInitial(rs.getString("MiddleInitial"));
		user.setLastName(rs.getString("LastName"));
		user.setUsername(rs.getString("Username"));
		user.setPassword(rs.getString("Password"));
		return user;
}
}
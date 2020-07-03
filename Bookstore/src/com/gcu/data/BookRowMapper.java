package com.gcu.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gcu.models.BookModel;

public class BookRowMapper implements RowMapper<BookModel>  {
	@Override
	public BookModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		BookModel book = new BookModel();
		book.setAppId(rs.getInt("ID"));
		book.setTitle(rs.getString("Title"));
		book.setAuthor(rs.getString("Author"));
		book.setISBN(rs.getString("ISBN"));
		book.setPublisher(rs.getString("Publisher"));
		return book;
}
}

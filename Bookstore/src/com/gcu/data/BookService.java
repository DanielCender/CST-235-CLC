package com.gcu.data;

import com.gcu.models.BookModel;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class BookService implements DataInterface<BookModel> {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean create(BookModel y) {
		String InsertBook = "INSERT INTO GCU.Books (Title, Author, ISBN, Publisher) Values (?,?,?,?)";
		int result = jdbcTemplate.update(InsertBook, y.getTitle(), y.getAuthor(), y.getISBN(), y.getPublisher());
		return result > 0;
	}

	@Override
	public boolean update(BookModel y) {
		String UpdateBook = "UPDATE GCU.Books SET Title = ?, Author = ?, ISBN = ?, Publisher = ? WHERE ID = ?";
		int result = jdbcTemplate.update(UpdateBook, y.getTitle(), y.getAuthor(), y.getISBN(), y.getPublisher(), y.getAppId());
		
		return result > 0;
	}

	@Override
	public BookModel findByID(int id) {
		BookModel book;
		String sql = "SELECT * FROM GCU.Books WHERE ID = ?";
		book = jdbcTemplate.queryForObject(sql, new Object[] { id }, new BookRowMapper());
		return book;
	}

	@Override
	public List<BookModel> findAll() {
		List<BookModel> list = new ArrayList<BookModel>();
		String sql = "SELECT * FROM GCU.Books";
		list = jdbcTemplate.query(sql, new BookRowMapper());
		return list;
	}

	@Override
	public boolean delete(int id) {
		String InsertBook = "DELETE FROM GCU.Books WHERE ID = ?";
		int result = jdbcTemplate.update(InsertBook, id);
		return result > 0;
	}

}

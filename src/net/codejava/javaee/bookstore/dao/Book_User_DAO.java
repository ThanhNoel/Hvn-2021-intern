package net.codejava.javaee.bookstore.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Book_User_DAO {
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection; 

	public Book_User_DAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		this.jdbcURL = jdbcURL;
		this.jdbcUsername = jdbcUsername;
		this.jdbcPassword = jdbcPassword;
	}
 
	protected void connect() throws SQLException {
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		}
	}

	protected void disconnect() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}
	public boolean insert_BookName_IdUser(String book_name, int id_user) throws SQLException {
		String sql = "INSERT INTO mergedtable(user_id, book_name) VALUES (?, ?)";
		connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, id_user);
		statement.setString(2, book_name);

		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowInserted;
	}
	
	public List<String> ShowSelectedBook(int user_id) throws SQLException {
		System.out.println(user_id);
		List<String> listBook = new ArrayList<>();
		String sql = "SELECT * FROM mergedtable WHERE user_id = ?";
		connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, user_id);
		
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			String title = resultSet.getString("book_name");
			listBook.add(title);
		}

		resultSet.close();
		statement.close();

		disconnect();

		return listBook;
	}

}

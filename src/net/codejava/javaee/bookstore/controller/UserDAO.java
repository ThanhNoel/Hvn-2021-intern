package net.codejava.javaee.bookstore.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.codejava.javaee.bookstore.model.User;

public class UserDAO {

	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword; 
	private Connection jdbcConnection;

	public UserDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		this.jdbcURL = jdbcURL;
		this.jdbcUsername = jdbcUsername;
		this.jdbcPassword = jdbcPassword;
	}

	public UserDAO() {
		// TODO Auto-generated constructor stub
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

//---------------------------------------------------
	public User checkLogin(String email, String password) throws SQLException, ClassNotFoundException {
		// this is a bug,I don't understand why I can't use "connect()"
		String jdbcURL = "jdbc:mysql://localhost:3306/bookstore";
		String jdbcUsername = "root";
		String jdbcPassword = "030699";

		Class.forName("com.mysql.jdbc.Driver");
		Connection jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);

		User user = new User();
		String sql = "SELECT * FROM user WHERE email = ? and password = ?";
		//connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, email);
		statement.setString(2, password);

		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
	        
			
	        user.setId(resultSet.getInt(1));
	        user.setName(resultSet.getString(2));
	        user.setEmail(resultSet.getString(3));
	        user.setAge(resultSet.getInt(4));
	        user.setDate(resultSet.getString(5));
	        user.setPassword(resultSet.getString(6));
	        user.setRole(resultSet.getString(7));
	
		}

		
		resultSet.close();
		statement.close();
		return user;
	}
	
	
	
	public boolean insertRegisteredUser(User user) throws SQLException {
		String sql = "INSERT INTO user (name, email, age, date, password) VALUES (?, ?, ?, ?, ?)";
		connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, user.getName());
		statement.setString(2, user.getEmail());
		statement.setInt(3, user.getAge());
		statement.setString(4, user.getDate());
		statement.setString(5, user.getPassword());

		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowInserted;
	}

	// ---------------------------------------------------------------------------
	public boolean insertUser(User user) throws SQLException {
		String sql = "INSERT INTO user (name, email, age, date) VALUES (?, ?, ?, ?)";
		connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, user.getName());
		statement.setString(2, user.getEmail());
		statement.setInt(3, user.getAge());
		statement.setString(4, user.getDate());

		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowInserted;
	}

	public List<User> listAllUsers() throws SQLException {
		List<User> listUser = new ArrayList<>();

		String sql = "SELECT * FROM user";

		connect();

		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			int id = resultSet.getInt("user_id");
			String name = resultSet.getString("name");
			String email = resultSet.getString("email");
			int age = resultSet.getInt("age");
			String date = resultSet.getString("date");
			
			User user = new User(id, name, email, age, date);
			listUser.add(user);
		}

		resultSet.close();
		statement.close();

		disconnect();

		return listUser;
	}

	public boolean deleteUser(User user) throws SQLException {
		String sql = "DELETE FROM user where user_id = ?";

		connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, user.getId());

		boolean rowDeleted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowDeleted;
	}

	public boolean updateUser(User user) throws SQLException {
		String sql = "UPDATE user SET name = ?, email = ?, age = ?, date = ? WHERE user_id = ?";
		connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, user.getName());
		statement.setString(2, user.getEmail());
		statement.setInt(3, user.getAge());
		statement.setString(4, user.getDate());
		statement.setInt(5, user.getId());


		boolean rowUpdated = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowUpdated;
	}

	public User getUser(int id) throws SQLException {
		User user = null;
		String sql = "SELECT * FROM user WHERE user_id = ?";

		connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet resultSet = statement.executeQuery();

		if (resultSet.next()) {
			String name = resultSet.getString("name");
			String email = resultSet.getString("email");
			int age = resultSet.getInt("age");
			String date = resultSet.getString("date");
			
			user = new User(id, name, email, age, date);
		}

		resultSet.close();
		statement.close();

		return user;
	}
	
	//---------------------------------------------------
	public User authenticateUser(User user) throws SQLException, ClassNotFoundException{
		
		String jdbcURL = "jdbc:mysql://localhost:3306/bookstore";
		String jdbcUsername = "root";
		String jdbcPassword = "030699";

		Class.forName("com.mysql.jdbc.Driver");
		Connection Connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		
	
		String sql = "SELECT * FROM user WHERE email = ? AND password = ?";

	   
		PreparedStatement statement = Connection.prepareStatement(sql);
		statement.setString(1, user.getEmail());
		statement.setNString(2, user.getPassword());
		ResultSet resultSet = statement.executeQuery();
		

		 if (resultSet.next()){
		        
		        User u = new User();
		        u.setId(resultSet.getInt(0));
		        u.setName(resultSet.getString(1));
		        u.setEmail(resultSet.getString(2));
		        u.setAge(resultSet.getInt(3));
		        u.setDate(resultSet.getString(4));
		        u.setPassword(resultSet.getString(5));
		        u.setRole(resultSet.getString(6));
		        
		        return u;
		 }
		 
		 resultSet.close();
		 statement.close();
		 return null;
	}
}

package com.nashtech.intern.dao.IMPL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.nashtech.intern.dao.IUserDAO;
import com.nashtech.intern.database.DatabaseConnection;
import com.nashtech.intern.model.User;

public class UserDAO extends DatabaseConnection implements IUserDAO {

	@Override
	public List<User> getAllUser() {
		List<User> users = new ArrayList<User>();

		String sql = "SELECT * FROM intern_library.user";
		try {
			Statement statement = connector.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (statement.execute(sql)) {
                rs = statement.getResultSet();
            }

			
			while (rs.next()) {
				User user = new User();
				user.setUserId(rs.getLong("userID"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setAge(rs.getInt("age"));
				user.setDob(rs.getDate("dob"));
				user.setEmail(rs.getString("email"));

				users.add(user);
			}
			statement.close();
			connector.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	
	@Override
	public User getUserById(long userId) {
		User user = new User();
		String sql = "SELECT * FROM intern_library.user where userID=?";
		try {
			PreparedStatement ps = connector.prepareStatement(sql);
			ps.setLong(1, userId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				user.setUserId(rs.getLong("useID"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setAge(rs.getInt("age"));
				user.setDob(rs.getDate("dob"));
				user.setEmail(rs.getString("email"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addUser(User user) {
		String sql = "INSERT INTO intern_library.user(firstName,lastName,age,dob,email) VALUES(?,?,?,?,?)";
		try {
			PreparedStatement ps = connector.prepareStatement(sql);
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setInt(3, user.getAge());
			ps.setDate(4, (java.sql.Date) user.getDob());
			ps.setString(5, user.getEmail());

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean modifyUser(User user) {
		String sql = "Update intern_library.user set firstName=?, lastName =?, age=? ,dob=? ,email=? where userID=?";
		try {
			PreparedStatement ps = connector.prepareStatement(sql);
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setInt(3, user.getAge());
			ps.setDate(4, (java.sql.Date) user.getDob());
			ps.setString(5, user.getEmail());
			ps.setLong(6, user.getUserId());
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;
	}

//	public static void main() {
//		UserDAO userDAO = new UserDAO();
//		List<User> users = userDAO.getAllUser();
//		for (User user : users) {
//			System.out.println(user.getEmail());
//		}
//	}
}

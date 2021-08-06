package com.nashtech.intern.dao.IMPL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.nashtech.intern.dao.IUserDAO;
import com.nashtech.intern.database.DatabaseConnection;
import com.nashtech.intern.model.User;

public class UserDAO extends DatabaseConnection implements IUserDAO {

	@Override
	public List<User> getAllUser() {
		List<User> result = new ArrayList<User>();

		String sql = "SELECT * FROM intern_library.user";
		try {
			PreparedStatement ps = connector.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				User user = new User();
				user.setUserId((long) rs.getInt("userID"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setAge(rs.getInt("age"));
				user.setDob(rs.getDate("dob"));
				user.setEmail(rs.getString("email"));

				result.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public User getUserById(int userId) {
		User user = new User();
		String sql = "SELECT * FROM intern_library.user where idUser=?";
		try {
			PreparedStatement ps = connector.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				user.setUserId((long) rs.getInt("useID"));
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

}

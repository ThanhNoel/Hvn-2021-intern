package com.nashtech.intern.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.nashtech.intern.model.User;

public class UserDAO extends GenericDAO{

	public List<User> getAllUser(){
		List<User> result =new ArrayList<User>();
		
		String sql ="SELECT * FROM thuc_tap.user";
		try {
			PreparedStatement ps =con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				User user =new User();
				user.setIdUser(rs.getInt("idUser"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setAge(rs.getInt("age"));
				user.setDateOfBirth(rs.getDate("dateOfBirth"));
				user.setEmail(rs.getString("email"));
				result.add(user);
			}
		}catch (Exception e) {
			 e.printStackTrace();
		}
		return result;
	}
	
	public void addUser(User user) {
		String sql = "INSERT INTO thuc_tap.user(firstName,lastName,age,dateOfBirth,email) VALUES(?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setInt(3, user.getAge());
			ps.setDate(4, (Date) user.getDateOfBirth());
			ps.setString(5, user.getEmail());
			
			ps.executeUpdate();
			
			ResultSet generateKeys =ps.getGeneratedKeys();
			if(generateKeys.next()) {
				user.setIdUser(generateKeys.getInt(1));
			}
		}catch (Exception e) {
			 e.printStackTrace();
		}
	}
	
	public User getUserById(int key) {
		User user =new User();
		String sql="SELECT * FROM thuc_tap.user where idUser=?";
		try {
			PreparedStatement ps =con.prepareStatement(sql);
			ps.setInt(1, key);
			ResultSet rs =ps.executeQuery();
			
			if(rs.next()) {
				user.setIdUser(rs.getInt("idUser"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setAge(rs.getInt("age"));
				user.setDateOfBirth(rs.getDate("dateOfBirth"));
				user.setEmail(rs.getString("email"));
				return user;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean editUser(User user) {
		String sql="Update thuc_tap.user set firstName=?, lastName =?, age=? ,dateOfBirth=? ,email=? where idUser=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setInt(3, user.getAge());
			ps.setDate(4, (Date) user.getDateOfBirth());
			ps.setString(5, user.getEmail());
			ps.setInt(6, user.getIdUser());
			return ps.executeUpdate() > 0;
		}catch (Exception e) {
			e.printStackTrace();
            System.out.println("loi edit");
		}
		return false;
	}
}

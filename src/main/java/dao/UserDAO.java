package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDAO {
	private String url = "jdbc:mysql://localhost:3306/book";
	private String userName="root";
	private String passWord="letunglam";
	private Connection con = null;
	
	public UserDAO() {
		con = this.getConnection();
	}

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, userName, passWord);
			System.out.println("Connected");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return con;
	}
	
	public List<User> getAllUser(){
		String query ="select * from user";
		List<User> list = new ArrayList<User>();
		PreparedStatement pst;
		ResultSet rs;
		try {
			pst = con.prepareStatement(query);
			rs = pst.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				user.setEmail(rs.getString("email"));
				user.setDob(rs.getDate("dob"));
				user.setAge(rs.getInt("age"));
				list.add(user);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public void addUser(User user) {
		String query = "insert into user (firstname,lastname,email,dob,age) values (?,?,?,?,?)";
		PreparedStatement pst;
		try {
			pst = con.prepareStatement(query);
			pst.setString(1, user.getFirstName());
			pst.setString(2, user.getLastName());
			pst.setString(3, user.getEmail());
			pst.setDate(4, user.getDob());
			pst.setInt(5, user.getAge());
			pst.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public boolean updateUser(String firstName,String lastName,String email,Date dob, int age, int id) {
		boolean a= false;
		String query = "update user set firstname=?,lastname=?,email=?,dob=?,age=? where id=?";
		PreparedStatement pst;
		try {
			pst = con.prepareStatement(query);
			pst.setString(1, firstName);
			pst.setString(2, lastName);
			pst.setString(3, email);
			pst.setDate(4, dob);
			pst.setInt(5, age);
			pst.setInt(6, id);
			if (pst.executeUpdate()>0) {
				a = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return a;
	}

	public User getByID(int id) {
		User user = new User();
		String query = "select * from user where id =?";
		PreparedStatement pst;
		ResultSet rs;
		try {
			pst = con.prepareStatement(query);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while(rs.next()) {
				user.setId(id);
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				user.setEmail(rs.getString("email"));
				user.setDob(rs.getDate("dob"));
				user.setAge(0);	
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return user;
	}
	
//	public boolean deleteUser(int id) {
//		boolean a= false;
//		String query = "delete from user where id=?";
//		PreparedStatement pst;
//		try {
//			pst = con.prepareStatement(query);
//			pst.setInt(1, id);
//			if(pst.executeUpdate()>0) {
//				a = true;
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		return a;
//	}
}

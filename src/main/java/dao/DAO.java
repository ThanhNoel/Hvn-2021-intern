package dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Book;
import entity.User;

public class DAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public ArrayList<User> getAllUser() {
		ArrayList<User> listUser = new ArrayList<>();
		String sql = "SELECT * FROM webnt.user";

		try {

			new DBContext();
			conn = DBContext.getMySQLConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				String fname = rs.getString("fname");
				String lname = rs.getString("lname");
				String email = rs.getString("email");
				Integer age = rs.getInt("age");
				Date date = rs.getDate("dateofbirth");
				Integer id =rs.getInt("iduser");
				User u = new User(fname, lname, email, age, date, id);
				listUser.add(u);

			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return listUser;
	}
	
	public ArrayList<Book> getAllBook() {
		ArrayList<Book> listBook = new ArrayList<>();
		String sql = "SELECT * FROM webnt.book";

		try {

			new DBContext();
			conn = DBContext.getMySQLConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {

				Integer idbook = rs.getInt("idbook");
				String author = rs.getString("author");
				String title = rs.getString("title");
				String category = rs.getString("category");
				Book b = new Book( title, author, category,idbook);
				listBook.add(b);

			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return listBook;
	}
	public boolean addUser(User u) throws ClassNotFoundException, SQLException {
		new DBContext();
		String sql = "INSERT INTO `webnt`.`user` (`fname`, `lname`, `email`, `dateofbirth`, `iduser`) VALUES (?, ?, ?, ?, ?);";
		ps = DBContext.getMySQLConnection().prepareStatement(sql);
		ps.setString(1, u.getFname());
		ps.setString(2, u.getLname());
		ps.setString(3, u.getEmail());
		ps.setDate(4,u.getDateofbirth());
		ps.setInt(5, u.getIduser());
		return ps.executeUpdate() > 0;
	}
	public boolean updateUser(User u) throws ClassNotFoundException, SQLException {
		new DBContext();
		String sql = "UPDATE INTO `webnt`.`user` SET `fname` =?, `lname`=?, `email`=?, `age`=?, `dateofbirth`=?, `iduser`=? WHERE `iduser`=?;";
		ps = DBContext.getMySQLConnection().prepareStatement(sql);
		ps.setString(1, u.getFname());
		ps.setString(2, u.getLname());
		ps.setString(3, u.getEmail());
		ps.setInt(4, u.getAge());
		ps.setDate(5,u.getDateofbirth());
		ps.setInt(6, u.getIduser());
		return ps.executeUpdate() > 0;
	}
	public User getIDUser(Integer iduser) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM book WHERE iduser=?";
        ps = DBContext.getMySQLConnection().prepareStatement(sql);
		ps.setInt(1, iduser);
		rs = ps.executeQuery();
        User u = null;
        while (rs.next()) {
        	Integer id = rs.getInt("iduser");
			String fname = rs.getString("fname");
			String lname = rs.getString("lname");
			String email = rs.getString("email");
			Integer age = rs.getInt("age");
			Date date = rs.getDate("dateofbirth");
			u = new User(fname,lname,email,age,date,id);
        }
        return u;
    }
	public boolean addBook(Book b) throws ClassNotFoundException, SQLException {
		new DBContext();
		String sql = "INSERT INTO `webnt`.`book` (`title`, `author`, `category`,`idbook`) VALUES (?, ?, ?, ?);";
		ps = DBContext.getMySQLConnection().prepareStatement(sql);
		ps.setString(1, b.getTitle());
		ps.setString(2, b.getAuthor());
		ps.setString(3, b.getCategory());
		ps.setInt(4, b.getIdbook());
		return ps.executeUpdate() > 0;
	}
	public boolean updateBook(Book b) throws ClassNotFoundException, SQLException {
		new DBContext();
		String sql = "UPDATE INTO `webnt`.`book` SET `title` =?, `author`=?, `category`=?, WHERE `idbook`=?;";
		ps = DBContext.getMySQLConnection().prepareStatement(sql);
		ps.setString(1, b.getTitle());
		ps.setString(2, b.getAuthor());
		ps.setString(3, b.getCategory());
		
		return ps.executeUpdate() > 0;
	}
	public Book getIDBook(Integer idbook) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM book WHERE idbook=?";
        ps = DBContext.getMySQLConnection().prepareStatement(sql);
		ps.setInt(1, idbook);
		rs = ps.executeQuery();
        Book b = null;
        while (rs.next()) {
        	Integer id = rs.getInt("idbook");
			String name = rs.getString("title");
			String au = rs.getString("author");
			String cat = rs.getString("category");
			b = new Book( name, au, cat,id);
        }
        return b;
    }
}

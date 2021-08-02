package com.nashtech.intern.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.nashtech.intern.model.Book;
import com.nashtech.intern.model.User;

public class BookDAO extends GenericDAO {

	public List<Book> getAllBook() {
		List<Book> result = new ArrayList<Book>();
		String sql = "SELECT * FROM thuc_tap.book";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Book book = new Book();
				book.setIdBook(rs.getInt("idBook"));
				book.setAuthor(rs.getString("author"));
				book.setCategory(rs.getString("category"));
				book.setTitle(rs.getString("title"));

				User user = new User();
				UserDAO userDAO = new UserDAO();
				user = userDAO.getUserById(rs.getInt("idUser"));
				book.setUser(user);

				result.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public void addBook(Book book) {
		String sql = "INSERT INTO thuc_tap.book(title,author,category,idBook) VALUES(?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, book.getTitle());
			ps.setString(2, book.getAuthor());
			ps.setString(3, book.getCategory());

			ps.executeUpdate();

			ResultSet generateKeys = ps.getGeneratedKeys();
			if (generateKeys.next()) {
				book.setIdBook(generateKeys.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Book getBookById(int key) {
		Book book = new Book();
		String sql = "SELECT * FROM thuc_tap.book where idBook=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, key);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				book.setIdBook(rs.getInt("idBook"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setCategory(rs.getString("category"));

				User user = new User();
				UserDAO userDAO = new UserDAO();
				user = userDAO.getUserById(rs.getInt("idUser"));
				book.setUser(user);
				return book;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean editBook(Book book) {
		String sql="Update thuc_tap.book set title=?, author =?, category=? where idBook=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, book.getTitle());
			ps.setString(2, book.getAuthor());
			ps.setString(3, book.getCategory());
			ps.setInt(4, book.getIdBook());
			return ps.executeUpdate() > 0;
		}catch (Exception e) {
			e.printStackTrace();
            System.out.println("loi edit");
		}
		return false;
	}
	
	public List<Book> getAllBookByIdUserNull() {
		List<Book> result = new ArrayList<Book>();
		String sql = "SELECT * FROM thuc_tap.book where idUser is null";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Book book = new Book();
				book.setIdBook(rs.getInt("idBook"));
				book.setAuthor(rs.getString("author"));
				book.setCategory(rs.getString("category"));
				book.setTitle(rs.getString("title"));

				User user = new User();
				UserDAO userDAO = new UserDAO();
				user = userDAO.getUserById(rs.getInt("idUser"));
				book.setUser(user);

				result.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean editBookToUser(Book book) {
		String sql="Update thuc_tap.book set title=?, author =?, category=?, idUser=? where idBook=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, book.getTitle());
			ps.setString(2, book.getAuthor());
			ps.setString(3, book.getCategory());
			ps.setInt(4, book.getUser().getIdUser());
			ps.setInt(5, book.getIdBook());
			
			return ps.executeUpdate() > 0;
		}catch (Exception e) {
			e.printStackTrace();
            System.out.println("loi edit");
		}
		return false;
	}
	
	public List<Book> getAllBookByUser(int key) {
		List<Book> result = new ArrayList<Book>();
		String sql = "SELECT * FROM thuc_tap.book where idUser=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, key);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Book book =new Book();
				book.setIdBook(rs.getInt("idBook"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setCategory(rs.getString("category"));
				
				
				User user = new User();
				UserDAO userDAO = new UserDAO();
				user = userDAO.getUserById(rs.getInt("idUser"));
				book.setUser(user);
				
				result.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}

package com.nashtech.intern.dao.IMPL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.nashtech.intern.dao.IBookDAO;
import com.nashtech.intern.database.DatabaseConnection;
import com.nashtech.intern.model.Book;

public class BookDAO extends DatabaseConnection implements IBookDAO{

	public List<Book> getAllBooks() {
		List<Book> books = new ArrayList<>();
		String db = "select * from intern_library.book";
		try {
			PreparedStatement pStatement = connector.prepareStatement(db);
			ResultSet resultSet = pStatement.executeQuery();
			
			while (resultSet.next())
			{
				Book book = new Book();
				book.setBookId((long) resultSet.getInt("bookID"));
				book.setAuthor(resultSet.getString("author"));
				book.setTitle(resultSet.getString("title"));
				book.setCategory(resultSet.getString("category"));
				book.setUserId((long) resultSet.getInt("userID"));
				
				books.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return books;
	}

	public Book getBookById(int bookId) {
		Book book = new Book();
		String sql = "SELECT * FROM intern_library.book where bookID=?";
		try {
			PreparedStatement ps = connector.prepareStatement(sql);
			ps.setInt(1, bookId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				book.setBookId((long) rs.getInt("idBook"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setCategory(rs.getString("category"));
				book.setUserId((long) rs.getInt("userID"));
				return book;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Book> getBooksByUser(int userId) {
		List<Book> books = new ArrayList<Book>();
		String sql = "SELECT * FROM intern_library.book where userID=?";
		try {
			PreparedStatement ps = connector.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Book book =new Book();
				book.setBookId((long) rs.getInt("bookID"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setCategory(rs.getString("category"));
				book.setUserId((long) rs.getInt("userID"));
				
				books.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return books;
	}

	public void addBook(Book book) {
		String db = "insert into intern_library.book (title, author, category)"
				+ "values (?, ?, ?)";
		try {
			PreparedStatement pStatement = connector.prepareStatement(db);
			pStatement.setString(1, book.getTitle());
			pStatement.setString(2, book.getAuthor());
			pStatement.setString(3, book.getCategory());

			pStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean modifyBook(Book book) {
		String sql="Update intern_library.book set title=?, author =?, category=? where bookID=?";
		try {
			PreparedStatement ps = connector.prepareStatement(sql);
			ps.setString(1, book.getTitle());
			ps.setString(2, book.getAuthor());
			ps.setString(3, book.getCategory());
			ps.setLong(4, book.getBookId());
			return ps.executeUpdate() > 0;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public void addUserBorrowBook() {

	}

	public List<Book> getBooksByUserNull() {
		List<Book> books = new ArrayList<Book>();
		String sql = "SELECT * FROM intern_library.book where userID is null";
		try {
			PreparedStatement ps = connector.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Book book = new Book();
				book.setBookId((long) rs.getInt("bookID"));
				book.setAuthor(rs.getString("author"));
				book.setCategory(rs.getString("category"));
				book.setTitle(rs.getString("title"));
				book.setUserId((long) rs.getInt("userID"));

				books.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return books;
	}

}

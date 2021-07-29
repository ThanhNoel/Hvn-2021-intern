package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Book;

public class BookDAO {
	private String url = "jdbc:mysql://localhost:3306/book";
	private String userName="root";
	private String passWord="letunglam";
	private Connection con = null;
	
	public BookDAO() {
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
	
	public List<Book> getAllBook(){
		List<Book> list = new ArrayList<Book>();
		String query = "select *from book";
		PreparedStatement pst;
		ResultSet rs;
		try {
			pst = con.prepareStatement(query);
			rs = pst.executeQuery();
			while(rs.next()) {
				Book b = new Book();
				b.setId(rs.getInt("id"));
				b.setTitle(rs.getString("title"));
				b.setAuthor(rs.getString("author"));
				b.setCategory(rs.getString("category"));
				list.add(b);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	public void addBook(Book b) {
		String query = "insert into book (title,author,category) values (?,?,?)";
		PreparedStatement pst;
		try {
			pst = con.prepareStatement(query);
			pst.setString(1,b.getTitle());
			pst.setString(2, b.getAuthor());
			pst.setString(3, b.getCategory());
			pst.execute();	
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public boolean updateBook(int id, String title, String author, String category) {
		boolean a = false;
		String query = "update book set title=?,author=?,category=? where id=?";
		PreparedStatement pst;
		try {
			pst = con.prepareStatement(query);
			pst.setString(1,title);
			pst.setString(2, author);
			pst.setString(3, category);
			pst.setInt(4,id);
			if(pst.executeUpdate()>0) {
				a =true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return a;
	}
	
	public Book getByID(int id) {
		Book b = new Book();
		String query = "select * from book where id =?";
		PreparedStatement pst;
		ResultSet rs;
		try {
			pst = con.prepareStatement(query);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while(rs.next()) {
				b.setId(id);
				b.setTitle(rs.getString("title"));
				b.setAuthor(rs.getString("author"));
				b.setCategory(rs.getString("category"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return b;
	}
	
}

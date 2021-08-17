package net.codejava.javaee.bookstore.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.codejava.javaee.bookstore.dao.Book_User_DAO;

@WebServlet("/UpdateSelectedBookServlet")
public class UpdateSelectedBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Book_User_DAO book_UserDAO;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

		book_UserDAO = new Book_User_DAO(jdbcURL, jdbcUsername, jdbcPassword);
	}

	public UpdateSelectedBookServlet() {
		super(); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {   
			
			int id_user = Integer.parseInt(request.getParameter("id_user"));
			String[] checkbox = request.getParameterValues("checkbox");
			for (int i = 0; i < checkbox.length; i++) {
				if (checkbox[i] != null) {
					book_UserDAO.insert_BookName_IdUser(checkbox[i], id_user);
				}
			}
			System.out.println("user id is: " + id_user);
			response.sendRedirect("HomeServlet");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

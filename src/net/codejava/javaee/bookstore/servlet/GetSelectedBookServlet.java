package net.codejava.javaee.bookstore.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.codejava.javaee.bookstore.dao.Book_User_DAO;

@WebServlet("/GetSelectedBookServlet")
public class GetSelectedBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Book_User_DAO book_UserDAO;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

		book_UserDAO = new Book_User_DAO(jdbcURL, jdbcUsername, jdbcPassword);
	}

	public GetSelectedBookServlet() { 
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int id_user = Integer.parseInt(request.getParameter("id"));
			List<String> listBook;
			listBook = book_UserDAO.ShowSelectedBook(id_user);
			request.setAttribute("listBook", listBook);
			RequestDispatcher dispatcher = request.getRequestDispatcher("ShowSelectedBook.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

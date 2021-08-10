package net.codejava.javaee.bookstore;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateSelectedBookServlet")
public class UpdateSelectedBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Book_UserDAO book_UserDAO;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

		book_UserDAO = new Book_UserDAO(jdbcURL, jdbcUsername, jdbcPassword);
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
			// int id_book = Integer.parseInt(request.getParameter("id_book"));
			int[] id_book = new int[100];
			String[] checkbox = request.getParameterValues("checkbox");
			for (int i = 0; i < checkbox.length; i++) {
				if (checkbox[i] != null) {
					id_book[i] = Integer.parseInt(checkbox[i]);

					book_UserDAO.insert_IdBook_IdUser(id_book[i], id_user);

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

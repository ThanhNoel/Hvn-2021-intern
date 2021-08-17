package net.codejava.javaee.bookstore.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.codejava.javaee.bookstore.dao.BookDAO;
import net.codejava.javaee.bookstore.dao.UserDAO;
import net.codejava.javaee.bookstore.model.Book;
import net.codejava.javaee.bookstore.model.User;

/**
 * ControllerServlet.java This servlet acts as a page controller for the
 * application, handling all requests from the user.
 * 
 * @author www.codejava.net
 */
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDAO bookDAO;
	private UserDAO userDAO;
 
	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

		bookDAO = new BookDAO(jdbcURL, jdbcUsername, jdbcPassword);
		userDAO = new UserDAO(jdbcURL, jdbcUsername, jdbcPassword);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			// --User's modules--
			case "/register":
				register(request, response);
				break;
			case "/insertRegisteredUser":
				insertRegisteredUser(request, response);
				break;
			case "/newUser":
				showNewUserForm(request, response);
				break;
			case "/listUser":
				listUser(request, response);
				break;
			case "/insertUser":
				insertUser(request, response);
				break;
			case "/deleteUser":
				deleteUser(request, response);
				break;
			case "/editUser":
				showEditUserForm(request, response);
				break;
			case "/updateUser":
				updateUser(request, response);
				break;
			//-- Book's modules--
			case "/newBook":
				showNewBookForm(request, response);
				break;
			case "/insertBook":
				insertBook(request, response);
				break;
			case "/deleteBook":
				deleteBook(request, response);
				break;
			case "/editBook":
				showEditForm(request, response);
				break;
			case "/updateBook":
				updateBook(request, response);
				break;
			case "/listBook":
				listBook(request, response);
				break;
			case "/logout":
				logout(request, response);
				break;
			default:
				login(request, response);
				break;
			}
		} catch (SQLException | ClassNotFoundException ex) {
			throw new ServletException(ex);
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ClassNotFoundException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		UserDAO userDao = new UserDAO();

		User user = userDao.checkLogin(email, password);
		System.out.println(user.getAge());
		if (user.getRole().equals("reader")) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			System.out.println("reader");
			home(request, response);
		} else if (user.getRole().equals("admin")) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			System.out.println("admin");
			listBook(request, response);
		} 
	}

	private void logout(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
		dispatcher.forward(request, response);
	} 
	private void home(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Book> listBook = bookDAO.listAllBooks();
		request.setAttribute("listBook", listBook);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Home.jsp");
		dispatcher.forward(request, response);
	}

	private void register(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("Register.jsp");
		dispatcher.forward(request, response);
	}

	private void insertRegisteredUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		int age = Integer.parseInt(request.getParameter("age"));
		String date = request.getParameter("date");
		String password = request.getParameter("password");

		User newUser = new User(name, email, age, date, password);
		userDAO.insertRegisteredUser(newUser);
		response.sendRedirect("listUser");
	}

	private void listBook(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Book> listBook = bookDAO.listAllBooks();
		request.setAttribute("listBook", listBook);
		RequestDispatcher dispatcher = request.getRequestDispatcher("BookList.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewBookForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("BookForm.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Book existingBook = bookDAO.getBook(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("BookForm.jsp");
		request.setAttribute("book", existingBook);
		dispatcher.forward(request, response);

	}

	private void insertBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String category = request.getParameter("category");

		Book newBook = new Book(title, author, category);
		bookDAO.insertBook(newBook);
		response.sendRedirect("listBook");
	}

	private void updateBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String category = request.getParameter("category");

		Book book = new Book(id, title, author, category);
		bookDAO.updateBook(book);
		response.sendRedirect("listBook");
	}

	private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		Book book = new Book(id);
		bookDAO.deleteBook(book);
		response.sendRedirect("listBook");

	}

	// -------------------------
	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<User> listUser = userDAO.listAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("UserList.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewUserForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("UserAddForm.jsp");
		dispatcher.forward(request, response);

	}

	private void showEditUserForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User existingUser = userDAO.getUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("UserEditForm.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);

	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		int age = Integer.parseInt(request.getParameter("age"));
		String date = request.getParameter("date");

		User newUser = new User(name, email, age, date);
		userDAO.insertUser(newUser);
		response.sendRedirect("listUser");
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		int age = Integer.parseInt(request.getParameter("age"));
		String date = request.getParameter("date");

		User user = new User(id, name, email, age, date);
		userDAO.updateUser(user);
		response.sendRedirect("listUser");
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		User user = new User(id);
		userDAO.deleteUser(user);
		response.sendRedirect("listUser");

	}

}
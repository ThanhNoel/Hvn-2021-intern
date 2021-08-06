package com.nashtech.intern.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nashtech.intern.dao.IMPL.UserDAO;
import com.nashtech.intern.model.User;

@WebServlet("/")
public class UserServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private UserDAO userDAO;
	
	public void init() throws ServletException {
		userDAO = new UserDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/add":
				addUser(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			case "/modify":
				showEditForm(request, response);
				break;
			default:
				listUser(request, response);
				break;
			}
		} catch (SQLException | ParseException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void listUser(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException{
		List<User> listUsers = userDAO.getAllUser();
		req.setAttribute("listUsers", listUsers);
		RequestDispatcher dispatcher = req.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(req, resp);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User existingUser = userDAO.getUserById(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);

	}
	private void addUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ParseException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		
		String dob = request.getParameter("dob");
		Date dobDate = new SimpleDateFormat("yyyy-mm-dd").parse(dob);
		LocalDate localDob = new java.sql.Date(dobDate.getTime()).toLocalDate();
		LocalDate now = LocalDate.now();
		int age = Period.between(localDob, now).getYears();
		java.sql.Date date_sql = new java.sql.Date(dobDate.getTime());
		
		User newUser = new User(firstName, lastName, age, date_sql, email);
		userDAO.addUser(newUser);
		response.sendRedirect("list");
	}
	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ParseException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		
		String dob = request.getParameter("dob");
		Date dobDate = new SimpleDateFormat("yyyy-mm-dd").parse(dob);
		LocalDate localDob = new java.sql.Date(dobDate.getTime()).toLocalDate();
		LocalDate now = LocalDate.now();
		int age = Period.between(localDob, now).getYears();
		java.sql.Date date_sql = new java.sql.Date(dobDate.getTime());
		
		User newUser = new User(firstName, lastName, age, date_sql, email);
		userDAO.modifyUser(newUser);
		response.sendRedirect("list");
	}

}

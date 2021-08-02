package com.nashtech.intern.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nashtech.intern.dao.UserDAO;
import com.nashtech.intern.model.User;

@WebServlet(urlPatterns = {"/editUser"})
public class EditUserController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		response.setContentType("text/html;charset=UTF-8");
		String IdUser = request.getParameter("idUser");
		User user =new User();
		UserDAO userDAO =new UserDAO();
		session.setAttribute("idUser", Integer.parseInt(IdUser));
		user = userDAO.getUserById(Integer.parseInt(IdUser));
		request.setAttribute("firstName", user.getFirstName());
		request.setAttribute("lastName", user.getLastName());
		request.setAttribute("email", user.getEmail());
		request.setAttribute("dateOfBirth", user.getDateOfBirth());
		
		RequestDispatcher view = request.getRequestDispatcher("/views/editUser.jsp");
		view.forward(request, response);
	}
}

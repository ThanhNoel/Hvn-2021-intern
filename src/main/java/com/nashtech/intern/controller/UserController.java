package com.nashtech.intern.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.nashtech.intern.dao.UserDAO;
import com.nashtech.intern.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/user"})
public class UserController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		List<User> listUser =new ArrayList<User>();
		UserDAO userDao =new UserDAO();
		listUser = userDao.getAllUser();
	
		request.setAttribute("listUser", listUser);
		RequestDispatcher view = request.getRequestDispatcher("/views/listUser.jsp");
		view.forward(request, response);
	}
}

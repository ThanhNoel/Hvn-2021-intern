package com.nashtech.intern.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nashtech.intern.dao.BookDAO;
import com.nashtech.intern.dao.UserDAO;
import com.nashtech.intern.model.Book;
import com.nashtech.intern.model.User;

@WebServlet(urlPatterns = {"/ToUser"})
public class AddBookToUserController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session =request.getSession();
		Book book =new Book();
		BookDAO bookDAO =new BookDAO();
		User user =new User();
		UserDAO userDAO =new UserDAO();
		
		response.setContentType("text/html;charset=UTF-8");
		String idUser = (String) session.getAttribute("IdUser");
		String idBook =request.getParameter("idBook");
		book =bookDAO.getBookById(Integer.parseInt(idBook));
		
		user =userDAO.getUserById(Integer.parseInt(idUser));
		
		book.setIdBook(Integer.parseInt(idBook));
		book.setUser(user);
		
		bookDAO.editBookToUser(book);
		response.sendRedirect("/thuc_tap/user");
	}
}

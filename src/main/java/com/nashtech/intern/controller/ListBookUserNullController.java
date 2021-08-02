package com.nashtech.intern.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nashtech.intern.dao.BookDAO;
import com.nashtech.intern.model.Book;

@WebServlet(urlPatterns = { "/addBookToUser" })
public class ListBookUserNullController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session =request.getSession();
		response.setContentType("text/html;charset=UTF-8");
		String idUser = request.getParameter("idUser");
		session.setAttribute("IdUser", idUser);
		List<Book> listBook = new ArrayList<Book>();
		BookDAO bookDAO = new BookDAO();
		listBook = bookDAO.getAllBookByIdUserNull();
		request.setAttribute("listBook", listBook);
		RequestDispatcher view = request.getRequestDispatcher("/views/listBookUserNull.jsp");
		view.forward(request, response);
	}
}

package com.nashtech.intern.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nashtech.intern.dao.BookDAO;
import com.nashtech.intern.model.Book;


@WebServlet(urlPatterns = {"/editBook"})
public class EditBookController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		response.setContentType("text/html;charset=UTF-8");
		String IdBook = request.getParameter("idBook");
		Book book =new Book();
		BookDAO bookDAO =new BookDAO();
		session.setAttribute("idBook", Integer.parseInt(IdBook));
		book = bookDAO.getBookById(Integer.parseInt(IdBook));
		request.setAttribute("title", book.getTitle());
		request.setAttribute("author", book.getAuthor());
		request.setAttribute("category", book.getCategory());
		RequestDispatcher view = request.getRequestDispatcher("/views/editBook.jsp");
		view.forward(request, response);
	}
}

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

import com.nashtech.intern.dao.BookDAO;
import com.nashtech.intern.model.Book;

@WebServlet(urlPatterns = {"/book"})
public class BookController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		List<Book> listBook =new ArrayList<Book>();
		BookDAO bookDAO = new BookDAO();
		listBook = bookDAO.getAllBook();
		request.setAttribute("listBook", listBook);
		RequestDispatcher view =request.getRequestDispatcher("/views/listBook.jsp");
		view.forward(request, response);
	}
}

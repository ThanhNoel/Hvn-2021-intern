package com.nashtech.intern.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nashtech.intern.dao.BookDAO;
import com.nashtech.intern.model.Book;

@WebServlet(urlPatterns = {"/updateBook"})
public class UpdateBookController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session =request.getSession();
		Book book =new Book();
		BookDAO bookDAO =new BookDAO();
		
		response.setContentType("text/html;charset=UTF-8");
		int idBook =(int) session.getAttribute("idBook");
		String title =request.getParameter("title");
		String author =request.getParameter("author");
		String category =request.getParameter("category");
		
		book.setIdBook(idBook);
		book.setAuthor(author);
		book.setCategory(category);
		book.setTitle(title);
		
		bookDAO.editBook(book);
		response.sendRedirect("/thuc_tap/book");
	}
}

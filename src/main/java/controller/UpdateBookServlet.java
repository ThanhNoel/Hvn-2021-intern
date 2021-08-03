package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO;
import model.Book;

/**
 * Servlet implementation class UpdateBookServlet
 */
@WebServlet("/updatebook")
public class UpdateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BookDAO bookDAO; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBookServlet() {
        super();
        this.bookDAO = new BookDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		int id = Integer.parseInt(request.getParameter("id"));
		Book b = bookDAO.getByID(id);
		request.setAttribute("book", b);
		request.getRequestDispatcher("updatebook.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String category = request.getParameter("category");
		Book b = new Book(title,author,category);
		if(b.checkBook(b.getTitle()) && b.checkBook(b.getAuthor())) {
			bookDAO.updateBook(id,title,author,category);
			response.sendRedirect("book");
		}
		else doGet(request,response);
	}

}

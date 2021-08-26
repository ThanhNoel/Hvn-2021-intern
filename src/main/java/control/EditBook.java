package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import entity.Book;

@WebServlet("/EditBook")
public class EditBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public EditBook() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	
		 	String title = request.getParameter("title");
	        String author = request.getParameter("author");
	        String category = request.getParameter("category");
	        Book b = new Book(title, author,category);
	        DAO bdao = new DAO();
	        
	            try {
					if (bdao.updateBook(b)) {
					    response.sendRedirect("ListBook.jsp");
					} else {
					    response.sendRedirect("error.jsp");
					}
				} catch (ClassNotFoundException | SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        
	}

}

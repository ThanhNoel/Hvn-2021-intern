package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO;
import model.Book;

/**
 * Servlet implementation class AddListBookServlet
 */
@WebServlet("/addlistbook")
public class AddListBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BookDAO bookDAO;
    int user_id;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddListBookServlet() {
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
		List<Book> list = bookDAO.getAllBook();
		request.setAttribute("list", list);
		request.getRequestDispatcher("addlistbook.jsp").forward(request, response);
		user_id =id;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		int book_id = Integer.parseInt(request.getParameter("book_id"));
		bookDAO.addListBook(book_id, user_id);
		response.sendRedirect("user");
	}

}

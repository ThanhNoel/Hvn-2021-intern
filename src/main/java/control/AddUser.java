package control;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import entity.User;
@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AddUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        Date dateofbirth = Date.valueOf(request.getParameter("dateofbirth"));
        Integer iduser = Integer.parseInt(request.getParameter("iduser"));
		User u = new User(fname, lname, email, dateofbirth, iduser);
		DAO udao = new DAO();
		try {
			
			if (udao.addUser(u)) {
				// request.getRequestDispatcher("/home.jsp").forward(request, response);
				response.sendRedirect("ListUser.jsp");
			} else {
				response.sendRedirect("error.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

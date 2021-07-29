package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.coyote.http11.HeadersTooLargeException;

import entity.Account;

/**
 * Servlet implementation class LoginControl
 */
@WebServlet(name="LoginControl", urlPatterns="/LoginControl")
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected  void  processR  (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
    	try {
			String user = request.getParameter("username");
			String pass = request.getParameter("password");
			ConnectMysqlExample cme = new ConnectMysqlExample();
			Account a = cme.checklog(user, pass);
			if(a == null){
				response.sendRedirect("Login.jsp");
			}
			else{
				response.sendRedirect("Success.jsp");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

package test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import net.codejava.javaee.bookstore.dao.UserDAO;
import net.codejava.javaee.bookstore.model.User;

public class ListAllUserTest {
	
	
	@Test
	public void test() throws ClassNotFoundException, SQLException {
		UserDAO userDAO = new UserDAO();
		User user = userDAO.getUser(2);
		assertEquals("Hanh", user.getName());		
	}
}

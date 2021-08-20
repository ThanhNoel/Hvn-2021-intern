package net.codejava.javaee.bookstore.test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Test;

import net.codejava.javaee.bookstore.dao.UserDAO;
import net.codejava.javaee.bookstore.model.User;

public class CheckLoginTest {
        
	@Test
	public void test() throws ClassNotFoundException, SQLException {
		UserDAO userDAO = new UserDAO();
		User user = userDAO.checkLogin("lethihanh@gmail.com", "lethihanh");
		assertEquals("reader", user.getRole());		
	}
}

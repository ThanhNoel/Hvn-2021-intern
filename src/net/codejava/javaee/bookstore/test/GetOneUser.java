package net.codejava.javaee.bookstore.test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import net.codejava.javaee.bookstore.dao.UserDAO;
import net.codejava.javaee.bookstore.model.User;

public class GetOneUser {
	@Test
	public void test() throws ClassNotFoundException, SQLException{
		UserDAO userDAO = new UserDAO("jdbc:mysql://localhost:3306/bookstore","root", "030699");
		User user = userDAO.getUser(2);
		assertEquals("Hanh", user.getName());		
	}
}

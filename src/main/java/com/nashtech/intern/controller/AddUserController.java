package com.nashtech.intern.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nashtech.intern.dao.UserDAO;
import com.nashtech.intern.model.User;

@WebServlet("/addUser")
public class AddUserController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String email = request.getParameter("email");
		String dateOfBirth = request.getParameter("dob");
		Date date=null;
		int age;
		int year = Calendar.getInstance().get(Calendar.YEAR);
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(dateOfBirth);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		String[] parts =dateOfBirth.split("-");
		String part1 = parts[0];
		
		int year_part1 = Integer.parseInt(part1);
		age = year - year_part1;

		java.sql.Date date_sql = new java.sql.Date(date.getTime());
		
		User user = new User();
		user.setAge(age);
		user.setDateOfBirth(date_sql);
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		
		UserDAO userDAO =new UserDAO();
		userDAO.addUser(user);
		response.sendRedirect("/thuc_tap/user");
	}

}

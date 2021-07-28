package com.nashtech.intern.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long userId;
	private String firstName;
	private String lastName;
	private int age;
	private String email;

	private List<Book> books;

	public User() {
		firstName = "";
		lastName = "";
		email = "";
		books = new ArrayList<>();
	}

	public void setBooks(List<Book> lineBook) {
		books = lineBook;
	}

	public List<Book> getBooks() {
		return books;
	}

	public int getQuantity() {
		return books.size();
	}

	public void addBook(Book book) {
		books.add(book);
	}

	public void removeBook(Book book) {
		for (int i = 0; i < books.size(); i++) {
			Book removeBook = books.get(i);
			if (book.getBookId() == removeBook.getBookId()) {
				books.remove(i);
				return;
			}
		}
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}

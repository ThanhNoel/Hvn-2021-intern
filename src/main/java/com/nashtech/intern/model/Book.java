package com.nashtech.intern.model;

public class Book {

	private int IdBook;
	private String title;
	private String author;
	private String category;
	private User user;
	
	public Book(int idBook, String title, String author, String category, User user) {
		IdBook = idBook;
		this.title = title;
		this.author = author;
		this.category = category;
		this.user = user;
	}

	public Book(int idBook, String title, String author, String category) {
		IdBook = idBook;
		this.title = title;
		this.author = author;
		this.category = category;
	}

	public Book() {
	
	}

	public int getIdBook() {
		return IdBook;
	}

	public void setIdBook(int idBook) {
		IdBook = idBook;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}

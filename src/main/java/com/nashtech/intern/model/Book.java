package com.nashtech.intern.model;

import java.io.Serializable;

public class Book implements Serializable{

	private static final long serialVersionUID = -7770001811935134708L;

	private Long bookId;
	
	
	private String title;
	
	
	private String author;
	
	
	private String category;

	private Long userId;

	public Book() {
		super();
	}

	public Book(String title, String author, String category) {
		super();
		this.title = title;
		this.author = author;
		this.category = category;
	}

	public Book(Long bookId, String title, String author, String category, Long userId) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.category = category;
		this.userId = userId;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}

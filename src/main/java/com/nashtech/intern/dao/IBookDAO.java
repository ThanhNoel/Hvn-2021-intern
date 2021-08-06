package com.nashtech.intern.dao;

import java.util.List;

import com.nashtech.intern.model.Book;

public interface IBookDAO {
	public List<Book> getAllBooks();
	public Book getBookById(int bookId);
	public List<Book> getBooksByUser(int userId);
	public List<Book> getBooksByUserNull();
	public void addBook(Book book);
	public boolean modifyBook(Book book);
	public void addUserBorrowBook();
}

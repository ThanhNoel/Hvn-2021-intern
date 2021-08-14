package net.codejava.javaee.bookstore.model;
 
/**
 * Book.java
 * This is a model class represents a book entity
 * @author www.codejava.net
 *
 */
public class Book {
    protected int id;
    protected String title; 
    protected String author;
    protected String category;
 
    public Book() {
    }
 
    public Book(int id) {
        this.id = id;
    }
 
    public Book(int id, String title, String author, String category) {
        this(title, author, category);
        this.id = id;
    }
     
    public Book(String title, String author, String category) {
        this.title = title;
        this.author = author;
        this.category = category;
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
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
 
    
}
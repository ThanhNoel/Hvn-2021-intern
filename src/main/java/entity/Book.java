package entity;

public class Book {
	private int idbook;
	private String title;
	private String author;
	private String category;
	
	public Book(String title,String author, String category, int idbook) {
		this.title = title;
		this.author = author;
		this.category = category;
		this.idbook = idbook;
		}
	public Book(String title,String author, String category) {
		this.title = title;
		this.author = author;
		this.category = category;
		
		}
	public Book() {
		
	}
	public int getIdbook() {
		return idbook;
	}
	public void setIdbook(int idbook) {
		this.idbook = idbook;
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

package entity;

public class Books {
	private int id;
 
private String title;
  private String author;
  private String category;
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
public Books(int id, String title, String author, String category) {
	super();
	this.id = id;
	this.title = title;
	this.author = author;
	this.category = category;
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
public Books(String title, String author, String category) {
	super();
	this.title = title;
	this.author = author;
	this.category = category;
}
  
  
}

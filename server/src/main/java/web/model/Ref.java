package web.model;

public class Ref {
	private int user_id;
	private int books_id;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getBooks_id() {
		return books_id;
	}
	public void setBooks_id(int books_id) {
		this.books_id = books_id;
	}
	@Override
	public String toString() {
		return "Ref [user_id=" + user_id + ", books_id=" + books_id + "]";
	}
	
	
}

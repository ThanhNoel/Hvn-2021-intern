package net.codejava.javaee.bookstore;

public class User {
	protected int id;
	protected String name;
	protected String email;
	protected int age;
	protected String date;

	public User() {
		super();
	}

	public User(int id) {
		super();
		this.id = id;
	}

	public User(int id, String name, String email, int age, String date) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = age;
		this.date = date;
	}

	public User(String name, String email, int age, String date) {
		super();
		this.name = name;
		this.email = email;
		this.age = age;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}

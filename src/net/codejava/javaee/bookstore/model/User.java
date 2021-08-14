package net.codejava.javaee.bookstore.model;

public class User {
	protected int id;
	protected String name;
	protected String email;
	protected int age;
	protected String date;
	protected String password;
	protected String role;

	public User() {
		super(); 
	}

	public User(int id) {
		super();
		this.id = id;
	}


	public User(int id, String name, String email, int age, String date, String role) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = age;
		this.date = date;
		this.role = role;
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
	

	public User(String name, String email, int age, String date, String password) {
		super();
		this.name = name;
		this.email = email;
		this.age = age;
		this.date = date;
		this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}

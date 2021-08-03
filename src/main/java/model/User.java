package model;

import java.sql.Date;


public class User{
	private int id;
	
	private String firstName;
	private String lastName;
	private String email;
	private Date dob;
	private int age;
	public User() {
	}
	public User(String firstName, String lastName, String email, Date dob, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dob = dob;
		Date now = new Date(System.currentTimeMillis());
		int tmp = now.getYear() - dob.getYear() ; 
		this.age = tmp;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public int getAge() {
		Date now = new Date(System.currentTimeMillis());
		int tmp = now.getYear() - dob.getYear() ; 
		return tmp;
	}
	public void setAge(int age) {
		Date now = new Date(System.currentTimeMillis());
		int tmp = now.getYear() - dob.getYear() ; 
		this.age = tmp;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", dob="
				+ dob + ", age=" + age + "]";
	}
	
	public boolean checkUserName(String str) {
		return ((!str.equals(""))&& (str != null)&& (str.matches("^[a-zA-Z]*$")));
	}
	public boolean checkUserEmail(String str) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	    return str.matches(regex);
	}
	public boolean checkAge(int a) {
		return a>0 && a<=120;
	}
}

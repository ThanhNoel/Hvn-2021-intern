package com.nashtech.intern.model;

import java.util.Date;

public class User {

	private int IdUser;
	private String firstName;
	private String lastName;
	private int age;
	private Date dateOfBirth;
	private String email;
	
	public User() {
	}


	public User(int idUser, String firstName, String lastName, int age, Date dateOfBirth, String email) {
		super();
		IdUser = idUser;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
	}

	public int getIdUser() {
		return IdUser;
	}

	public void setIdUser(int idUser) {
		IdUser = idUser;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}

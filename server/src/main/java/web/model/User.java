package web.model;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import lombok.*;
@Data
@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Pattern(regexp="^[A-Za-z]*$")
	private String firstName;
	@Pattern(regexp="^[A-Za-z]*$")
	private String lastName;
	@Email
	private String email;
	private Date dob;
	@Min(1)
	@Max(120)
	private int age;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(int id, String firstName, String lastName, String email, Date dob, int age) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dob = dob;
		Date now = new Date(System.currentTimeMillis());
		this.age = now.getYear()- dob.getYear();
	}


	
	
}

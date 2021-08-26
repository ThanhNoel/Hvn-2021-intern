package entity;

import java.sql.Date;
import java.util.Calendar;



public class User {
	private String fname;
	private String lname;
	private String email;
	private Date dateofbirth;
	private int age;
	private int iduser;
	
	public User(String fname, String lname, String email, int age, Date dateofbirth, int iduser) {
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.age =age;
		this.dateofbirth = dateofbirth;
		this.iduser=iduser;
	}
	public User (String fname, String lname, String email, Date dateofbirth, int iduser) {
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.dateofbirth = dateofbirth;
		this.iduser = iduser;
	}
	public User() {
		
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		Calendar today = Calendar.getInstance();
	    Calendar birthDate = Calendar.getInstance();

	    int age = 0;

	    birthDate.setTime(dateofbirth);
	    if (birthDate.after(today)) {
	        throw new IllegalArgumentException("Can't be born in the future");
	    }

	    age = today.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);

	    if ( (birthDate.get(Calendar.DAY_OF_YEAR) - today.get(Calendar.DAY_OF_YEAR) > 3) ||
	            (birthDate.get(Calendar.MONTH) > today.get(Calendar.MONTH ))){
	        age--;

	   
	    }else if ((birthDate.get(Calendar.MONTH) == today.get(Calendar.MONTH )) &&
	              (birthDate.get(Calendar.DAY_OF_MONTH) > today.get(Calendar.DAY_OF_MONTH ))){
	        age--;
	    }

	    return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public int getIduser() {
		return iduser;
	}
	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
	
	
}

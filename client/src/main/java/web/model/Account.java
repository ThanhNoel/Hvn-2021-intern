package web.model;

public class Account {
	private int id;
	private String userName;
	private String passWord;
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account( String userName, String passWord) {
		super();
		this.userName = userName;
		this.passWord = passWord;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
}

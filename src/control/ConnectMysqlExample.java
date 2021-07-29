package control;
 
import java.sql.*;

import entity.Account;
 
public class ConnectMysqlExample {
    private static String DB_URL = "jdbc:mysql://localhost:3306/logindefault";
    private static String USER_NAME = "root";
    private static String PASSWORD = "123456";
 
    /**
     * main
     * 
     * @author viettuts.vn
     * @param args
     */
    public Account checklog(String user, String pass){
    	try {
    		String query ="SELECT * FROM logindefault.login where username =? and pass =?";
			Connection cnn = getConnection(DB_URL, USER_NAME, PASSWORD);
			PreparedStatement pr = cnn.prepareStatement(query);
			pr.setString(1, user);
			pr.setString(2, pass);
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				Account a =new Account(rs.getString(1),rs.getString(2));
				return a;
			}
			
    	} catch (Exception e) {
		}
		return null;
    }
 
 
    /**
     * create connection 
     * 
     * @author viettuts.vn
     * @param dbURL: database's url
     * @param userName: username is used to login
     * @param password: password is used to login
     * @return connection
     */
    public static Connection getConnection(String dbURL, String userName, 
            String password) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }
}
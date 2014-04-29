package deneme;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbconnect {
	
	public static Connection conect() {
	    Connection con = null;
	    String url = "jdbc:mysql://localhost:3306/";
	    String db = "etest";
	    String driver = "com.mysql.jdbc.Driver";
	    String user = "root";
	    String pass = "";
	    try {
	        Class.forName(driver);
	        con = DriverManager.getConnection(url + db, user, pass);
	        if (con == null) {
	            System.out.println("Connection cannot be established");
	        }
	        return con;
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	    return null;
	}
}
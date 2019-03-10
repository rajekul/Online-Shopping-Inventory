package xshop.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connectdb{
	
	public Connection getConn(){
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopdb", "root", "");
		}catch(Exception e){
			
		}
		return con;
	}
}
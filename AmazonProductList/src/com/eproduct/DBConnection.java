/**
 * 
 */
package com.eproduct;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author sharon_dias
 *
 */
public class DBConnection {
	
	public final static String url = "jdbc:mysql://localhost:3306/amazonproducts";
	public final static String username = "root";
	public final static String password = "oracle";
	
	private Connection con;
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url,username,password);
		return con;
	}
	
	public void closeConnection() throws ClassNotFoundException, SQLException {
		if(con != null) {
			con.close();
		}
	}

}

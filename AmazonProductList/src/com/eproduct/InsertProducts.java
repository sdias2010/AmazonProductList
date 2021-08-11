/**
 * 
 */
package com.eproduct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.WebElement;

/**
 * @author sharon_dias
 * 
 * This class inserts the products in the database.
 *
 */
public class InsertProducts {
	
	private Connection con;
		
	public InsertProducts(Connection con) {
		super();
		this.con = con;
	}

	public void getInsertProducts(List<WebElement> listofproducts) throws ClassNotFoundException, SQLException {
		
		int p = 0;
		String sql = "insert into eproduct(ProductName) values(?)";
		PreparedStatement ps = con.prepareStatement(sql);
		
		for(int i=0; i<listofproducts.size(); i++) {
			String productname = listofproducts.get(i).getText();
			ps.setString(1, productname);			
			p = ps.executeUpdate();						
		}
		if(p != 0) {
			System.out.println("Products Inserted Successfully!!");
		}else {
			System.out.println("No Products Found!!");
		}
		ps.close();
				
	}

}

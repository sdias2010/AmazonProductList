/**
 * 
 */
package com.eproduct;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.WebElement;

/**
 * @author sharon_dias
 * This class compares the expected results with actual results.
 *
 */
public class TestResultsComparison {
	
	public void compareResults(List<WebElement> listofproducts, DBConnection dbcon) throws SQLException, ClassNotFoundException {
		
		String expectedproductname="";
		String actualproductname;
		boolean status = false;
		
		for(int i=0; i<listofproducts.size(); i++) {
			expectedproductname = listofproducts.get(i).getText();
			
			String sql = "select ProductName from eproduct";
			PreparedStatement ps = dbcon.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				actualproductname = rs.getString(1);
				
				if(actualproductname.equals(expectedproductname)) {
					System.out.println("Test have passed");
					status = true;
					break;
				}
			}
			
			if(status==false) {
				System.out.println("testcase failed");
			}
			
			ps.close();
			rs.close();
		}
	}

}

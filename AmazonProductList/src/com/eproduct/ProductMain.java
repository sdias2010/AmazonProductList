/**
 * 
 */
package com.eproduct;

import java.sql.SQLException;
import java.util.List;
import org.openqa.selenium.WebElement;

/**
 * @author sharon_dias
 *
 */
public class ProductMain {

	/**
	 * @param args
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		WebDriverConnection webdriver = new WebDriverConnection();
		
		DBConnection dbcon = new DBConnection();
		
		RetrieveProducts retrieveproduct = new RetrieveProducts(webdriver.Setup());
		
		InsertProducts insertproduct = new InsertProducts(dbcon.getConnection());
				
		List<WebElement> listofproducts = retrieveproduct.getProducts();
		
		insertproduct.getInsertProducts(listofproducts);
		
		TestResultsComparison results = new TestResultsComparison();
		
		results.compareResults(listofproducts, dbcon);
		
		webdriver.Closewebconnection();
		
		dbcon.closeConnection();
		
		

	}

}

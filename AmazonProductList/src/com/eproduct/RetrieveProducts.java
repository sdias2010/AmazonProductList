/**
 * 
 */
package com.eproduct;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author sharon_dias
 * 
 * This class retrieves the products from the web page.
 *
 */
public class RetrieveProducts {
	
	private WebDriver driver;
		
	public RetrieveProducts(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public List<WebElement> getProducts() {
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("smart watch");
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		
		//taking all product names for the search on that page using the particular tag.
		List<WebElement> productname_list = driver.findElements(By.xpath(".//span[@class='a-size-medium a-color-base a-text-normal']"));
		
		return productname_list;		
	}

}

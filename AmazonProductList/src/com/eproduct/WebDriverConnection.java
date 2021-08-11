/**
 * 
 */
package com.eproduct;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author sharon_dias
 *
 */
public class WebDriverConnection {
	
	private WebDriver driver;

	public WebDriver Setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\Java\\selenium-java\\chromedriver.exe");
		driver = new ChromeDriver();
		return driver;		
	}
	public void Closewebconnection() {
		driver.quit();
	}

}

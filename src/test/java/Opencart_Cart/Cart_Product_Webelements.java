package Opencart_Cart;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;



public class Cart_Product_Webelements {
	public static WebDriver driver; 
	
	By MacBook = By.xpath("//a[contains(text(),'MacBook')]"); 
	
	 
	//Constructor
	public Cart_Product_Webelements(WebDriver driver) {
		this.driver=driver;  
	}
	
	//Page Methods
	public void selectMackBook() {
		driver.findElement(MacBook).click();

	}
}

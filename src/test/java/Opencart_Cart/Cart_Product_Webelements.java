package Opencart_Cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cart_Product_Webelements {
	public static WebDriver driver; 
	
	By MacBook = By.xpath("//a[contains(text(),'MacBook')]"); 
	
	 
	//Constructor
	public Cart_Product_Webelements(WebDriver product) {
		this.driver=product; 
	}
	
	//Page Methods
	public void selectMackBook() {
		driver.findElement(MacBook).click(); 
	}

}

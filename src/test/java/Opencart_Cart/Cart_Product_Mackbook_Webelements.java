package Opencart_Cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Cart_Product_Mackbook_Webelements {
	public static WebDriver driver; 

   By quantity = By.name("quantity"); 
	
	By AddtoCart = By.id("button-cart"); 
	
	By checkSuccessMessage = By.xpath("/html[1]/body[1]/div[2]/div[1]"); 
	
	By Cart=By.xpath("//header/div[1]/div[1]/div[3]/div[1]/button[1]"); 
	
	By ViewCart = By.xpath("//body[1]/header[1]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[2]/div[1]/p[1]/a[1]/strong[1]"); 
	
	
	//constructor
	public Cart_Product_Mackbook_Webelements(WebDriver MackBook) {
		this.driver=MackBook; 
	}
	
	//Page Method
	public void assertionAddtoCart() throws Exception {
		
		String actualaddtocart=driver.findElement(By.id("button-cart")).getText();
		String expectedaddtocart = "Add to Cart"; 
		
		//Asssertion of Expectedaddtocart, Actualaddtocart
		
		Assert.assertEquals(expectedaddtocart , actualaddtocart ); 
		Thread.sleep(2000); 
		System.out.println("The product has been moved to Add to Cart Page");
	}
	 
	public void enterquantity(String string) {
		driver.findElement(quantity).clear();

		driver.findElement(quantity).sendKeys(string);
	}
	
	public void clickAddtoCart() {
		driver.findElement(AddtoCart).click();  
		
		Boolean SuccessMessage= driver.findElement(checkSuccessMessage).isDisplayed(); 
		String SuccessMessagevalue = driver.findElement(checkSuccessMessage).getText(); 
		
		if(SuccessMessage == true) {
			System.out.println("Success Message : " );
		}else {
			System.out.println("error Message : " );
		}
		
	}
	
	
	public void clickCart() throws Exception {
		Thread.sleep(2000); 
		driver.findElement(Cart).click(); 
		
	}
	
	public void clickViewCart() throws Exception {
		Thread.sleep(2000); 
		driver.findElement(ViewCart).click(); 

	}
	
	

	

	
}

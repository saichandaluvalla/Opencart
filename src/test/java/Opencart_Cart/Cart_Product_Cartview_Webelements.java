package Opencart_Cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Cart_Product_Cartview_Webelements {
	public static WebDriver driver; 
	
	By MackBooksPrice = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[6]"); 
	
	By editQuantity=By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"); 
	
	By generate = By.xpath("//tbody/tr[1]/td[4]/div[1]/span[1]/button[1]"); 
	
	By ErrorMessage = By.xpath("//body/div[@id='checkout-cart']/div[1]"); 
	
	
	//Construtor
	public Cart_Product_Cartview_Webelements(WebDriver CartView) {
		this.driver= CartView; 
	}
	
	
	
	public void checkMackbookPrice() throws Exception {
		 String Price =	driver.findElement(MackBooksPrice).getText(); 
		String ActualPrice = "$1,204.00"; 
		 System.out.println("Total Price : " +Price);
			Thread.sleep(2000);  
	  
			Assert.assertEquals(Price, ActualPrice) ; 
		 
			 System.out.println("2MackBooks are added to the cart and Price is : " +Price);
		
		}
	
	public void enterInvalidQuantity(String editquantity) {
		driver.findElement(editQuantity).sendKeys(editquantity); 
	}

	public void clickGenerate() {
		driver.findElement(generate).click(); 
	}

	public void checkError() {
		String ActualErrorMessage =driver.findElement(ErrorMessage).getText(); 
		String ExpectedErrorMessage = "You have entered Incorrect number"; 
		
   if(ActualErrorMessage == ExpectedErrorMessage ) { 
	   System.out.println("Error Message is Correct : " +ActualErrorMessage);
   } else {
	   System.out.println("*****Error Message is not showing *******" );  
   }
	
	}

	
	

}

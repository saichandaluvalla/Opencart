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
	
	By removeproduct = By.xpath("//tbody/tr[1]/td[4]/div[1]/span[1]/button[2]"); 
	
	By MessageafterRemove = By.cssSelector("body:nth-child(2) div.container:nth-child(4) div.row div.col-sm-12 > p:nth-child(2)"); 
	
	
	//Construtor
	public Cart_Product_Cartview_Webelements(WebDriver driver) {
		this.driver= driver; 
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
		
    Assert.assertEquals("ActualErrorMessage", "ExpectedErrorMessage");  
    
	} 
	public void clickremoveproduct() {
		driver.findElement(removeproduct).click(); 
		
		String ActualMessage=driver.findElement(MessageafterRemove).getText(); 
		String ExpectedMessage="Your shopping cart is empty!"; 
		
		System.out.println("MessageafteRemove : " +ActualMessage);
		if(ActualMessage == ExpectedMessage) {
			System.out.println("Product has been removed from the cart");
		} else {
			System.out.println("Product has not been removed from the cart");
			
		}
		
	}

	
	

}

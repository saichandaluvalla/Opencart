package Opencart_Cart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class Opencart_Cart_Test {
  
	WebDriver driver; 
	
	@BeforeMethod
	public void openbrowser() { 
  
 
       System.setProperty("webdriver.chrome.driver", "C:/Testing/Automation/Live_OpencartNEW/UpdateDrivers/chromedriver.exe");
		
		ChromeOptions options=new ChromeOptions(); 
		options.addArguments("--remote-allow-origins=*"); 
		
		driver=new ChromeDriver(options); 
		 
		
		
		driver.get("http://localhost/opencart/upload/");  
		
		}
	 
	 
	@Test 
	public void addMackbook_to_cart() throws Exception {
		
		System.out.println("Opencart application has been Opened");
		Thread.sleep(2000);  
		
		
		Cart_Product_Webelements CPW=new Cart_Product_Webelements(driver);
		CPW.selectMackBook(); 
		  
		  
		 
		  
		 
		Cart_Product_Mackbook_Webelements CPMW=new Cart_Product_Mackbook_Webelements(driver);
		CPMW.assertionAddtoCart();  
		CPMW.enterquantity("2");  
		CPMW.clickAddtoCart();  
		CPMW.clickCart();      
		CPMW.clickViewCart(); 
		
		
		Cart_Product_Cartview_Webelements CPCW=new Cart_Product_Cartview_Webelements(driver); 
		CPCW.checkMackbookPrice();   
		CPCW.enterInvalidQuantity("2*");  
		CPCW.clickGenerate(); 
		CPCW.checkError(); 
		
	}
	
	@AfterMethod
	public void closebrowser() throws InterruptedException {
		Thread.sleep(5000); 
		driver.quit(); 
	}
}

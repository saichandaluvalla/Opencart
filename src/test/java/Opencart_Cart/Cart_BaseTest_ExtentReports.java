package Opencart_Cart;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult; 
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod; 
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
 
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
 
public class Cart_BaseTest_ExtentReports {
	static WebDriver driver; 
    ExtentReports extent;
    ExtentTest test;
    Cart_Product_Webelements CPW; 
    Cart_Product_Mackbook_Webelements CPMW; 
    Cart_Product_Cartview_Webelements CPCW; 
    

    @BeforeClass 
    public void setUp() {
        // Initialize the extent report    
        extent = new ExtentReports("test-output/OpencartQuantityTestReport.html");  

        // Initialize the WebDriver
        System.setProperty("webdriver.chrome.driver", "C:/Testing/Automation/Live_OpencartNEW/UpdateDrivers/chromedriver.exe");
		
		ChromeOptions options=new ChromeOptions(); 
		options.addArguments("--remote-allow-origins=*"); 
		 
		driver=new ChromeDriver(options); 
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
   
 
        // Initialize the page objects 
        CPW=new Cart_Product_Webelements(driver);
        
         CPMW=new Cart_Product_Mackbook_Webelements(driver);
        
        CPCW=new Cart_Product_Cartview_Webelements(driver); 
		

    } 
    
    @Test (testName= "addMackbook_to_cart", priority = 1)
	public void addMackbook_to_cart() throws Exception {  
		 
	    driver.get("http://localhost/opencart/upload/");  

		System.out.println("Opencart application has been Opened");
		Thread.sleep(2000);  
		 
		 
		CPW.selectMackBook(); 
		   
		   
		 //Add the MackBook with quantity 2 to the cart
		CPMW.assertionAddtoCart();    
		
		

		CPMW.enterquantity("2");  
		CPMW.clickAddtoCart();   
		CPMW.clickCart();      
		CPMW.clickViewCart();     
		
    } 
    
    @Test(testName= "AddMackbook_to_cart2", priority = 2) 
    public void AddMackbook_to_cart2() throws Exception {
	     
		
		//Edit the qauntity with Invalid number (2*)
		CPCW.checkMackbookPrice();   

		CPCW.enterInvalidQuantity("2*");  
		CPCW.clickGenerate(); 
		CPCW.checkError();  
		
		//Click remove product from the cart  
		CPCW.clickremoveproduct();
		 
		 
	 
	}  
    
    
	
    @AfterClass
    public void tearDown() throws IOException {
    	
    	test= extent.startTest("Positive Quantity Test", "This is Quantity Test in Validy test level"); 
        extent.addSystemInfo("Host name", "Saichand Aluvala");
        extent.addSystemInfo("Username", "Saichand A");

        
        test.log(LogStatus.INFO, "Entering Valid Quantity");
    		test.log(LogStatus.PASS, "Quantity 2 is Valid"); 
    		test.assignAuthor( "Haneesh Aluvala");  

    		
    	   test= extent.startTest("Negative Quantity Test", "This is Quantity Test in InValidy test level"); 
    		test.log(LogStatus.INFO, "Entering Invalid Quantity");  
    		test.log(LogStatus.FAIL, "Quantity 2* is Invalid"); 
    	    test.assignAuthor( "Saichand Aluvala"); 
    	    
        
        
        // Quit the WebDriver
        driver.quit();  

        // Flush the extent report
        extent.flush(); 
        
        Desktop.getDesktop().browse(new File("test-output/OpencartQuantityTestReport.html").toURI()); 
        
    }

    public void logTestStatus(String testStatus, String message) {
        if (testStatus.equals("pass")) {
            test.log(LogStatus.PASS, message);
        } else if (testStatus.equals("fail")) {
            test.log(LogStatus.FAIL, message); 
        } else {
            test.log(LogStatus.SKIP, message); 
        }
    } 
    
    
  //Screenshot in Test Level
    
    //Screenshot for failed testcases
    public static String screenshotforFailedtestcases(String filename) {  
        
 	    //Screenshot of the failed test cases
 			File f= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
 			
 			try {
 				FileHandler.copy(f, new File ("C:/Testing/Automation/Live_OpencartNEW/test-output/Screenshots"  + filename));
 			} catch (IOException e) { 
 				e.printStackTrace(); 
 			}
 	     	System.out.println("Failed testcase Screenshot  saved successfully");
			return filename;  
 		}
    
    
    //Screenshhot for passed testcases 
      public static String screenshotforPassedtestcases(String filename) {  
        
 	    //Screenshot of the failed test cases
 			File f= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
 			
 			try {
 				FileHandler.copy(f, new File ("C:/Testing/Automation/Live_OpencartNEW/test-output/Screenshots"  + filename));
 			} catch (IOException e) { 
 				e.printStackTrace(); 
 			}
 	     	System.out.println("Passed testcase Screenshot  saved successfully");
			return filename; 
 		}
    
}









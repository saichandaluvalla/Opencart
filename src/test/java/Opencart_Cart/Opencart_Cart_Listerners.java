package Opencart_Cart;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class Opencart_Cart_Listerners extends Cart_BaseTest_ExtentReports implements ITestListener {

	public void onTestSuccess(ITestResult tr) {
		System.out.println("Test is Success"); 
        System.out.println(tr.getMethod().getMethodName());
        screenshotforPassedtestcases(tr.getMethod().getMethodName()+".jpg");
		 
	} 

	

	public void onTestFailure(ITestResult tr) {
		System.out.println("Test is Failed");
		System.out.println(tr.getMethod().getMethodName());
		screenshotforFailedtestcases(tr.getMethod().getMethodName()+".jpg");
		
		
 
	}

	

	public void onTestSkipped(ITestResult tr) {
		System.out.println("Test is Skipped");

	} 

	public void onTestStart(ITestResult tr) {
		System.out.println("Test is Started");

	}
	
 
}

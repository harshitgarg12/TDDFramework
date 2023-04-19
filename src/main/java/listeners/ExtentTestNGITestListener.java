package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import base.BaseClass;
import helper.Utility;

public class ExtentTestNGITestListener implements ITestListener{

	ExtentReports extent=ExtentManager.getInstance();
	
	ThreadLocal<ExtentTest> parentTest=new ThreadLocal<ExtentTest>();
	
	 public void onTestStart(ITestResult result) 
	 {
		ExtentTest extentTest= extent.createTest(result.getMethod().getMethodName());
		parentTest.set(extentTest);
	 }
	 public void onTestSuccess(ITestResult result) 
	 {
		 WebDriver driver=BaseClass.getDriverInstance();
		 String screenshot= Utility.createScreenshotFromBase64(driver);
		 parentTest.get().pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
		 
	 }
	  public void onTestFailure(ITestResult result) 
	  {
		  WebDriver driver=BaseClass.getDriverInstance();
		 String screenshot= Utility.createScreenshotFromBase64(driver);
		 
		 parentTest.get().fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());	  
	  }
	  
	  public void onTestSkipped(ITestResult result)
	  {
		  WebDriver driver=BaseClass.getDriverInstance();
			 String screenshot= Utility.createScreenshotFromBase64(driver);
		 parentTest.get().skip("Test Skipped",  MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
		 
	  }
	 
	  public void onFinish(ITestContext context)
	  {
		 extent.flush();    
		 
	  }
	
}

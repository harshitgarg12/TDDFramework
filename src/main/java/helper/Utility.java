package helper;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Utility {
	
	public static void waitForSeconds(int seconds)
	{
		try 
		{
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) 
		{
		
		}
	}

	public static String createScreenshotFromBase64(WebDriver driver)
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		String screenshot=ts.getScreenshotAs(OutputType.BASE64);
		return screenshot;
	}
	
	public static String getCurrentTime()
	{
		String time=new SimpleDateFormat("HH_mm_ss_dd_MM_yyyy").format(new Date());
		return time;
	}
	
	public static void clickElement(WebDriver driver, By locator)
	{
		try 
		{
			driver.findElement(locator).click();
		} catch (Exception e) {
			
			try {
				System.out.println("Trying with actions class click");
				Actions act=new Actions(driver);
				act.moveToElement(driver.findElement(locator)).click().build().perform();
			} catch (Exception e1) {
				
				System.out.println("Trying with JS Click");
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("arguments[0].click()", driver.findElement(locator));
			}
			
		}
		
	}}

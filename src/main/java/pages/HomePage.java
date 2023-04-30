package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import helper.Utility;


public class HomePage {
	
	WebDriver driver;
	
	By manage=By.xpath("//span[text()='Manage']");
	By manageCourses=By.xpath("//a[text()=' Manage Courses']");
	By delete=By.xpath("//td[text()='Selenium Using Java']//following::button");
	By sideButton=By.xpath("(//*[name()='svg'])[4]");
	By signOut=By.xpath("//button[text()='Sign out']");
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void manageCourses()
	{
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(manage)).perform();
		driver.findElement(manageCourses).click();
	}

	public void deleteCourse()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", driver.findElement(delete));
		//driver.findElement(delete).click();
		Utility.waitForSeconds(2);
	}
	
	public void signOut()
	{
		driver.findElement(sideButton).click();
		Utility.waitForSeconds(1);
		driver.findElement(signOut).click();
	}
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import helper.Utility;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By manage=By.xpath("//span[text()='Manage']");
	By manageCourses=By.xpath("//a[contains(text(),'Manage Courses')]");
	
	By delete=By.xpath("//button[text()='Delete']");
	By cart=By.xpath("//button[text()='Cart']");
	By sideButton=By.xpath("(//*[name()='svg'])[4]");
	By signOut=By.xpath("//button[text()='Sign out']");
	

	
	public void manageCourses()
	{
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(manage)).build().perform();
		driver.findElement(manageCourses).click();
		
	}
	
	public void deleteCourse()
	{
		driver.findElement(delete).click();	
		Utility.waitForSeconds(2);
	}
	
	public void signOut()
	{
		driver.findElement(sideButton).click();
		driver.findElement(signOut).click();
	}
}

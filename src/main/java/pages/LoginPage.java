package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helper.Utility;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By email=By.id("email1");
	By password=By.id("password1");
	By button=By.xpath("//button[text()='Sign in']");
	
	public void loginToApplication(String uId, String pass)
	{
		driver.findElement(email).sendKeys(uId);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(button).click();
		Utility.waitForSeconds(2);
			}
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;
	
	By email=By.id("email1");
	By password=By.id("password1");
	By signin=By.xpath("//button[text()='Sign in']");
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void loginToApplication(String UserId, String pass)
	{
		driver.findElement(email).sendKeys(UserId);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(signin).click();
	}
}

package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseClass;
import dataProvider.CustomDataProvider;
import pages.LoginPage;

public class LoginTest extends BaseClass
{
	@Test(dataProvider = "loginDetails", dataProviderClass = CustomDataProvider.class)
	public void loginToApplication(String userId, String password) 
	{
		LoginPage login =new LoginPage(driver);
		login.loginToApplication(userId, password);
		
		Assert.assertTrue(driver.findElement(By.xpath("//button[text()='Cart']")).isDisplayed());	
	}
	
}
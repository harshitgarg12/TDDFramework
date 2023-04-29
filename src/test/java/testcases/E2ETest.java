package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import dataProvider.CustomDataProvider;
import pages.AddCoursePage;
import pages.HomePage;
import pages.LoginPage;

public class E2ETest extends BaseClass{
	
	//Login Test
	@Test(dataProvider = "loginDetails", dataProviderClass =CustomDataProvider.class, priority = 1)
	public void loginToApplication(String email, String password)
	{
		LoginPage login=new LoginPage(driver);
		login.loginToApplication(email,password);
		Assert.assertTrue(driver.findElement(By.xpath("//button[text()='Cart']")).isDisplayed());
	}
	
	//Manage Test
	@Test(priority = 2)
	public void manageCourses()
	{
		HomePage home=new HomePage(driver);
		home.manageCourses();
	}
	
	//Add New Course Test
	@Test(dataProvider = "courseDetails", dataProviderClass = CustomDataProvider.class, priority = 3)
	public void addNewCourse(String file, String courseName, String description, String instructor, String price,
			String category, String startDate, String endDate, String startMonth, String endMonth)
	{
		AddCoursePage add=new AddCoursePage(driver);
		add.addNewCourse(file,courseName,description,instructor,price,category,startDate,endDate,startMonth,endMonth);
		Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Selenium Using Java']")).isDisplayed());
	}
	
	
	//Delete Course Test
	@Test(priority = 4)
	public void deleteCourse()
	{
		HomePage home=new HomePage(driver);
		home.deleteCourse();
		//Assert.assertTrue(false);
	}
	
	
	//Sign out Test
	@Test(priority = 5)
	public void signOut()
	{
		HomePage home=new HomePage(driver);
		home.signOut();
		Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'New user?')]")).isDisplayed());
	}
}

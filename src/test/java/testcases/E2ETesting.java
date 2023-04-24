package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import dataProvider.CustomDataProvider;
import pages.AddCourse;
import pages.HomePage;
import pages.LoginPage;

public class E2ETesting extends BaseClass{

	
		//Login Test
		@Test(dataProvider = "loginDetails", dataProviderClass = CustomDataProvider.class, priority = 1)
		public void loginToApplication(String userId, String password)
		{
			
			LoginPage login =new LoginPage(driver);
			login.loginToApplication(userId, password);
			Assert.assertTrue(driver.findElement(By.xpath("//button[text()='Cart']")).isDisplayed());	
		}
		
		    @Test(priority = 2)
			public void manageCourses() 
			{
				HomePage home=new HomePage(driver);
				home.manageCourses();
				Assert.assertTrue(driver.findElement(By.xpath("//h1[contains(text(),'Manage Courses')]")).isDisplayed());
			}
		
		//Add Courses Test
		@Test(dataProvider = "courseDetails", dataProviderClass = CustomDataProvider.class, priority = 3)
		public void AddCourseTest(String courseName, String description, String instructor, String price,
				String startMonth, String endMonth, String startDate, String endDate, String category, String link)
		{
			
			AddCourse add=new AddCourse(driver);
			add.addNewCourse(courseName, description,instructor, price, startMonth, endMonth, startDate,endDate,category,link);
			Assert.assertTrue(driver.findElement(By.xpath("//input[@type='checkbox']//following::td[text()='Automation Testing Using Selenium']")).isDisplayed());
		}
		
		//Delete Course Test
		@Test(priority = 4)
		public void deleteCourseTest() 
		{
			HomePage home=new HomePage(driver);
			home.deleteCourse();
			//Assert.assertFalse(driver.findElement(By.xpath("//input[@type='checkbox']//following::td[text()='Automation Using Selenium']")).isDisplayed());

		}
		
			@Test(priority = 5)
			public void signOutTest()
			{
				HomePage home=new HomePage(driver);
				home.signOut();
				Assert.assertTrue(driver.findElement(By.xpath("//a[text()='New user? Signup']")).isDisplayed());

			}
		
			


}
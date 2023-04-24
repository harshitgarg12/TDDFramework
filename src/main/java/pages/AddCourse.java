package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class AddCourse {

	WebDriver driver;
	
	public AddCourse(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By addNewCourse=By.xpath("//button[contains(text(),'Add New Course')]");
	By chooseFile=By.xpath("//input[@id='thumbnail']");
	By courseName=By.xpath("//h3[contains(text(),'Course Name')]//following::input[@id='name']");
	By description=By.xpath("//h3[contains(text(),'Description')]//following::textarea[@id='description']");
	By  instructor=By.xpath("//h3[contains(text(),'Instructor')]//following::input[@id='instructorNameId']");
	By  price=By.xpath("//h3[contains(text(),'Price')]//following::input[@id='price']");
	By startDateInput=By.xpath("//input[@name='startDate']");
	By endDateInput=By.xpath("//input[@name='endDate']");
	By nextMonth=By.xpath("//button[@aria-label='Next Month']");
	By category=By.xpath("//div[text()='Select Category']");
	By save=By.xpath("//button[text()='Save']");
	
	
	
	
	public void addNewCourse(String cName, String des, String instruc, String cost,
			String startMonth, String endMonth, String starDate, String enDate, String categ, String path)
	{
		
		driver.findElement(addNewCourse).click();
			driver.findElement(chooseFile).sendKeys("C:\\Users\\intel\\Documents\\Sunset.png");
			driver.findElement(courseName).sendKeys(cName);
			driver.findElement(description).sendKeys(des);
			driver.findElement(instructor).sendKeys(instruc);
			driver.findElement(price).sendKeys(cost);
			driver.findElement(startDateInput).click();
			driver.findElement(By.xpath("//div[contains(@aria-label,'April 27')]")).click();

			//WebElement startDate=driver.findElement(By.xpath("//div[contains(@aria-label,'June 1')]"));
			//WebElement endDate=driver.findElement(By.xpath("//div[contains(@aria-label,'August 1')]"));

			
			driver.findElement(endDateInput).click();
			//driver.findElement(nextMonth).click();
			driver.findElement(By.xpath("//div[contains(@aria-label,'May 27')]")).click();
			driver.findElement(category).click();
			if(categ.contentEquals("Automation Testing")) {
			driver.findElement(By.xpath("//button[text()='Automation Testing']")).click();
			}
			driver.findElement(save).click();
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

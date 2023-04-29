package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helper.Utility;

public class AddCoursePage {

	WebDriver driver;
	
	By addNewCourse=By.xpath("//button[text()='Add New Course ']");
	By file=By.name("thumbnail");
	By courseName=By.xpath("//input[@id='name']");
	By description=By.xpath("//textarea[@id='description']");
	By instructor=By.xpath("//input[@id='instructorNameId']");
	By price=By.xpath("//input[@id='price']");
	By startsFrom=By.name("startDate");
	By month=By.xpath("//div[@class='react-datepicker__current-month']");
	By next=By.xpath("//button[@aria-label='Next Month']");
	By endsOn=By.name("endDate");
	By category=By.xpath("//div[text()='Select Category']");
	By automationTesting=By.xpath("//button[text()='Automation Testing']");
	By save=By.xpath("//button[text()='Save']");
	By delete=By.xpath("//td[text()='Selenium Using Java']//following::button");

	public AddCoursePage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void addNewCourse(String chooseFile, String cName, String desc,
			String inst, String cost, String categ, String stDate, 
			String enDate, String starMonth, String enMonth)
	{
		driver.findElement(addNewCourse).click();
		driver.findElement(file).sendKeys(chooseFile);
		driver.findElement(courseName).sendKeys(cName);
		driver.findElement(description).sendKeys(desc);
		driver.findElement(instructor).sendKeys(inst);
		driver.findElement(price).sendKeys(cost);
		driver.findElement(startsFrom).click();
		
		while(true)
		{
			String monthValue=driver.findElement(month).getText();
			if(monthValue.contains(starMonth))
			{
				break;
			}
			else
			{
				driver.findElement(next).click();
			}
		}
		
		driver.findElement(By.xpath("//div[text()="+stDate+"]")).click();
		
		driver.findElement(endsOn).click();
		while(true)
		{
			String monthValue=driver.findElement(month).getText();
			if(monthValue.contains(enMonth))
			{
				break;
			}
			else
			{
				driver.findElement(next).click();
			}
		}
		
		driver.findElement(By.xpath("//div[text()="+enDate+"]")).click();
		
		
		
		driver.findElement(category).click();
		if(categ.contentEquals("Automation Testing"))
		{
		driver.findElement(automationTesting).click();
		}
		else
		{
			System.out.println("Category not Matched");
		}
		driver.findElement(save).click();
		
		Utility.waitForSeconds(2);
		}
	
	
 	}

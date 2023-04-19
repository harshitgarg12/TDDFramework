package helper;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {

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
}

package listeners;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import helper.Utility;

public class ExtentManager {
	
	static ExtentReports extent;
	
	public static ExtentReports getInstance()
	{
		if(extent==null)
		{
			extent=createInstance();
			return extent;
		}
		else
		{
			return extent;
		}
	}
	
	
	public static ExtentReports createInstance()
	{
		ExtentSparkReporter sparkreporter=new ExtentSparkReporter(new File(System.getProperty("user.dir")+"/reports/Automation_"+Utility.getCurrentTime()+ "_.html"));
		
		sparkreporter.config().setTheme(Theme.DARK);
		sparkreporter.config().setDocumentTitle("Sprint 1 Report");
		sparkreporter.config().setReportName("Learn Automation Report");
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(sparkreporter);
		
		return extent;
	}

}

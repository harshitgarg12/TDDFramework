package dataProvider;

import org.testng.annotations.DataProvider;

public class CustomDataProvider {

	@DataProvider(name="loginDetails")
	public Object[][] getData()
	{
		Object[][] arr=ExcelReader.getDataFromSheet("login");
		return arr;
}
	
	@DataProvider(name="courseDetails")
	public Object[][] getCourseData()
	{
		Object[][] arr=ExcelReader.getDataFromSheet("courseDetails");
		return arr;
}
}

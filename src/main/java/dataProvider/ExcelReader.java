package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	static XSSFWorkbook wb;
	
	public static Object[][] getDataFromSheet(String sheetName)
	{
		try {
			 wb=new XSSFWorkbook(new FileInputStream(new File(System.getProperty("user.dir")+"/testdata/userDetails.xlsx")));
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found" +e.getMessage());
			
		} catch (IOException e) {
			
			System.out.println("Could Not Load the File" +e.getMessage());

		}
		
		XSSFSheet sheet=wb.getSheet(sheetName);
		int rows=sheet.getPhysicalNumberOfRows();
		int cols=sheet.getRow(0).getPhysicalNumberOfCells();
		
		Object[][] arr=new Object[rows-1][cols];
		
		for(int i=1;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				arr[i-1][j]=getData(sheetName, i, j);
			}
		}
		
		return arr;
	}
	
	
		public static String getData(String sheetName, int row, int col)
		{
			String value="";
			
			XSSFCell cell=wb.getSheet(sheetName).getRow(row).getCell(col);
			
			if(cell.getCellType()==CellType.STRING)
			{
				value=cell.getStringCellValue();
			}
			else if(cell.getCellType()==CellType.BLANK)
			{
				value="";
			}
			else if(cell.getCellType()==CellType.BOOLEAN)
			{
				Boolean data=cell.getBooleanCellValue();
				value=String.valueOf(data);
			}
			else if(cell.getCellType()==CellType.NUMERIC)
			{
				int data=(int) cell.getNumericCellValue();
				value=String.valueOf(data);
			}
			
			return value;
		}
	
}

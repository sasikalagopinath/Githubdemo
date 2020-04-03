package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviderIrctcAccomadation 
{
	@DataProvider (name = "fetchdata")
	public static String[][] getdata() throws IOException
	{
		FileInputStream IrctcAcco = new FileInputStream("./Testdata/IrctcAccomadation.xlsx");
		XSSFWorkbook IrctcAcco1 = new XSSFWorkbook(IrctcAcco);
		XSSFSheet Sheet1 = IrctcAcco1.getSheetAt(0);
		int RC = Sheet1.getLastRowNum();
		int CC = Sheet1.getRow(0).getLastCellNum();
		String[][] TestData = new String[RC][CC];
		for (int i=1; i<=RC; i++)
		{
			XSSFRow Row = Sheet1.getRow(i);
		for (int j=0; j<CC; j++)
		{
			String cellValue = Row.getCell(j).getStringCellValue();
			System.out.println(cellValue);
			TestData[i-1][j] = cellValue;
		}
		}
		
		return TestData;				
	}
}

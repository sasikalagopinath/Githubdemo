package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviderIrctcGSTValidation 
{
	@DataProvider(name="fetchdata")
	public static String[][] getdata() throws IOException 
	{
	FileInputStream	IrctcGSTvValidation = new FileInputStream("./Testdata/IrctcGSTValidation.xlsx");
	XSSFWorkbook IrctcGSTvValidation1 = new XSSFWorkbook(IrctcGSTvValidation);
	XSSFSheet sheet1 = IrctcGSTvValidation1.getSheetAt(0);
	int RC = sheet1.getLastRowNum();
	int CC = sheet1.getRow(0).getLastCellNum();
	System.out.println("Row count -"+RC);
	System.out.println("Column Count -"+CC);
	String [][] TestData = new String[RC][CC];
	for(int i=1;i<=RC; i++)
	{
		XSSFRow row = sheet1.getRow(i);
	for(int j=0; j<CC; j++)
	{
		String Cellvalue = row.getCell(j).getStringCellValue();
		TestData[i-1][j] = Cellvalue;
		
	}
	}
		
		return TestData;
		
	}
}
	


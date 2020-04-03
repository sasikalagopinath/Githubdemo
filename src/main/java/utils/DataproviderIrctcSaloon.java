package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataproviderIrctcSaloon 
{
	@DataProvider(name = "fetchdata")
	public static String[][] getdata() throws IOException
	{
	FileInputStream IrctcSaloon = new FileInputStream("./Testdata/IrctcSaloon.xlsx");
	XSSFWorkbook IrctcSaloon1 = new XSSFWorkbook(IrctcSaloon);
	XSSFSheet sheet1 = IrctcSaloon1.getSheetAt(0);
	int RC = sheet1.getLastRowNum();
	int CC = sheet1.getRow(0).getLastCellNum();
	System.out.println("Row Count -"+RC);
	System.out.println("Column Count -"+CC);
	String[][] TestData = new String[RC][CC];
	for(int i=1;i<=RC;i++)
	{
		XSSFRow row = sheet1.getRow(i);
	for(int j=0; j<CC;j++)
	{
		String CellValue = row.getCell(j).getStringCellValue();
		System.out.println(CellValue);
		TestData[i-1][j] = CellValue;
	}
	}
	return TestData;

}	

}

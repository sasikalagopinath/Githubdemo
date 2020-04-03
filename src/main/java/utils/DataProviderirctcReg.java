package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviderirctcReg 
{
	@DataProvider (name ="fetchdata")
	public static String[][] getdata() throws IOException
	{
		FileInputStream filename = new FileInputStream("./Testdata/IrctcRegistration.xlsx");
		XSSFWorkbook Workbook = new XSSFWorkbook(filename);
		XSSFSheet Sheetname = Workbook.getSheetAt(0);
		
		int RC = Sheetname.getLastRowNum();
		int CC = Sheetname.getRow(0).getLastCellNum();
		System.out.println("Row Count - "+RC);
		System.out.println("Column Count -"+CC);
		
		String[][] TestData = new String[RC][CC];
		
		for (int i=1;i<=RC;i++)
		{
			XSSFRow Row = Sheetname.getRow(i);
		for (int j=0;j<CC;j++)
		{
			String CellValue = Row.getCell(j).getStringCellValue(); // getStringcellvalue is a method to get the cell value in a string
			System.out.println(CellValue);
			TestData[i-1][j] = CellValue;
		}
		}
		 return TestData;		
	}
}

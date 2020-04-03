package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviderIrctcNationalVoters 
{
	@DataProvider (name = "fetchdata")
	public static String[][] getdata() throws IOException
	{
		FileInputStream FileName = new FileInputStream("./Testdata/IrctcNationalVoters.xlsx");
		XSSFWorkbook IrctcNationalVoters = new XSSFWorkbook(FileName);
		XSSFSheet Sheet1 = IrctcNationalVoters.getSheetAt(0);
		
		int RC = Sheet1.getLastRowNum();
		int CC = Sheet1.getRow(0).getLastCellNum();
		System.out.println("Row Count - "+RC);
		System.out.println("Column Count - "+CC);
		
		String[][] TestData = new String[RC][CC];
		for(int i=1; i<=RC; i++)
		{
			XSSFRow Row = Sheet1.getRow(i);
		for(int j=0; j<CC; j++)
		{
			String CellValue = Row.getCell(j).getStringCellValue();
			System.out.println(CellValue);
			TestData[i-1][j] = CellValue;
		}
		}
		
		return TestData;
			
	}

}

package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviderFB {
	
	@DataProvider(name="fetchData")
	public static String[][] getData() throws IOException{
		
		FileInputStream fis = new FileInputStream("./Testdata/FB.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0); // 0 is index value of sheet name
		
		int RC = sheet.getLastRowNum();
		int CC = sheet.getRow(0).getLastCellNum(); // colum will start from 0
		
		System.out.println("Row Count - "+ RC);
		System.out.println("Coun Count - "+ CC);
		
		
		String[][] testData = new String[RC][CC];
		
		for(int i=1; i<=RC; i++) {  //apachepoi will strat from 1 and apachepoi framewok will only iteract with excel sheet
			
			XSSFRow row = sheet.getRow(i);//need to get row values from sheet
			System.out.println(row);
			for(int j=0; j<CC; j++) {
				String cellValue = row.getCell(j).getStringCellValue(); //to get column values from sheet
				System.out.println(cellValue);
				testData[i-1][j] = cellValue; // TestNG will start from 0
			}
			
		}
		
		return testData;	
	}
	

}

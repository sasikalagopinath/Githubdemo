package utils;

import org.testng.annotations.DataProvider;

public class SampleDataProvider {

	@DataProvider(name = "fetchData")
	public static String[][] getData() {
		
		String[][] testData = new String[3][2]; 
		
		testData[0][0] = "Liberty";
		testData[0][1] = "Testing Center";
		
		testData[1][0] = "Liberty";
		testData[1][1] = "Technologies";
		
		testData[2][0] = "Liberty";
		testData[2][1] = "Karapakam";
		
		
		
		return testData;
		
	}
	
	
}

package utils;

import org.testng.annotations.DataProvider;

public class SampleDataProvider1
{
	@DataProvider (name = "fetchdata")
	public static String[][] getdata()
	
	{
		String[][] testdata = new String[3][4];
		
			testdata[0][0] = "Sasi";
			testdata[0][1] = "Palanivel";
			testdata[0][2] = "8978675634";
			testdata[0][3] = "xxxxx";
			
			testdata[1][0] = "Gopinath";
			testdata[1][1] = "Murugesan";
			testdata[1][2] = "9940106341";
			testdata[1][3] = "yyyyy";
			
			testdata[2][0] = "Thanvika";
			testdata[2][1] = "G S";
			testdata[2][2] = "9940106341";
			testdata[2][3] = "zzzzz";
		
		return testdata;
		
	}
	
}

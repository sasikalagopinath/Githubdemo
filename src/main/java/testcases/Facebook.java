package testcases;

import org.testng.annotations.Test;

import utils.SampleDataProvider;
import wrappers.GenericWrappers;

public class Facebook extends GenericWrappers {

	@Test(dataProvider = "fetchData", dataProviderClass = SampleDataProvider.class)
	public void fb(String firstname, String Lastname) {
	
		invokeApp("chrome", "https://facebook.com");
		enterByName("firstname", firstname);
		enterByName("lastname", Lastname);
		enterByXpath("firstname");
		enterByName("Lastname", Lastname);
		
	}
	
}

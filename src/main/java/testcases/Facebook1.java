package testcases;

import org.testng.annotations.Test;

import utils.DataProviderFB;
import utils.SampleDataProvider1;
import wrappers.GenericWrappers;

public class Facebook1 extends GenericWrappers
{
	@Test(dataProvider = "fetchData", dataProviderClass = DataProviderFB.class)
	public void facebook(String firstname, String lastname, String mobilenumber, String Newpassword, String date) 
	{
	invokeApp("Chrome", "https://www.facebook.com");
	enterByName("firstname",firstname);
	enterByName("lastname", lastname);
	enterByName("reg_email__", mobilenumber);
	enterByName("reg_passwd__", Newpassword);
	int Date = Integer.parseInt(date);
	selectIndexByName("birthday_day", Date);
	}
	
}

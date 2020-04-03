package testcases;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import utils.DataProviderIrctcAccomadation;
import wrappers.ProjectWrappers;

public class TC002 extends ProjectWrappers
{
	@Test(dataProvider = "fetchdata", dataProviderClass = DataProviderIrctcAccomadation.class )
	public void irctcAccomadation(String StationName, String NoofPersons, String CheckInTime, String CheckOutTime, String EmailID, 
			String MobileNumber, String Name, String Age, String Sex, String Name1, String Age1, String Sex1, String State) 
	{
		//Load the IRCTC URL
		//invokeApp("chrome", "https://www.irctc.co.in");
		//Click on Agent Login
		//clickByXpath("/html/body/app-root/app-home/div[1]/app-header/div[2]/div[2]/div[1]/a[8]/span");
		//Click on Sign Up
		//clickByLink("Sign up");
		//Mouse Hover on Tourism
		clickByXpath("//*[@id=\"bluemenu\"]/ul/li[2]/a");
		//Mouse Hover on Stays
		clickByLink("Stays");
		//Click On Lounge
		clickByXpath("//*[@id=\"bluemenu\"]/ul/li[2]/ul/li[2]/ul/li[4]/a");
		//Perform Switching window
		switchToLastWindow();
		waitTime(6000);
		//Click on Stay Icon
		clickByXpath("//*[@id=\"slider-1\"]/div[1]/div[2]/a[3]/span");
		waitTime(6000);
		//Select Station Name
		selectVisibleTextByName("city", StationName);
		//Select No of Persons
		selectVisibleTextByName("selPassangers", NoofPersons);
		//Select Check In Date
		tabByXpath("/html/body", Keys.TAB);
		clickByXpath("//*[@id=\"slider-1\"]/div[1]/div/div/div/div[1]/div[1]/div[2]/form/div/div[4]/div[1]/div/div/table/tbody/tr[5]/td[6]/span");
		//Select Check In Time
		selectValueByName("checkInTime", CheckInTime);
		//Select Duration
		selectVisibleTextByName("checkOutTime", CheckOutTime);
		waitTime(3000);
		//Click on Book
		clickByXpath("//*[@id=\"slider-1\"]/div[1]/div/div/div/div[1]/div[1]/div[2]/form/div/div[10]/button[2]");
		waitTime(6000);
		//Enter Guest Gmail Id 
		enterByName("email", EmailID);
		//Enter Guest Mobile Number
		enterByName("mobileNo", MobileNumber);
		waitTime(3000);
		clickByXpath("//*[@id=\"gulogin-form\"]/div[3]/div/input");
		waitTime(6000);
		//Enter 3 Passenger Details (Name, Age , Gender)
		enterByXpath("/html/body/app-root/acpassangers/section[2]/div/div/div/div[3]/form/div[2]/table/tbody/tr[1]/td[2]/div/input", Name);
		enterByXpath("/html/body/app-root/acpassangers/section[2]/div/div/div/div[3]/form/div[2]/table/tbody/tr[1]/td[3]/div/input", Age);
		selectVisibleTextByXpath("/html/body/app-root/acpassangers/section[2]/div/div/div/div[3]/form/div[2]/table/tbody/tr[1]/td[4]/div/select", Sex);
		enterByXpath("/html/body/app-root/acpassangers/section[2]/div/div/div/div[3]/form/div[2]/table/tbody/tr[2]/td[2]/div/input", Name1);
		enterByXpath("/html/body/app-root/acpassangers/section[2]/div/div/div/div[3]/form/div[2]/table/tbody/tr[2]/td[3]/div/input", Age1);
		selectValueByXpath("/html/body/app-root/acpassangers/section[2]/div/div/div/div[3]/form/div[2]/table/tbody/tr[2]/td[4]/div/select", Sex1);
		//Select State in contact Details
		selectVisibleTextByName("state", State);
		//Click on Submit
		clickByXpath("/html/body/app-root/acpassangers/section[2]/div/div/div/div[3]/form/div[5]/button[3]");
		waitTime(3000);
		
		pageDownByXpath("/html/body", Keys.PAGE_DOWN);
		downByXpath("/html/body", Keys.DOWN);
		//downByXpath("/html/body", Keys.DOWN);
		
		//Verify your email id 
		verifyTextByXpath("((//div[starts-with(@class,'col-md-4 form-new')])//following::span)[1]", "sasik774@gmail.com");
		//Verify your mobile number
		verifyTextContainsByXpath("((//div[starts-with(@class,'col-md-4 form-new')])//following::span)[2]", "9940106341");
		//get the amount and print in console
		getTextByXpath("((//div[starts-with(@class,'col-md-4 form-new')])//following::span)[6]");
		waitTime(6000);
		//check terms and conditions
		clickByXpath("((//div[starts-with(@class,'col-md-4 form-new')])//following::span)[9]");
		//click on Make payment 
		clickByXpath("//button[(text()='MAKE PAYMENT')]");
		waitTime(6000);	
		//Print the Transaction Id in console
		getAttributeValueByXpath("(//span[text()='Transaction ID :']//following::input)[1]");
		//closeAllBrowsers();
	}
}
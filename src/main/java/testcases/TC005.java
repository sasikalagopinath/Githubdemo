package testcases;


import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import utils.DataProviderIrctcGSTValidation;
import wrappers.ProjectWrappers;

public class TC005 extends ProjectWrappers
{
	@Test(dataProvider = "fetchdata", dataProviderClass = DataProviderIrctcGSTValidation.class)
 public void IrctcAccomadationGSTValidation(String stationName, String selPassangers, String checkInTime, String checkOutTime,
		 String email, String mobileNo, String gstGet, String gstNo, String name, String age, String gender, String name1, String age1, String gender1,
		 String name2, String age2, String gender2, String state)
 {
			//invokeApp("chrome", "https://www.irctc.co.in");
			//Click on Agent Login
			clickByXpath("(//span[starts-with(@class,'ng-star-inserted')])[1]");
			//Click on Sign Up
			clickByXpath("//a[@href='/eticketing/userSignUp.jsf']");
			//Mouse Hover on Tourism
			clickByXpath("//a[text()=' Tourism  ']");
			//Mouse Hover on Stays
			clickByXpath("//a[text()='Stays']");
			//Click On Lounge
			clickByXpath("//a[text()='Lounge']");
			//Perform Switching window
			switchToLastWindow();
			waitTime(6000);
			//Click on Stay Icon
			clickByXpath("//div[@class='Accommodation']");
			waitTime(5000);
			//Select Station Name
			selectVisibleTextByXpath("//select[@name='city']", stationName);
			//Select No of Persons
			selectVisibleTextByXpath("//select[@name='selPassangers']", selPassangers);
			//Select Check In Date
			tabByXpath("/html/body", Keys.TAB);
			clickByXpath("//i[starts-with(@class,'fa fa-angle-right')][1]");
			clickByXpath("(//span[starts-with(@class,'act')])[31]");
			//Select Check In Time
			selectValueByXpath("//select[@name='checkInTime']", checkInTime);
			//Select Duration
			selectVisibleTextByXpath("//select[@name='checkOutTime']", checkOutTime);
			waitTime(3000);
			//Click on Book
			clickByXpath("//button[starts-with(@class,'btn btn-default')]");
			waitTime(6000);
			//Enter Guest Gmail Id 
			enterByXpath("(//input[@name='email'])[1]", email);
			//Enter Guest Mobile Number
			enterByXpath("(//input[@name='mobileNo'])[1]", mobileNo);
			clickByXpath("(//input[starts-with(@class,'pop-btn')])[2]");
			waitTime(6000);
			//Select GST as Yes
			selectVisibleTextByXpath("//select[@name='gstGet']", gstGet);
			//Enter Random GSTTIN Number
			enterByXpath("//input[@name='gstNo']", gstNo);
			waitTime(6000);
			//Enter 3 Passenger Details (Name, Age , Gender)
			enterByXpath("//input[starts-with(@class,'buttonsearch displayblockinput ng-pristine ng-invalid ng-touched')]", name);
			waitTime(3000);
			enterByXpath("(//input[starts-with(@class,'buttonsearch displayblockinput ng-untouched ng-pristine ng-invalid')])[1]", age);
			selectVisibleTextByXpath("(//select[starts-with(@class,'form-control initialized ng-untouched ng-pristine ng-invalid')])[1]", gender);
			waitTime(3000);
			//enterByXpath("(//input[starts-with(@class,'buttonsearch displayblockinput ng-invalid ng-dirty ng-touched')])[2]", name1);
			//enterByXpath("(//input[starts-with(@class,'buttonsearch displayblockinput ng-pristine ng-invalid ng-touched')])[2]", age1);
			//selectValueByXpath("(//select[starts-with(@class,'form-control initialized ng-untouched ng-pristine ng-invalid')])[2]", gender1);
			waitTime(3000);
			//enterByXpath("(//input[starts-with(@class,'buttonsearch displayblockinput ng-dirty ng-valid ng-touched')])[2]", name2);
			//enterByXpath("(//input[starts-with(@class,'buttonsearch displayblockinput ng-untouched ng-pristine ng-invalid')])[1]", age2);
			//selectVisibleTextByXpath("(//select[starts-with(@class,'form-control initialized ng-untouched ng-pristine ng-invalid')])[3]", gender2);
			//Select State in contact Details
			selectVisibleTextByXpath("//select[@name='state']", state);
			//Click on Submit
			clickByXpath("(//button[@type='submit'])[1]");
			//Verify "Gst Number field is required." is displayed below Customer GSTTIN 
			verifyTextByXpath("(//input[@name='gstNo']//following::span)[1]", "Please Enter Valid GSt number");
			//closeAllBrowsers();
 }
}

package testcases;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import utils.DataproviderIrctcSaloon;
import wrappers.ProjectWrappers;

public class TC004 extends ProjectWrappers
{
 @Test(dataProvider = "fetchdata", dataProviderClass = DataproviderIrctcSaloon.class)
 public void IrctcSaloonMandatoryCheck(String name, String organization, String address, String email, String requestFor, String originStation, String destnStation,
		 String durationPeriod, String coachDetails, String numPassenger, String charterPurpose,
		 String services)

 {
	//Load the IRCTC URL
	//invokeApp("chrome", "https://www.irctc.co.in");
	//Click on Agent Login
	//clickByXpath("/html/body/app-root/app-home/div[1]/app-header/div[2]/div[2]/div[1]/a[8]/span");
	//Click on Sign Up
	//clickByLink("Sign up");
	 waitTime(3000);
	//Mouse Hover on Tourism
	clickByXpath("//a[text()=' Tourism  ']");
	//Mouse Hover on Stays
	clickByXpath("//a[text()='Stays']");
	//Click On Lounge
	clickByXpath("//a[text()='Lounge']");
	//Perform Switching window
	switchToLastWindow();
	waitTime(3000);
	//Click on Menu Icon (at the top right corner)
	clickByXpath("//i[starts-with(@class,'fa fa-bars sideOpener')]");
	waitTime(3000);
	//Click on Charter
	clickByXpath("(//a[starts-with(@class,'waves-effect tabhomemenu')])[11]");
	waitTime(3000);
	//Click on Enquiry Form
	clickByXpath("//a[text()='Enquiry Form']");
	waitTime(3000);
	downByXpath("/html/body", Keys.DOWN);
	//Enter Name of Applicant
	enterByXpath("//input[@name='name']",name);
	//Enter Name of Organisation
	enterByXpath("//input[@name='organization']", organization);
	//Enter Address
	enterByXpath("//input[@name='address']", address);
	//Enter Email ID
	enterByXpath("//input[@name='email']", email);
	//Select Request for as Saloon
	selectVisibleTextByXpath("//select[@name='requestFor']", requestFor);
	//Enter Origination Station
	enterByXpath("//input[@name='originStation']", originStation);
	//Enter Destination Station
	enterByXpath("//input[@name='destnStation']", destnStation);
	tabByXpath("/html/body", Keys.TAB);
	//Select Date of Departure
	clickByXpath("(//i[starts-with(@class,'fa fa-angle-right')])[1]");
	clickByXpath("(//span[starts-with(@class,'act')])[31]");
	tabByXpath("/html/body", Keys.TAB);
	//Select Date of Arrival
	clickByXpath("(//i[starts-with(@class,'fa fa-angle-right')])[2]");
	clickByXpath("(//span[starts-with(@class,'glyphicon glyphicon-chevron-right')])[3]");
	clickByXpath("(//span[starts-with(@class,'act')])[61]");
	//Enter Duration of Tour
	enterByXpath("//input[@name='durationPeriod']", durationPeriod);
	//Enter Number and type of coaches required
	enterByXpath("//input[@name='coachDetails']", coachDetails);
	//Enter Number of Passengers
	enterByXpath("//input[@name='numPassenger']", numPassenger);
	//Enter Purpose of Charter
	enterByXpath("//textarea[@name='charterPurpose']", charterPurpose);
	//Enter Additional Services Required
	enterByXpath("//textarea[@name='services']", services);
	//Click on Submit
	clickByXpath("//button[starts-with(@class,'btn btn-default col-md-12  col-xs-12')]");
	verifyTextByXpath("//span[text()='Mobile field is required.']", "Mobile field is required.");
	//closeAllBrowsers();
 }
}

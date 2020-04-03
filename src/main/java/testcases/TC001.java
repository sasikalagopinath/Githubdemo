package testcases;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import utils.DataProviderirctcReg;
import wrappers.GenericWrappers;
import wrappers.ProjectWrappers;

public class TC001 extends ProjectWrappers
{
	@Test(dataProvider = "fetchdata", dataProviderClass = DataProviderirctcReg.class)
	
		public void irctcReg(String userName, String password, String confpasword, String securityQ, String securityAnswer, String prelan, String firstName, String middleName, String lastName,
		String dobDay, String dobMonth, String dateOfBirth, String occupation, String uidno, String idno, String countries, String email, String mobile, String nationalityId, String address, String street, String area,
		String pincode, String cityName, String postofficeName, String landline, String addresso, String streeto, String areao, String countrieso, String pincodeo, String cityNameo, String postofficeNameo, String landlineo, String nlpAnswer)
		{
		//Load the IRCTC URL
		//invokeApp("chrome", "https://www.irctc.co.in");
		//Click on Agent Login
		//clickByXpath("/html/body/app-root/app-home/div[1]/app-header/div[2]/div[2]/div[1]/a[8]/span");
		//Click on Sign Up
		//clickByLink("Sign up");
		//Enter the User ID
	    enterByXpath("//input[@id='userRegistrationForm:userName']", userName);
		//Enter the Password
	    enterByXpath("//input[@id='userRegistrationForm:password']", password);
	    //Enter the Confirm Password
	    enterByXpath("//input[@id='userRegistrationForm:confpasword']", confpasword);
	    //Select Security Question
	    selectVisibleTextByXpath("//select[@id='userRegistrationForm:securityQ']", securityQ);
	    //Enter the Security Answer
	    enterByXpath("//input[@id='userRegistrationForm:securityAnswer']", securityAnswer);
	    //Select Preferred Language
	    selectVisibleTextByXpath("//select[@id='userRegistrationForm:prelan']", prelan);
	    //Enter First Name
	    enterByXpath("//input[@id='userRegistrationForm:firstName']", firstName);
	    //Enter Middle Name
	    enterByXpath("//input[@id='userRegistrationForm:middleName']", middleName);
	    //Enter Last Name
	    enterByXpath("//input[@id='userRegistrationForm:lastName']", lastName);
	    //Choose the Gender
	    clickByXpath("//input[@id='userRegistrationForm:gender:1']");
	    //Choose the Martial Status
	    clickByXpath("//input[@id='userRegistrationForm:maritalStatus:0']");
	    //Select Date of Birth (Date, Month, Year)
	    selectVisibleTextByXpath("//select[@id='userRegistrationForm:dobDay']", dobDay);
	    selectVisibleTextByXpath("//select[@id='userRegistrationForm:dobMonth']", dobMonth);
	    selectVisibleTextByXpath("//select[@id='userRegistrationForm:dateOfBirth']", dateOfBirth);
	    //Select Occupation
	    selectVisibleTextByXpath("//select[@id='userRegistrationForm:occupation']", occupation);
	    //Enter Aadhaar Card No
	    enterByXpath("//input[@id='userRegistrationForm:uidno']", uidno);
	    //Enter Pan Card Number
	    enterByXpath("//input[@id='userRegistrationForm:idno']", idno);
	    //Select Country
	    selectVisibleTextByXpath("//select[@id='userRegistrationForm:countries']", countries);
	    //Enter Email
	    enterByXpath("//input[@id='userRegistrationForm:email']", email);
	    //Enter ISD Mobile Number
	    enterByXpath("//input[@id='userRegistrationForm:mobile']", mobile);
	    //Select Nationality
	    selectVisibleTextByXpath("//select[@id='userRegistrationForm:nationalityId']", nationalityId);
	    //Enter Flat/Door/Block No
	    enterByXpath("//input[@id='userRegistrationForm:address']", address);
	    //Enter Street/Lane
	    enterByXpath("//input[@id='userRegistrationForm:street']", street);
	    //Enter Area/Locality
	    enterByXpath("//input[@id='userRegistrationForm:area']", area);
	    //Enter Pin Code
	    enterByXpath("//input[@id='userRegistrationForm:pincode']", pincode);
	    //Perform the TAB function
	    tabByXpath("/html/body", Keys.TAB);
	    //Wait Time
	    waitTime(3000);
	   //Select City/Town
	    selectVisibleTextByXpath("//select[@id='userRegistrationForm:cityName']", cityName);
	    waitTime(3000);
	    //Select Post Office
	    selectValueByXpath("//select[@id='userRegistrationForm:postofficeName']", postofficeName);
	    //Enter phone
	    enterByXpath("//input[@id='userRegistrationForm:landline']", landline);
	   //Choose Copy Residence to office Address Yes/No
	    clickByXpath("//input[@id='userRegistrationForm:resAndOff:0']");
	    //Enter Captcha (Any Random Data)
	    enterByXpath("//input[@id='nlpAnswer']", nlpAnswer);
	    //Choose IRCTC Newsletters Yes/No
	    clickByXpath("//input[@id='userRegistrationForm:newsletter:0']");
	    //Choose Commercial Promotions Yes/No
	    clickByXpath("//input[@id='userRegistrationForm:commercialpromo:0']");
	    //Choose Please inform me about IRCTC SBI Card through phone Yes/No
	    clickByXpath("//input[@id='userRegistrationForm:irctcsbicard:1']");
	    //closeBrowser();
	}
}
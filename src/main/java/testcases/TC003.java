package testcases;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import utils.DataProviderIrctcNationalVoters;
import wrappers.GenericWrappers;
import wrappers.ProjectWrappers;

public class TC003 extends ProjectWrappers 
{
	@Test(dataProvider="fetchdata", dataProviderClass = DataProviderIrctcNationalVoters.class)
	public void IrctcNationalVoterServicePortal(String language, String state, String district, String constituency, String firstName, String surName, String lastName,
			String relativeSurName, String relationType, String dob, String gender, String houseNo, String street, String village, String postOffice, String pinCode, String epicno, 
			String epicno1, String emailid, String mobileno, String birthVillage, String birthState, String birthDistrict, String dob1, String preState, String preDistrict, String preHouseNo,
			String preStreet, String preVillage, String prePostOffice, String prePinCode, String preDistrict1, String city)
	{
	//Load the IRCTC URL
	//invokeApp("Chrome", "https://www.irctc.co.in");
	//Click on Agent Login
	//clickByXpath("/html/body/app-root/app-home/div[1]/app-header/div[2]/div[2]/div[1]/a[8]/span");
	//Click on Sign Up
	//clickByLink("Sign up");
	//Mouse Over on More
	//Click on National Voter's Services Portal
	clickByXpath("//a[text()=' More  ']");
	clickByXpath("//a[@href='http://www.nvsp.in']");
	//Switching Window
	switchToLastWindow();
	waitTime(3000);
	//Click on "Click Here" under Apply online for registration of new voter/due to shifting from AC
	clickByXpath("(//a[starts-with(@class,'btn btn-info ')])[2]");
	//Switching Window
	switchToLastWindow();
	waitTime(3000);
	//Select Language as English
	selectVisibleTextByXpath("//select[@id='language']", language);
	waitTime(3000);
	//Select State 
	selectValueByXpath("//select[@id='stateList']", state);
	waitTime(3000);
	//Select District
	selectVisibleTextByXpath("//select[@id='distList']", district);
	waitTime(3000);
	//Select Assembly/Parliamentary Constituency
	selectVisibleTextByXpath("//select[@id='acList']", constituency);
	waitTime(3000);
	//Select due to shifting from another contituency
	clickByXpath("//input[@id='isExistingVoter']");
	//Enter Name
	enterByXpath("//input[@id='applicantName']", firstName);
	//Enter Surname
	enterByXpath("//input[@id='applicantSurname']", surName);
	//Enter Name of Relative of Applicant
	enterByXpath("//input[@id='applicantFMHName']", lastName);
	//Enter Surname of Relative of Applicant
	enterByXpath("//input[@id='applicantFMHSurname']", relativeSurName);
	//Select Type of Relation
	selectVisibleTextByXpath("//select[@id='applicantRelationType']", relationType);
	//Click on Date of birth 
	clickByXpath("//input[@id='RbdDateOfBirth']");
	//Enter Date of birth
	tabByXpath("/html/body", Keys.TAB);
	enterByXpath("//input[@id='txtDateOfBirth']", dob);
	//Select Gender of Applicant
	selectVisibleTextByXpath("//select[@id='elector_gender']", gender);
	//Enter House no
	enterByXpath("//input[@id='applicantPresentHouseNo']", houseNo);
	//Enter Street/Area/Locality
	enterByXpath("//input[@id='applicantPresentStreet']", street);
	//Enter Town/Village
	enterByXpath("//input[@id='applicantPresentVillage']", village);
	//Enter Post Office
	enterByXpath("//input[@id='applicantPresentPostoffice']", postOffice);
	//Enter Pin Code
	enterByXpath("//input[@id='applicantPresentPincode']", pinCode);
	//for Permanent Address of applicant check Same as Above
	clickByXpath("//input[@id='chkPermanent']");
	waitTime(3000);
	//Enter EPIC NO
	enterByXpath("//input[@id='applicantPrevepicno']", epicno);
	enterByXpath("//input[@id='applicantFamilyPrevepicno']", epicno1);
	waitTime(3000);
	//Check Disability 
	clickByXpath("//input[@id='IS_LOCOMOTOR_DISABLED']");
	//Enter Email ID
	enterByXpath("//input[@id='applicantEmail']", emailid);
	//Enter Mobile number
	enterByXpath("//input[@id='applicantMobile']", mobileno);
	//Enter Town in delcaration
	enterByXpath("//input[@id='applicantBirthVillage']", birthVillage);
	//Select State 
	selectValueByXpath("//select[@id='applicantBirthState']", birthState);
	//Select District
	selectVisibleTextByXpath("//select[@id='applicantBirthDistrict']", birthDistrict);
	//Enter Date 
	enterByXpath("//input[@id='txtRESIDENT_SINCE']", dob1);
	waitTime(3000);
	//Enter other address details in earlier place of ordinary residence
	selectVisibleTextByXpath("//select[@id='ddPrevState']", preState);
	selectVisibleTextByXpath("//select[@id='ddPrevac']", preDistrict);
	enterByXpath("//input[@id='applicantPreHouseNo']", preHouseNo);
	enterByXpath("//input[@id='applicantPreStreet']", preStreet);
	enterByXpath("//input[@id='applicantPreVillage']", preVillage);
	enterByXpath("//input[@id='applicantPrePostoffice']", prePostOffice);
	enterByXpath("//input[@id='applicantPrePincode']", prePinCode);
	selectVisibleTextByXpath("//select[@id='Prev_DistNo']", preDistrict1);
	enterByXpath("//input[@id='applicantFormPlace']", city);
	switchToParentWindow();
	//closeAllBrowsers();
}
}
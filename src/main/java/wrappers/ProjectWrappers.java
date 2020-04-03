package wrappers;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ProjectWrappers extends GenericWrappers
{
	@BeforeMethod
	public void beforeMethod(){
		invokeApp("chrome", "https://www.irctc.co.in");
		clickByXpath("(//span[starts-with(@class,'ng-star-inserted')])[1]");
		clickByXpath("//a[@href='/eticketing/userSignUp.jsf']");
	}
	@AfterMethod
	public void afterMethod() {
		//closeAllBrowsers();
	}

}

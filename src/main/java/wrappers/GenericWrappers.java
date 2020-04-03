package wrappers;

import java.util.Set;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class GenericWrappers implements Wrappers {

	
	RemoteWebDriver driver;
	
	public void invokeApp(String browser, String url) {
		
		try {
			if(browser.equalsIgnoreCase("chrome")) {
				try {
					System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 driver = new ChromeDriver();
			}else if(browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "./drivers/chromedriver.exe");
				 driver = new FirefoxDriver();
			}else if(browser.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver", "./drivers/chromedriver.exe");
				 driver = new InternetExplorerDriver();
			}
			
			driver.get(url);
			driver.manage().window().maximize();
			System.out.println("The "+browser+" launched successfully an loaded the url - "+url);
		} catch (WebDriverException e) {
			System.err.println("Browser Closed due to unknown error");
		}finally {
			takeSnap();
		}			
	}

	public void enterById(String idValue, String data) {
		try {
			driver.findElementById(idValue).sendKeys(data);
			System.out.println("The Element with "+idValue+" is found and Entered the "+data+" successfully");
		} catch (NoSuchElementException e) {
			System.err.println("The Element with data "+idValue+" is not available on the page");
		}catch (ElementNotVisibleException e) {
			System.err.println("The Element with data "+idValue+" is not Visible within the page");
		}catch (ElementNotInteractableException e) {
			System.err.println("The Element with data "+idValue+" is not Interactable");
		}catch (InvalidElementStateException e) {
			System.err.println("The Element with "+idValue+" is not Visible");
		}catch (WebDriverException e) {
			System.err.println("Browser Closed due to unknown error");
		}finally {
			takeSnap();
		}
	}

	public void enterByName(String nameValue, String data) {
		try {
			driver.findElementByName(nameValue).sendKeys(data);
			System.out.println("The Element with "+nameValue+" is found and Entered the "+data+" successfully");
		} catch (NoSuchElementException e) {
			System.err.println("The Element with data "+nameValue+" is not available on the page");
		}catch (ElementNotVisibleException e) {
			System.err.println("The Element with data "+nameValue+" is not Visible within the page");
		}catch (ElementNotInteractableException e) {
			System.err.println("The Element with data "+nameValue+" is not Interactable");
		}catch (InvalidElementStateException e) {
			System.err.println("The Element with "+nameValue+" is not Visible");
		}catch (WebDriverException e) {
			System.err.println("Browser Closed due to unknown error");
		}finally {
			takeSnap();
		}
	}

	public void enterByXpath(String xpathValue) {
		try {
			driver.findElementByXPath(xpathValue).sendKeys(xpathValue);
			System.out.println("The Element with "+xpathValue+" is found and Entered the "+xpathValue+" successfully");
		} catch (NoSuchElementException e) {
			System.err.println("The Element with data "+xpathValue+" is not available on the page");
		}catch (ElementNotVisibleException e) {
			System.err.println("The Element with data "+xpathValue+" is not Visible within the page");
		}catch (ElementNotInteractableException e) {
			System.err.println("The Element with data "+xpathValue+" is not Interactable");
		}catch (InvalidElementStateException e) {
			System.err.println("The Element with "+xpathValue+" is not Visible");
		}catch (StaleElementReferenceException e) {
			System.err.println("The Element with data "+xpathValue+" is no longer present in the Web page");
		}catch (WebDriverException e) {
			System.err.println("Browser Closed due to unknown error");
		}finally {
			takeSnap();
		}
	}
	public void verifyTitle(String title) {
	 String Browtitile = driver.getTitle();
	if (Browtitile.equals(title))
	 System.out.println("Browser title is correct");
	else {
		System.err.println("Browser title is not correct");
	}
	}

	public void verifyTextById(String id, String text) {
		String Actualtext = null;
		try {
			Actualtext = driver.findElementById(id).getText();
			if (Actualtext.equals(text))
				System.out.println("Text is correct");
		else {
			System.err.println("Text is incorrect");
		}	
		} catch (NoSuchElementException e) {
			System.err.println("The Element with data "+id+" is not available on the page");
		}catch (ElementNotVisibleException e) {
			System.err.println("The Element with data "+id+" is not Visible within the page");
		}catch (ElementNotInteractableException e) {
			System.err.println("The Element with data "+id+" is not Interactable");
		}catch (InvalidElementStateException e) {
			System.err.println("The Element with "+id+" is not Visible");
		}catch (WebDriverException e) {
			System.err.println("Browser Closed due to unknown error");
		}finally {
			takeSnap();
		}
	}

	public void verifyTextByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		String verifyTextByXpath = null;
		try {
			verifyTextByXpath = driver.findElementByXPath(xpath).getText();
			if (verifyTextByXpath.equals(text))
				System.out.println("To verify the text with the value "+text+" has passed");
		else {
			System.err.println("To verify the text with the value" +text+" has failed");
		}
		} catch (NoSuchElementException e) {
			System.err.println("There is no Such Element as-"+xpath+ " to verify the value-"+text);
		} catch (ElementNotVisibleException e) {
			System.err.println("The Element with a field-"+xpath+ "is not visible to verify the value-"+text);
		}catch (ElementNotInteractableException e) {
			System.err.println("The Element with-"+xpath+ "cannot be verified as it is currently unavailable to interact with the value-"+text);
		}catch (InvalidElementStateException e) {
			System.err.println("The Element-"+xpath+ "is no longer valid to verify the value-"+text);
		}catch (StaleElementReferenceException e) {
			System.err.println("The Element-"+xpath+ "is deleted or no longer available to verify the value-"+text);
		}catch (WebDriverException e) {
			System.err.println("Browser Closed due to unknown error");
		}finally {
			takeSnap();
		}	
	}

	public void verifyTextContainsByXpath(String xpath, String text) {
		String verifyTextContainsByXpath = null;
		try {
			verifyTextContainsByXpath = driver.findElementByXPath(xpath).getText();
			if (verifyTextContainsByXpath.contains(text))
				System.out.println("The test to verify the text with the value "+text+" has passed");
		    else {
			System.err.println("The test to verify the text with the value "+text+" has failed");
		}
		} catch (NoSuchElementException e) {
			System.err.println("There is no such element with "+xpath+" to verify the value" +text);
		}catch (ElementNotVisibleException e) {
			System.err.println("The Element with "+xpath+ "is not visible to verify the value" +text);
		}catch (ElementNotInteractableException e) {
			System.err.println("The Element with "+xpath+" is currently unavailable to interact with the value" +text);
		}catch (InvalidElementStateException e) {
			System.err.println("The Element with "+xpath+" is no longer valid to verify the value" +text);
		}catch (StaleElementReferenceException e) {
			System.err.println("The Element with "+xpath+" is deleted or no longer available to verify the value" +text);
		}catch (WebDriverException e) {
			System.err.println("The browser was closed before performing the action");
		}finally {
			takeSnap();
		}
		
	}

	public void clickById(String id) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByClassName(id).click();
			System.out.println("The Element with "+id+" is found and Clicked the "+id+" successfully");
		} catch (NoSuchElementException e) {
			System.err.println("The Element with data "+id+" is not available on the page");
		}catch (ElementNotVisibleException e) {
			System.err.println("The Element with data "+id+" is not Visible within the page");
		}catch (ElementNotInteractableException e) {
			System.err.println("The Element with data "+id+" is not Interactable");
		}catch (InvalidElementStateException e) {
			System.err.println("The Element with "+id+" is not Visible");
		}catch (WebDriverException e) {
			System.err.println("Browser Closed due to unknown error");
		}finally {
			takeSnap();
		}
	}

	public void clickByClassName(String classVal) {
		try {
		driver.findElementByName(classVal).click();
		System.out.println("The Element with "+classVal+" is found and Clicked the "+classVal+" successfully");
		} catch (NoSuchElementException e) {
			System.err.println("The Element with data "+classVal+" is not available on the page");
		}catch (ElementNotVisibleException e) {
			System.err.println("The Element with data "+classVal+" is not Visible within the page");
		}catch (ElementNotInteractableException e) {
			System.err.println("The Element with data "+classVal+" is not Interactable");
		}catch (InvalidElementStateException e) {
			System.err.println("The Element with "+classVal+" is not Visible");
		}catch (WebDriverException e) {
			System.err.println("Browser Closed due to unknown error");
	}finally {
		takeSnap();
	}
	}

	public void clickByName(String name) {
		try {
			driver.findElementByLinkText(name).click();
			System.out.println("The Element with "+name+" is found and Clicked the "+name+" successfully");
		} catch (NoSuchElementException e) {
			System.err.println("The Element with data "+name+" is not available on the page");
		}catch (ElementNotVisibleException e) {
			System.err.println("The Element with data "+name+" is not Visible within the page");
		}catch (ElementNotInteractableException e) {
			System.err.println("The Element with data "+name+" is not Interactable");
		}catch (InvalidElementStateException e) {
			System.err.println("The Element with "+name+" is not Visible");
		}catch (WebDriverException e) {
			System.err.println("Browser Closed due to unknown error");
		}finally {
			takeSnap();
		}
	}

	public void clickByLink(String name) {
		try {
			driver.findElementByLinkText(name).click();
			System.out.println("The Element with "+name+" is found and Clicked the "+name+" successfully");
		} catch (NoSuchElementException e) {
			System.err.println("The Element with data "+name+" is not available on the page");
		}catch (ElementNotVisibleException e) {
			System.err.println("The Element with data "+name+" is not Visible within the page");
		}catch (ElementNotInteractableException e) {
			System.err.println("The Element with data "+name+" is not Interactable");
		}catch (InvalidElementStateException e) {
			System.err.println("The Element with "+name+" is not Visible");
		}catch (WebDriverException e) {
			System.err.println("Browser Closed due to unknown error");
		}finally {
			takeSnap();
		}
	}

	public void clickByLinkNoSnap(String name) {
		try {
		driver.findElementByLinkText(name).click();
		System.out.println();
	} catch (ElementNotVisibleException e) {
		System.err.println(e);
	}catch (InvalidElementStateException e) {
		System.err.println(e);
	}catch (NoSuchElementException e) {
		System.err.println(e);
	}catch (WebDriverException e) {
		System.err.println(e);
	}finally {
		takeSnap();
	}
	}

	public void clickByXpath(String xpathVal) {
		try {
			driver.findElementByXPath(xpathVal).click();
			System.out.println("The Element with "+xpathVal+" is found and Clicked the "+xpathVal+" successfully");
		} catch (NoSuchElementException e) {
			System.err.println("The Element with data "+xpathVal+" is not available on the page");
		}catch (ElementNotVisibleException e) {
			System.err.println("The Element with data "+xpathVal+" is not Visible within the page");
		}catch (ElementNotInteractableException e) {
			System.err.println("The Element with data "+xpathVal+" is not Interactable");
		}catch (InvalidElementStateException e) {
			System.err.println("The Element with "+xpathVal+" is not Visible");
		}catch (WebDriverException e) {
			System.err.println("Browser Closed due to unknown error");
		}finally {
			takeSnap();
		}
	}

	public void clickByXpathNoSnap(String xpathVal) {
		try {
			driver.findElementByXPath(xpathVal).click();
		} catch (StaleElementReferenceException e) {
			System.err.println(e);
		}catch (InvalidElementStateException e) {
			System.err.println(e);
		}catch (WebDriverException e) {
			System.err.println(e);
		}finally {
			takeSnap();
		}
	}

	public String getTextById(String idVal) {
		String getTextById = null;
		try {
		getTextById =driver.findElementById(idVal).getText();
		System.out.println("The action to get the text was successful" +getTextById);	
	} catch (NoSuchElementException e) {
		System.err.println("There is no such element with "+idVal+" to get the text");
	}catch (ElementNotVisibleException e) {
		System.err.println("The element with "+idVal+" is not visible to get the text");
	}catch (ElementNotInteractableException e) {
		System.err.println("The element with "+idVal+" is currently unavailable to get the text");
	}catch (InvalidElementStateException e) {
		System.err.println("The element with "+idVal+"is not valid to get the text");
	}catch (StaleElementReferenceException e) {
		System.err.println("The element with "+idVal+" was deleted or no longer available to get the text");
	}catch (WebDriverException e) {
		System.err.println("The browser was closed due to an unknown error");
	}finally {
		takeSnap();
	}
	return getTextById;
	}

	public String getTextByXpath(String xpathVal) {
		String getTextByXpath = null;
		try {
			getTextByXpath = driver.findElementByXPath(xpathVal).getText();
			System.out.println("The action to get the text is successful " +getTextByXpath);
			} catch (NoSuchElementException e) {
				System.err.println("There is no such element "+xpathVal+" to get the text");
			}catch (ElementNotVisibleException e) {
				System.err.println("The element with "+xpathVal+" is not visible to get the text");
			}catch (ElementNotInteractableException e) {
				System.err.println("The element with "+xpathVal+" is currently unavailable to get the text");
			}catch (InvalidElementStateException e) {
				System.err.println("The element with "+xpathVal+" is not valid to get the text");
			}catch (StaleElementReferenceException e) {
				System.err.println("The element with "+xpathVal+" was deleted or no longer available to get the text");
			}catch (WebDriverException e) {
				System.err.println("The browser was closed due to an unknown error");
			}finally {
				takeSnap();
		}
		return getTextByXpath;
	}

	public void getAttributeValueByXpath(String xpathVal) {
		String getAttributeValueByXpath = null;
		try {
		 getAttributeValueByXpath=driver.findElementByXPath(xpathVal).getAttribute("value");
		 System.out.println("The action to get the text is successful " +getAttributeValueByXpath);
		} catch (NoSuchElementException e) {
			System.err.println("There is no such element with "+xpathVal+" to get the attribute value");
		} catch (ElementNotVisibleException e) {
			System.err.println("The element with "+xpathVal+" is not visible to get the attribute value");	
		}catch (ElementNotInteractableException e) {
			System.err.println("The element with "+xpathVal+" is currently unavailable to get the attribute value");
		}catch (InvalidElementStateException e) {
			System.err.println("The element with "+xpathVal+" is not valid to get the attribute value");
		}catch (StaleElementReferenceException e) {
			System.err.println("The element with "+xpathVal+" was deleted or no longer available to get the attribute value");
		}catch (WebDriverException e) {
			System.err.println("The browser was close due to an unknown error ");
		}finally {
			takeSnap();
		}
		}
	
	public void selectVisibileTextById(String id, String value) {
		// TODO Auto-generated method stub
		try {
			WebElement drop = driver.findElementById(id);
			Select drop1 = new Select(drop);
			drop1.selectByVisibleText(value);
			System.out.println("The Element with "+id+" is found and Entered the "+value+" successfully");
		} catch (NoSuchElementException e) {
			System.err.println("The Element with data "+id+" is not available on the page");
		}catch (ElementNotVisibleException e) {
			System.err.println("The Element with data "+id+" is not Visible within the page");
		}catch (ElementNotInteractableException e) {
			System.err.println("The Element with data "+id+" is not Interactable");
		}catch (InvalidElementStateException e) {
			System.err.println("The Element with "+id+" is not valid");
		}catch (WebDriverException e) {
			System.err.println("Browser Closed due to unknown error");
		}finally {
			takeSnap();
		}
	}

	public void selectValueById(String id, String value) {
		
		try {
			WebElement drop = driver.findElementById(id);
			Select drop1 = new Select(drop);
			drop1.selectByValue(value);
			System.out.println("The Element with "+id+" is found and Entered the "+value+" successfully");
		} catch (NoSuchElementException e) {
			System.err.println("There is no such element with the name-"+id+" to select the drop down value-"+value);
		}catch (ElementNotVisibleException e) {
			System.err.println("The element with the name-"+id+"-is not visible to select the drop down value-"+value);
		}catch (ElementNotInteractableException e) {
			System.err.println("The element with the name-"+id+"-is currently unavailable to select the drop down value-"+value);
		}catch (ElementNotSelectableException e) {
			System.err.println("The element with the name-"+id+" cannot be selected for the value-"+value);
		}catch (InvalidElementStateException e) {
			System.err.println("The element with the name-"+id+" is not valid to select the drop down value-"+value);
		}catch (StaleElementReferenceException e) {
			System.err.println("The element with the name-"+id+" is no longer available to select the drop down value-"+value);
		}catch (WebDriverException e) {
			System.err.println("The browser was close due to an unknown error");
		}finally {
			takeSnap();
		}
	}

	public void switchToParentWindow() {
		try {
		Set<String> Multiplewindows = driver.getWindowHandles();
		System.out.println(Multiplewindows);
		for (String string : Multiplewindows) {
			driver.switchTo().window(string);
		  break;
		}
	} catch (NoSuchWindowException e) {
		System.err.println("There is no such window to perform the action switch to parent window");
	} catch (WebDriverException e) {
		System.err.println("The browser was closed due to some unknown error");
	} finally {
		takeSnap();
	}
	}
	
	public void switchToLastWindow() {
		try {
		Set<String> switchToWindow = driver.getWindowHandles();
		System.out.println(switchToWindow);
		for (String string : switchToWindow) {
				driver.switchTo().window(string);
		}
			} catch (NoSuchWindowException e) {
				System.err.println("There is no such window to perform the action switch to last window");
			} catch (WebDriverException e) {
				System.err.println("The browser was closed due to some unknown error");
			} finally {
				takeSnap();
			}
	}
		
	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}

	public String getAlertText() {
		WebElement text = driver.findElementById(getAlertText());
		System.out.println(text);
		return null;
	}
	
	public void tabByXpath(String Xpathval, Keys tab_kay)
	{
		try {
			driver.findElementByXPath(Xpathval).sendKeys(Keys.TAB);
			System.out.println("The Key value performed the TAB action successfully");
		} catch (NoSuchElementException e) {
			System.err.println("There is no such element with the name-"+Xpathval+" to perform the TAB action");
		}catch (ElementNotVisibleException e) {
			System.err.println("The element with the name-"+Xpathval+"-is not visible to perform the to perform the TAB action");
		}catch (ElementNotInteractableException e) {
			System.err.println("The element with the name-"+Xpathval+"-is currently unavailable to perform the to perform the TAB action");
		}catch (InvalidElementStateException e) {
			System.err.println("The element with the name-"+Xpathval+"-is not valid to perform the to perform the TAB action");
		}catch (StaleElementReferenceException e) {
			System.err.println("The element with the name-"+Xpathval+" is no longer available to perform the to perform the TAB action");
		}catch (WebDriverException e) {
			System.err.println("The browser was close due to an unknown error");
		}	
	}

	public void closeBrowser() {
		try {
			driver.close();
			System.out.println("The Active Browser Closed Succesfully");
		} catch (NoSuchWindowException e) {
			System.err.println("There is no such window to perform the action of close browser");
		}catch (WebDriverException e) {
			System.err.println("The browser was close due to an unknown error");
		}finally {
			takeSnap();
		}
	
	}

	public void closeAllBrowsers() {
		try {
			driver.quit();
			System.out.println("All Opened Browser Closed successfully");
		} catch (NoSuchWindowException e) {
			System.err.println("There is no such windows to perform the action of close all browser");
		}catch (WebDriverException e) {
			System.err.println("The browser was close due to an unknown error");
		} finally {
			takeSnap();
		}
		
	}

	public void takeSnap() {
		// TODO Auto-generated method stub
		
	}
	
	public void waitTime(int value)
	{
		try {
			Thread.sleep(value);
		} catch (InterruptedException e) {
			System.err.println("The element with the name-\"+value+\"-\"");
		}
	}
	
	public void selectVisibleTextByName(String name, String value) {
	try {
		WebElement drop = driver.findElementByName(name);
		Select drop1 = new Select(drop);
		drop1.selectByVisibleText(value);
		System.out.println("The Element with "+name+" is found and Selected the "+value+" successfully");
	} catch (NoSuchElementException e) {
		System.err.println("There is no such element with the name-"+name+" to select the drop down value-"+value);
	}catch (ElementNotVisibleException e) {
		System.err.println("The element with the name-"+name+"-is not visible to select the drop down value-"+value);
	}catch (ElementNotInteractableException e) {
		System.err.println("The element with the name-"+name+"-is currently unavailable to select the drop down value-"+value);
	}catch (ElementNotSelectableException e) {
		System.err.println("The element with the name-"+name+" cannot be selected for the value-"+value);
	}catch (InvalidElementStateException e) {
		System.err.println("The element with the name-"+name+" is not valid to select the drop down value-"+value);
	}catch (StaleElementReferenceException e) {
		System.err.println("The element with the name-"+name+" is no longer available to select the drop down value-"+value);
	}catch (WebDriverException e) {
		System.err.println("The browser was close due to an unknown error");
	} finally {
		takeSnap();
	}
}
	
	public void selectValueByName(String name, String value) {
		try {
			WebElement drop = driver.findElementByName(name);
			Select drop1 = new Select(drop);
			drop1.selectByValue(value);
			System.out.println("The Element with "+name+" is found and Selected the "+value+" successfully");
		} catch (NoSuchElementException e) {
			System.err.println("There is no such element with the name-"+name+" to select the drop down value-"+value);
		}catch (ElementNotVisibleException e) {
			System.err.println("The element with the name-"+name+"-is not visible to select the drop down value-"+value);
		}catch (ElementNotInteractableException e) {
			System.err.println("The element with the name-"+name+"-is currently unavailable to select the drop down value-"+value);
		}catch (ElementNotSelectableException e) {
			System.err.println("The element with the name-"+name+" cannot be selected for the value-"+value);
		}catch (InvalidElementStateException e) {
			System.err.println("The element with the name-"+name+" is not valid to select the drop down value-"+value);
		}catch (StaleElementReferenceException e) {
			System.err.println("The element with the name-"+name+" is no longer available to select the drop down value-"+value);
		}catch (WebDriverException e) {
			System.err.println("The browser was close due to an unknown error");
		} finally {
			takeSnap();
		}
	}
	
	public void selectVisibleTextByXpath(String xpathVal) {
		try {
			WebElement drop = driver.findElementByXPath(xpathVal);
			Select drop1 = new Select(drop);
			drop1.selectByVisibleText(xpathVal);
			System.out.println("The Element with "+xpathVal+" is found and Selected the "+xpathVal+" successfully");
		} catch (NoSuchElementException e) {
			System.err.println("There is no such element with the name-"+xpathVal+" to select the drop down value-"+xpathVal);
		}catch (ElementNotVisibleException e) {
			System.err.println("The element with the name-"+xpathVal+"-is not visible to select the drop down value-"+xpathVal);
		}catch (ElementNotInteractableException e) {
			System.err.println("The element with the name-"+xpathVal+"-is currently unavailable to select the drop down value-"+xpathVal);
		}catch (ElementNotSelectableException e) {
			System.err.println("The element with the name-"+xpathVal+" cannot be selected for the value-"+xpathVal);
		}catch (InvalidElementStateException e) {
			System.err.println("The element with the name-"+xpathVal+" is not valid to select the drop down value-"+xpathVal);
		}catch (StaleElementReferenceException e) {
			System.err.println("The element with the name-"+xpathVal+" is no longer available to select the drop down value-"+xpathVal);
		}catch (WebDriverException e) {
			System.err.println("The browser was close due to an unknown error");
		} finally {
			takeSnap();
		}
	}
	
	public void selectValueByXpath(String xpathVal, String value) {
		try {
			WebElement drop = driver.findElementByXPath(xpathVal);
			Select drop1 = new Select(drop);
			drop1.selectByValue(value);
			System.out.println("The Element with "+xpathVal+" is found and Selected the "+value+" successfully");
		} catch (NoSuchElementException e) {
			System.err.println("There is no such element with the name-"+xpathVal+" to select the drop down value-"+value);
		}catch (ElementNotVisibleException e) {
			System.err.println("The element with the name-"+xpathVal+"-is not visible to select the drop down value-"+value);
		}catch (ElementNotInteractableException e) {
			System.err.println("The element with the name-"+xpathVal+"-is currently unavailable to select the drop down value-"+value);
		}catch (ElementNotSelectableException e) {
			System.err.println("The element with the name-"+xpathVal+" cannot be selected for the value-"+value);
		}catch (InvalidElementStateException e) {
			System.err.println("The element with the name-"+xpathVal+" is not valid to select the drop down value-"+value);
		}catch (StaleElementReferenceException e) {
			System.err.println("The element with the name-"+xpathVal+" is no longer available to select the drop down value-"+value);
		}catch (WebDriverException e) {
			System.err.println("The browser was close due to an unknown error");
		} finally {
			takeSnap();
		}
	}
	
	public void pageDownByXpath(String xpathVal, Keys pagedown) {
		try {
			driver.findElementByXPath(xpathVal).sendKeys(Keys.PAGE_DOWN);
			System.out.println("The key value performed the pagedown action successfully");
			} catch (NoSuchElementException e) {
				System.err.println("There is no such element with the name "+xpathVal+" to perform the page down action for the given key value"+pagedown);
			}catch (ElementNotVisibleException e) {
				System.err.println("The element with the name-"+xpathVal+"-is not visible to perform the page down action for the given key value"+pagedown);
			}catch (ElementNotInteractableException e) {
				System.err.println("The element with the name-"+xpathVal+"-is currently unavailable to perform the page down action for the given key value"+pagedown);
			}catch (InvalidElementStateException e) {
				System.err.println("The element with the name-"+xpathVal+"-is not valid to perform the page down action for the given key value"+pagedown);
			}catch (StaleElementReferenceException e) {
				System.err.println("The element with the name-"+xpathVal+"-was deleted or no longer available to perform the page down action for the given key value"+pagedown);
			}catch (WebDriverException e) {
				System.err.println("The browser was close due to an unknown error");
			} finally {
				takeSnap();
			}	
	}
	public void downByXpath(String xpathVal, Keys down) {
		try {
			driver.findElementByXPath(xpathVal).sendKeys(Keys.DOWN);
			System.out.println("The key value performed the down action successfully");
			} catch (NoSuchElementException e) {
				System.err.println("There is no such element with "+xpathVal+" to perform the down action for the given key value" +down);
			}catch (ElementNotVisibleException e) {
				System.err.println("The element with the name-"+xpathVal+"-is not visible to perform the down action for the given key value" +down);
			}catch (ElementNotInteractableException e) {
				System.err.println("The element with the name-"+xpathVal+"-is currently unavailable to perform the down action for the given key value" +down);
			}catch (InvalidElementStateException e) {
				System.err.println("The element with the name-"+xpathVal+"-is not valid to perform the down action for the given key value" +down);
			}catch (StaleElementReferenceException e) {
				System.err.println("The element with the name-"+xpathVal+"-was deleted or no longer available to perform the down action for the given key value" +down);
			}catch (WebDriverException e) {
				System.err.println("The browser was close due to an unknown error");
			} finally {
				takeSnap();
			}	
	}

	public void selectByValueId(String id, String value) {
		try {
			WebElement drop = driver.findElementById(id);
			Select drop1 = new Select(drop);
			drop1.selectByValue(value);
			System.out.println("The Element with "+id+" is found and Selected the "+value+" successfully");
		} catch (NoSuchElementException e) {
			System.err.println("There is no such element with the name-"+id+" to select the drop down value-"+value);
		}catch (ElementNotVisibleException e) {
			System.err.println("The element with the name-"+id+"-is not visible to select the drop down value-"+value);
		}catch (ElementNotInteractableException e) {
			System.err.println("The element with the name-"+id+"-is currently unavailable to select the drop down value-"+value);
		}catch (ElementNotSelectableException e) {
			System.err.println("The element with the name-"+id+" cannot be selected for the value-"+value);
		}catch (InvalidElementStateException e) {
			System.err.println("The element with the name-"+id+" is not valid to select the drop down value-"+value);
		}catch (StaleElementReferenceException e) {
			System.err.println("The element with the name-"+id+" is no longer available to select the drop down value-"+value);
		}catch (WebDriverException e) {
			System.err.println("The browser was close due to an unknown error");
		} finally {
			takeSnap();
		}
		
	}

	public void watTime(int value) {
		try {
			Thread.sleep(value);
		} catch (InterruptedException e) {
			System.out.println("The element with the "+value);
		}
	}

	public void selectIndexByName(String name, int index) {
		// TODO Auto-generated method stub
		WebElement obj1 = driver.findElementByName(name);
		Select obj = new Select(obj1);
		obj.selectByIndex(index);
		
		
	}

	public void enterByXpath(String xpathValue, String data) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(xpathValue).sendKeys(data);
			System.out.println("The Element with "+xpathValue+" is found and Entered the "+data+" successfully");
		} catch (NoSuchElementException e) {
			System.err.println("The Element with data "+xpathValue+" is not available on the page");
		}catch (ElementNotVisibleException e) {
			System.err.println("The Element with data "+xpathValue+" is not Visible within the page");
		}catch (ElementNotInteractableException e) {
			System.err.println("The Element with data "+xpathValue+" is not Interactable");
		}catch (InvalidElementStateException e) {
			System.err.println("The Element with "+xpathValue+" is not Visible");
		}catch (WebDriverException e) {
			System.err.println("Browser Closed due to unknown error");
		}finally {
			takeSnap();
		}
	}

	public void selectVisibleTextByXpath(String xpathVal, String value) {
		// TODO Auto-generated method stub
		try {
			WebElement drop = driver.findElementByXPath(xpathVal);
			Select drop1 = new Select(drop);
			drop1.selectByVisibleText(value);
			System.out.println("The Element with "+xpathVal+" is found and Entered the "+value+" successfully");
		} catch (NoSuchElementException e) {
			System.err.println("The Element with data "+xpathVal+" is not available on the page");
		}catch (ElementNotVisibleException e) {
			System.err.println("The Element with data "+xpathVal+" is not Visible within the page");
		}catch (ElementNotInteractableException e) {
			System.err.println("The Element with data "+xpathVal+" is not Interactable");
		}catch (InvalidElementStateException e) {
			System.err.println("The Element with "+xpathVal+" is not valid");
		}catch (WebDriverException e) {
			System.err.println("Browser Closed due to unknown error");
		}finally {
			takeSnap();
		}
	}
}

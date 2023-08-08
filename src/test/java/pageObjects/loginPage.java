package pageObjects;

import static org.junit.Assert.assertTrue;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;



import utility.utility;

public class loginPage extends utility {
	WebDriver driver;

	public loginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='navigation-top-menu-label navigation-top-menu-label-arrow'][contains(text(),'My account ')]")
	WebElement LoginIcon;
	@FindBy(xpath = "//span[@class='navigation-top-menu-label'][contains(text(),'Log in')]")
	WebElement LoginLink;
	@FindBy(id = "Username")
	WebElement Username;
	@FindBy(name = "Password")

	WebElement Password;
	@FindBy(xpath = "//input[@value='Log in']")
	WebElement LoginButton;
	@FindBy(xpath="//span[contains(text(),'Product')]")
	WebElement Product;
	@FindBy(xpath="//span[contains(text(),'Features')]")
	WebElement Features;
	public void clickOnLoginLink(String message) {
		Actions act = new Actions(driver);
		act.moveToElement(LoginIcon).build().perform();
		LoginLink.click();
	}

	public void setUserName(String UName, String message) {
		explicitWait(driver, Username);
		Username.clear();
		Username.sendKeys(UName);
	}

	public void setPassword(String Pword, String message) {
		explicitWait(driver, Password);
		Password.clear();
		enterValue(driver, Password, Pword, message);
	}

	public void ClickOnLoginButton( String message) {
		explicitWait(driver, LoginButton);
		click(driver, LoginButton,  message);
	}

	public void verifyPagetitle(String title, String message) {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("The title of the page is:" + driver.getTitle());
		Assert.assertEquals(driver.getTitle(), title);

	}



	public void VerifyPageTitle( String string) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url = driver.getCurrentUrl();
		System.out.println("User navigated to :"+url);
		Assert.assertEquals(url, "https://www.nopcommerce.com/en/");

	}

	public void navigateTourl(WebDriver driver2, String string, String string2) {
		launchUrl(driver, string, string2);
		
	}

	public void clickOnFeatures(String string) {
		Actions act = new Actions(driver);
		act.moveToElement(Product).build().perform();
		click(driver, Features, string);
		
	}

	public void VerifyFeaturePage(String string) {
		String url=driver.getCurrentUrl();
		Assert.assertTrue(url.contains("features"));
		
	}

}

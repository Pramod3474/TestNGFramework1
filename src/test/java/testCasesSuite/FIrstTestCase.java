package testCasesSuite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.loginPage;
import utility.TestBaseWeb;

public class FIrstTestCase extends TestBaseWeb {
	loginPage lp;

	@BeforeClass
	void AfterClass() {
		System.out.println("---------------------------------------------");
		System.out.println("Starting the execution");
	}

	@AfterClass
	void BeofreClass() {
		System.out.println("---------------------------------------------");
		System.out.println("Ending the execution");
	}

	@BeforeMethod
	void BrowserSetUp() {
		System.out.println("Will set up Browser here");
		intilize();

	}

	@AfterMethod
	void BrowserTearUp() {
		System.out.println("Will close teh broser Browser here");
		driver.close();
	}

	@Test(alwaysRun=true)
	void Login() {
		lp = new loginPage(driver);
		
		lp.navigateTourl(driver, "https://www.nopcommerce.com/en/", "Launch the URL");
		lp.clickOnLoginLink("Click on login Link");
		lp.setUserName("pramod3474@gmail.com", "I enter Valid User Name");
		lp.setPassword("Pramod@3474", "I enter Valid Password");
		lp.ClickOnLoginButton("I click on login link");
		lp.VerifyPageTitle("I verify page title was as expeted");
	}
	@Test(alwaysRun=true)
	void HomePageValidation() {
		lp = new loginPage(driver);
		
		lp.navigateTourl(driver, "https://www.nopcommerce.com/en/", "Launch the URL");
		lp.clickOnLoginLink("Click on login Link");
		System.out.println("Entering Username");
		lp.setUserName("pramod3474@gmail.com", "I enter Valid User Name");
		lp.setPassword("Pramod@3474", "I enter Valid Password");
		lp.ClickOnLoginButton("I click on login link");
		lp.VerifyPageTitle("I verify page title was as expeted");
		lp.clickOnFeatures("I click on Features under Product");
		lp.VerifyFeaturePage("I Verify Feature Page");
		
	}

}

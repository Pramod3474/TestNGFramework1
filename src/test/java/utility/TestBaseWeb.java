package utility;

import java.io.File;


import java.util.ResourceBundle;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBaseWeb {
	public static File file;
	public static WebDriver driver;
	private static final String RUN_CONFIG_PROPERTIES = "/environment.properties";
	/*static {
		LoadProperties.loadRunConfigProps(RUN_CONFIG_PROPERTIES);
	}*/

	public void intilize() {
		System.out.println("browser SetUp");
		//ResourceBundle rb = ResourceBundle.getBundle("environment");
		//String browser = rb.getString("browser");
		String browser="chrome";

		file = new File(System.getProperty("user.dir") + "/TestData/" + "TestResult.json");

		switch (browser) {
		case "chrome":

			ChromeOptions chromeOptions = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(chromeOptions);
			break;
		case "firefox":

			FirefoxOptions fx = new FirefoxOptions();
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(fx);
			break;
		default:
			System.out.println("No Browser configured");
		}
	}
}
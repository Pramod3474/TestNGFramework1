package utility;


import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.AssumptionViolatedException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;



public class utility {
	public void explicitWait(WebDriver dr, WebElement elm) {
		if (elm != null) {
			try {
				WebDriverWait wait = new WebDriverWait(dr, 30);
				wait.until(ExpectedConditions.visibilityOf(elm));
				utility.highlightElement(dr, elm);
			} catch (Exception e) {

			}
		}

	}
	public void launchUrl(WebDriver driver,String url, String message) {
		System.out.println("User Launched :"+url);
		driver.get(url);
		driver.manage().window().maximize();

	}
	public static void highlightElement(WebDriver dr, WebElement elm) {
		JavascriptExecutor js = (JavascriptExecutor) dr;
		js.executeScript("arguments[0].setAttribute('style','border: 1.5px solid red;');", elm);
	}

	protected void click(WebDriver driver, WebElement elm,String message) {
		try {
			highlightElement(driver, elm);
			new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(elm));
			if (elm.isDisplayed()) {
				elm.click();
				

			} else {
				

			}

		} catch (Exception e) {
			e.printStackTrace();
			
			throw e;
		}
	}

	protected void enterValue(WebDriver driver, WebElement Elm, String Value,  String message) {
		try {
			new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(Elm));
			highlightElement(driver, Elm);
			if (Elm.isDisplayed()) {
				Elm.clear();
				Elm.sendKeys(Value);
				
			} else {
				
			}

		} catch (Exception e) {
			e.printStackTrace();
			
			throw e;
		}
	}
	public static void writeInJson(String key, String value, File file) {
		try {
			
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader(file));
			JSONObject testResultDetails = (JSONObject) obj;
			JSONArray arr = (JSONArray) testResultDetails.get("TestResult");
			System.out.println(testResultDetails);
			JSONObject testResultTemp = new JSONObject();
			testResultTemp.put("TestCaseID", key);
			testResultTemp.put("Result", value);
			arr.add(testResultTemp);
			JSONObject testResult = new JSONObject();
			testResult.put("TestResult", arr);
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.append(testResult.toJSONString());
			fileWriter.flush();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}

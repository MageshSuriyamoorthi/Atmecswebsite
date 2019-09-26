package com.assessment.atmecs.utils;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.assessment.atmecs.classpath.Constants;
import com.assessment.atmecs.helper.ReadpropertiesFile;
import com.assessment.atmecs.helper.XlxsReader;
import com.assessment.atmecs.reports.log4j;
import com.assessment.atmecs.testbase.BrowserInvoke;

public class UtilityFiles extends BrowserInvoke {

	WebElement element;
	String getval;
	public static ReadpropertiesFile readprop = new ReadpropertiesFile();
	public static log4j logreports = new log4j();
	public static XlxsReader testread = UtilityFiles.getXlsReader(Constants.Excel_file_one);
	public static XlxsReader testreader = UtilityFiles.getXlsReader(Constants.Excel_file_two);

	public void geturl(String string) {
		driver.get(string);
	}

	public void maximize() {
		driver.manage().window().maximize();
	}

	public void ClickElement(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	public void selectDropdown(String xpath, int index) {
		element = driver.findElement(By.xpath(xpath));
		Select months = new Select(element);
		months.selectByIndex(index);
	}

	public void enterText(String Xpath, String name, int index) {
		String val = testread.getCellDataByColumnName("Sheet1", name, index);
		driver.findElement(By.xpath(Xpath)).sendKeys(val);

	}

	public String scrollintoview(String Xpath) {
		WebElement element = driver.findElement(By.xpath(Xpath));
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		javascript.executeScript("window.scrollBy(0,1000)");
		javascript.executeScript("arguments[0].scrollIntoView();", element);
		return Xpath;

	}

	public boolean verifyTrue(boolean condition, String message) {
		boolean result = false;
		try {
			Assert.assertTrue(condition);
			logreports.info("PASS : " + message);
			System.out.println("PASS : " + message);
			// Reporter.log("PASS : " + message);
			result = true;
		} catch (AssertionError assertionError) {

			result = false;
		}
		return result;

	}

	public static boolean isDisplayed(String Xpath) {
		boolean isdisplayed = false;

		isdisplayed = driver.findElement(By.xpath(Xpath)).isDisplayed();
		if (isdisplayed = true) {
			return isdisplayed;
		}
		else {
			return false;
		}
	}

	public static String getactual(String Xpath) {
		String getstring = driver.findElement(By.xpath(Xpath)).getText();
		return getstring;
	}

	public static List<String> getexpected(String symbol) {
		String data = readprop.getValue("test.data");
		String[] contents = data.split(symbol);
		List<String> list = new ArrayList<String>();
		for (String arr : contents)
			list.add(arr);
		return list;
	}

	public static XlxsReader getXlsReader(String testDataFile) {
		XlxsReader xlsReader = new XlxsReader();

		try {
			xlsReader.setPath(testDataFile);
		} catch (IOException ioException) {
			return null;
		}
		return xlsReader;
	}

	public static String expectedresult(String Xpath, int beginindex, int endindex) {
		String name = driver.findElement(By.xpath(Xpath)).getText().substring(beginindex, endindex);
		return name;
	}

	public static String testresult(String sheetno, String sheetname, int index) {
		String dataname = testread.getCellDataByColumnName(sheetno, sheetname, index);
		System.out.println(dataname);
		return dataname;
	}

	public static String dataresult(String sheetno, String sheetname, int index) {
		String dataname = testread.getCellDataByColumnName(sheetno, sheetname, index);
		logreports.info(dataname);
		return dataname;
	}

	public static String datares(String sheetno, String sheetname, int index) {
		String dataname = testread.getCellDataByColumnName(sheetno, sheetname, index);
		logreports.info(dataname);
		return dataname;
	}

	public void assertequals(String actual, String expected, String message) {

		assertEquals(actual, expected);
		logreports.info(message);
	}

	public void entertext(String Xpath, String text) {
		// TODO Auto-generated method stub
		driver.findElement(By.xpath(Xpath)).sendKeys(text);
	}

	public void selectbyvisibility(String Xpath, String name, int index) {
		String value = testread.getCellDataByColumnName("Sheet1", name, index);
		WebElement element = driver.findElement(By.xpath(Xpath));
		Select se = new Select(element);
		se.selectByVisibleText(value);
	}

	public String locateval(String sheet, String name, int index) {
		String value = testread.getCellDataByColumnName(sheet, name, index);
		logreports.info("Expected " + value);
		return value;
	}

	public String locatevals(String Xpath) {
		String value = driver.findElement(By.xpath(Xpath)).getText();
		logreports.info("Actual " + value);
		return value;
	}

	public void assertequals(String actual, List<WebElement> expected, String message) {
		// TODO Auto-generated method stub
		assertEquals(actual, expected);
		logreports.info(message);

	}

	public boolean mouseHoverTotab(String xPath) {
		WebElement webElement = driver.findElement(By.xpath(xPath));
		Actions action = new Actions(driver);
		action.moveToElement(webElement);

		return true;
	}

}

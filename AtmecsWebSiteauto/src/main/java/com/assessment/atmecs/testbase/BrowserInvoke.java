package com.assessment.atmecs.testbase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.assessment.atmecs.classpath.Constants;
import com.assessment.atmecs.helper.ReadpropertiesFile;

public class BrowserInvoke {
	Logger log = Logger.getLogger("utilityfiles");
	public ReadpropertiesFile prop = new ReadpropertiesFile();
	public static WebDriver driver;
	String browser;

	@SuppressWarnings("deprecation")
	public void OpenBrowser() {
		browser = prop.getValue("browsername");

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("Webdriver.chrome.driver", Constants.Chrome_file);
			driver = new ChromeDriver();
			log.info("chrome has started");

		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("Webdriver.gecko.driver", Constants.Firefox_file);
			driver = new FirefoxDriver();
		}

		else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.edge.driver", Constants.IE_file);
			DesiredCapabilities ieCaps = DesiredCapabilities.internetExplorer();
			ieCaps.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "http://www.bing.com/");
			driver = new InternetExplorerDriver(ieCaps);

		}
		// properties.loadproperty("browser").
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void BrowserClose() {
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.close();
	}
}
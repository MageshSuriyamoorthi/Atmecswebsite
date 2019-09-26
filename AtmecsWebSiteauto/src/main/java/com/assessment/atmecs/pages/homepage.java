package com.assessment.atmecs.pages;

import java.util.concurrent.TimeUnit;

import com.assessment.atmecs.classpath.Constants;
import com.assessment.atmecs.helper.ReadpropertiesFile;
import com.assessment.atmecs.helper.XlxsReader;
import com.assessment.atmecs.testbase.BrowserInvoke;
import com.assessment.atmecs.utils.UtilityFiles;

public class homepage extends BrowserInvoke {
	String crt_locator;
	BrowserInvoke brow = new BrowserInvoke();
	public ReadpropertiesFile prop = new ReadpropertiesFile();
	UtilityFiles util = new UtilityFiles();
	public static XlxsReader reader = UtilityFiles.getXlsReader(Constants.Excel_file_one);

	public void atmecshome() {
		crt_locator = prop.getValue("locator.locatorname");
		util.geturl(prop.getValue("homepage.url"));
		util.maximize();

	}

	public void aboutusTab() {
		util.ClickElement(prop.getValue("locator.atmecs.aboutus"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		util.scrollintoview(prop.getValue("locator.atmecs.footer"));

	}

	public void serviceTab() {
		util.ClickElement(prop.getValue("locator.atmecs.servicetab"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		util.scrollintoview(prop.getValue("locator.atmecs.footer"));

	}

	public void partnerTab() {
		util.ClickElement(prop.getValue("locator.atmecs.partnertab"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		util.scrollintoview(prop.getValue("locator.atmecs.footer"));

	}

	public void mediaTab() {
		util.ClickElement(prop.getValue("locator.atmecs.mediatab"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		util.scrollintoview(prop.getValue("locator.atmecs.footer"));

	}

	public void insightTab() {
		util.ClickElement(prop.getValue("locator.atmecs.insighttab"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		util.scrollintoview(prop.getValue("locator.atmecs.footer"));

	}

	public void careersTab() {
		util.ClickElement(prop.getValue("locator.atmecs.careertab"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		util.scrollintoview(prop.getValue("locator.atmecs.footer"));

	}

	public void contactusTab() {
		util.ClickElement(prop.getValue("locator.atmecs.contactustab"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		util.scrollintoview(prop.getValue("locator.atmecs.footer"));

	}

}
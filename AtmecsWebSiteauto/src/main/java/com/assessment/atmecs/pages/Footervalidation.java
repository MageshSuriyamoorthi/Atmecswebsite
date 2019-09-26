package com.assessment.atmecs.pages;

import com.assessment.atmecs.classpath.Constants;
import com.assessment.atmecs.helper.ReadpropertiesFile;
import com.assessment.atmecs.helper.XlxsReader;
import com.assessment.atmecs.testbase.BrowserInvoke;
import com.assessment.atmecs.utils.UtilityFiles;

public class Footervalidation {
	int num;
	String expected, actual;
	BrowserInvoke brow = new BrowserInvoke();
	public ReadpropertiesFile prop = new ReadpropertiesFile();
	UtilityFiles util = new UtilityFiles();
	public static XlxsReader reader = UtilityFiles.getXlsReader(Constants.Excel_file_one);

	public void footerval() {

		for (num = 1; num <= 4; num++) {
			expected = util.locateval("Sheet1","Title", num);
			actual = util.locatevals((prop.getValue("locator.footer.heading").replace("****", expected)));
		}
		util.assertequals(actual, expected, "Title verified");
		for (num = 1; num <= 8; num++) {
			expected = util.locateval("Sheet1","Sitemap", num);
			actual = util.locatevals((prop.getValue("locator.footer.elements").replace("***", expected)));
		}
		util.assertequals(actual, expected, "Sitemap elements verified");
		for (int num = 1; num <= 10; num++) {
			expected = util.locateval("Sheet1","Services", num);
			actual = util.locatevals((prop.getValue("locator.footer.elements").replace("***", expected)));
		}
		util.assertequals(actual, expected, "Services elements verified");
		for (num = 1; num <= 4; num++) {
			expected = util.locateval("Sheet1","Careers", num);
			actual = util.locatevals((prop.getValue("locator.footer.elements").replace("***", expected)));
		}
		util.assertequals(actual, expected, "Element verified");
		for (num = 1; num <= 7; num++) {
			expected = util.locateval("Sheet1","Contact Us", num);
			actual = util.locatevals((prop.getValue("locator.footer.elements").replace("***", expected)));
		}
		util.assertequals(actual, expected, "Element verified");
	}
}
package com.assessment.atmecs.pages;

import com.assessment.atmecs.helper.ReadpropertiesFile;
import com.assessment.atmecs.utils.UtilityFiles;

public class Innsightpage {
	String replace;
	UtilityFiles util = new UtilityFiles();
	public ReadpropertiesFile prop = new ReadpropertiesFile();

	public void blogs() {

		util.mouseHoverTotab(prop.getValue("locator.insight.path"));

		util.ClickElement(prop.getValue("locator.insight.blog"));

		for (int num = 1; num <= 6; num++) {
			replace = util.locateval("Sheet2", "num", num);
			System.out.println(replace);
			util.ClickElement((prop.getValue("locator.footer.elements").replace("**", replace)));
			replace = util.locateval("Sheet2", "title", num);
			System.out.println(replace);
			UtilityFiles.isDisplayed(prop.getValue("locator.blog.heading").replace("####", replace));
		}
	}

}

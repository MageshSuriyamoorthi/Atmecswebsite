package com.assessment.atmecs.testscript;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.assessment.atmecs.pages.Footervalidation;
import com.assessment.atmecs.pages.homepage;
import com.assessment.atmecs.testbase.BrowserInvoke;

public class Homepagescript {
	BrowserInvoke browse = new BrowserInvoke();
	homepage home = new homepage();
	Footervalidation foot = new Footervalidation();

	@BeforeTest
	public void openBrowser() {
		browse.OpenBrowser();
	}

	@Test
	public void home() {

		home.atmecshome();
		foot.footerval();

		home.aboutusTab();
		foot.footerval();

		home.serviceTab();
		foot.footerval();

		home.partnerTab();
		foot.footerval();

		home.mediaTab();
		foot.footerval();

		home.insightTab();
		foot.footerval();

		home.careersTab();
		foot.footerval();

		home.contactusTab();
		foot.footerval();
	}
}

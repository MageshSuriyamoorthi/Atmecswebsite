package com.assessment.atmecs.testscript;

import org.testng.annotations.Test;

import com.assessment.atmecs.helper.ReadpropertiesFile;
import com.assessment.atmecs.pages.Innsightpage;
import com.assessment.atmecs.utils.UtilityFiles;

public class InsightScript {
	Innsightpage insight = new Innsightpage();

	@Test(priority = 1)
	void Insightsvalidation() {
		insight.blogs();
	}
}

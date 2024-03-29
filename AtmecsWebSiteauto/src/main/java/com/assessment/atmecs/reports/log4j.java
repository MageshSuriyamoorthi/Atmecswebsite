package com.assessment.atmecs.reports;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.assessment.atmecs.classpath.Constants;

/**
 * Configure the log4j file path.
 */

public class log4j {

	Logger logger = null;

	public log4j() {
		getlogger();
		logger = Logger.getLogger(log4j.class.getName());
	}

	public void getlogger() {
		PropertyConfigurator.configure(Constants.log4j_file);
	}

	public void info(String message) {
		logger.info(message);
	}
	public void infoboo(boolean message) {
		logger.info(message);
	}

}

package com.crm.qa.utils.extentreports;

import java.io.File;

import com.crm.qa.utils.commonutils.TestConfig;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

	private static ExtentReports extent;

	public synchronized static ExtentReports getreport() {
		if (extent == null) {

			extent = new ExtentReports(TestConfig.extentReportPath, true);
			extent.loadConfig(new File(TestConfig.extentReportConfigPath));

		}
		return extent;

	}

}

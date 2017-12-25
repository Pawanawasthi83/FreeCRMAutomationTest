package com.crm.qa.utils.extentreports;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

	private static ExtentReports extent;

	public synchronized static ExtentReports getreport() {
		if(extent == null){
		String filePath = System.getProperty("user.dir") + File.separator + "ExtentReports" + File.separator
				+ "ExtentReportsResults.html";
		extent = new ExtentReports(filePath, true);
		String configfilepath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
				+ File.separator + "java" + File.separator + "com" + File.separator + "crm" + File.separator + "qa"
				+ File.separator + "config" + File.separator + "extent-config.xml";
		File configFile = new File(configfilepath);
		extent.loadConfig(configFile);
		}
		return extent;

	}

}

package com.crm.qa.utils.extentreports;

import java.util.HashMap;
import java.util.Map;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentTestManager {

	static Map<Long, ExtentTest> extentTestMap = new HashMap<Long, ExtentTest>();
	static ExtentReports extent = ExtentManager.getreport();

	public synchronized static ExtentTest startTest(String testName, String desc) {
		ExtentTest test = extent.startTest(testName, desc);
		extentTestMap.put(Thread.currentThread().getId(), test);
		return test;
	}

	public synchronized static void endTest() {
		extent.endTest(extentTestMap.get(Thread.currentThread().getId()));
	}

	public synchronized static ExtentTest getTest() {
		return extentTestMap.get(Thread.currentThread().getId());
	}
}

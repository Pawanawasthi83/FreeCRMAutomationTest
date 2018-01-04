package com.crm.qa.utils.commonutils;

import java.io.File;

public class TestConfig {

	public static long PAGE_LOAD_TIMEOUT = 120;
	public static long IMPLICIT_WAIT = 60;
	public static long EXPLICIT_WAIT = 60;

	public static String configPropertyPath = System.getProperty("user.dir") + File.separator + "src" + File.separator
			+ "main" + File.separator + "java" + File.separator + "com" + File.separator + "crm" + File.separator + "qa"
			+ File.separator + "config" + File.separator + "config.properties";
	public static String screenShotPath = System.getProperty("user.dir") + File.separator + "screenshots"
			+ File.separator;
	public static String testDataFile = System.getProperty("user.dir") + File.separator + "src" + File.separator
			+ "main" + File.separator + "java" + File.separator + "com" + File.separator + "crm" + File.separator + "qa"
			+ File.separator + "testdata" + File.separator + "TestData_Sheet.xlsx";
	public static String chromeDriverPath = System.getProperty("user.dir") + File.separator + "src" + File.separator
			+ "main" + File.separator + "resources" + File.separator + "Drivers" + File.separator + "chromedriver.exe";
	public static String ieDriverPath = System.getProperty("user.dir") + File.separator + "src" + File.separator
			+ "main" + File.separator + "resources" + File.separator + "Drivers" + File.separator
			+ "IEDriverServer.exe";
	public static String operaDriverPath = System.getProperty("user.dir") + File.separator + "src" + File.separator
			+ "main" + File.separator + "resources" + File.separator + "Drivers" + File.separator + "operadriver"
			+ File.separator + "operadriver.exe";
	public static String fireFoxLogsPath = System.getProperty("user.dir") + File.separator + "Logs" + File.separator
			+ "fireFoxBrowserLogs.log";
	public static String fireFoxBinary = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";
	public static String chromeLogsPath = System.getProperty("user.dir") + File.separator + "Logs" + File.separator
			+ "chromeBrowserlogs.log";
	public static String ieLogsPath = System.getProperty("user.dir") + File.separator + "Logs" + File.separator
			+ "ieBrowserlogs.log";
	public static String operaLogsPath = System.getProperty("user.dir") + File.separator + "Logs" + File.separator
			+ "operaBrowserlogs.log";
	public static String phantomJSLogsPath = System.getProperty("user.dir") + File.separator + "Logs" + File.separator
			+ "phantomJSlogs.log";
	public static String downloadDirPath = System.getProperty("user.dir") + File.separator + "downloads";
	public static String extentReportPath = System.getProperty("user.dir") + File.separator + "ExtentReports" + File.separator
			+ "ExtentReportsResults.html";
	public static String extentReportConfigPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
			+ File.separator + "java" + File.separator + "com" + File.separator + "crm" + File.separator + "qa"
			+ File.separator + "config" + File.separator + "extent-config.xml";
	public static String phantomJSBinaryPath = System.getProperty("user.dir") + File.separator + "src" + File.separator
			+ "main" + File.separator + "resources" + File.separator + "Drivers" + File.separator + "phantomjs.exe";
}

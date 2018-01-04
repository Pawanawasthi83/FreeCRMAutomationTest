package com.crm.qa.base;

import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.crm.qa.utils.commonutils.TestConfig;

public class DesiredCapabilitiesManager extends TestBase{

	public static DesiredCapabilities firefoxDC() {

		System.setProperty("webdriver.firefox.logfile", TestConfig.fireFoxLogsPath);
		DesiredCapabilities caps = DesiredCapabilities.firefox();
		caps.setBrowserName("firefox");
		caps.setVersion("46");
		caps.setPlatform(Platform.WIN8);
		caps.setCapability(FirefoxDriver.BINARY, TestConfig.fireFoxBinary);
		caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
		caps.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
		caps.setCapability(FirefoxDriver.PROFILE, FireFoxProfile.fireFoxProfile());
		// caps.setCapability(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,
		// TestConfig.fireFoxLogsPath);
		return caps;

	}

	public static DesiredCapabilities InterNetExplorerDC() {

		DesiredCapabilities caps = DesiredCapabilities.internetExplorer();

		caps.setCapability(CapabilityType.BROWSER_NAME, "internet explorer");
		caps.setCapability(CapabilityType.VERSION, "10");
		caps.setCapability(CapabilityType.PLATFORM, Platform.WIN8);
		caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		caps.setCapability(CapabilityType.ENABLE_PROFILING_CAPABILITY, true);
		caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
		caps.setCapability(InternetExplorerDriver.BROWSER_ATTACH_TIMEOUT, 5000);
		caps.setCapability(InternetExplorerDriver.ELEMENT_SCROLL_BEHAVIOR, 0);
		caps.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
		caps.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);
		caps.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, false);
		caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		caps.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		caps.setCapability(InternetExplorerDriver.LOG_FILE, TestConfig.ieLogsPath);
		caps.setCapability(InternetExplorerDriver.LOG_LEVEL, "INFO");
		caps.setCapability(InternetExplorerDriver.NATIVE_EVENTS, true);
		caps.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);

		return caps;

	}

	public static DesiredCapabilities chromeDC() {
		System.setProperty("webdriver.chrome.logfile", TestConfig.chromeLogsPath);
		ChromeOptions options = new ChromeOptions();
		// options.addArguments("start-maximized");
		options.addArguments("--headless");
		// options.setBinary("/path/to/other/chrome/binary");
		// options.addArguments("--enable-logging");
		// options.addArguments("--log-level=0");
		// options.addArguments("--log-path="+TestConfig.chromeLogsPath);
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setBrowserName("chrome");
		caps.setPlatform(Platform.WIN8);
		caps.setVersion("");
		caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
		caps.setCapability(ChromeOptions.CAPABILITY, options);
		return caps;

	}

	public static DesiredCapabilities operaDC() {
		System.setProperty("webdriver.opera.logfile", TestConfig.operaLogsPath);

		OperaOptions options = new OperaOptions();
		options.setBinary("C:\\Program Files\\Opera\\49.0.2725.47\\opera.exe");
		DesiredCapabilities caps = DesiredCapabilities.opera();
		caps.setBrowserName("Opera");
		caps.setVersion("");
		caps.setPlatform(Platform.WIN8);
		caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
		// caps.setCapability("opera.binary","C:\\Program
		// Files\\Opera\\49.0.2725.47\\opera.exe");
		// caps.setCapability("opera.logging.level","ALL");
		// caps.setCapability("opera.logging.file",TestConfig.operaLogsPath);
		caps.setCapability(ChromeOptions.CAPABILITY, options);
		return caps;

	}

	public static DesiredCapabilities htmlUnitDriverDC() {

		DesiredCapabilities caps = DesiredCapabilities.htmlUnit();
		caps.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
		// caps.setCapability(HtmlUnitDriver.INVALIDXPATHERROR, true);
		return caps;

	}

	public static DesiredCapabilities phantomJSDC() {
		
		String[] phantomArgs = {"--webdriver-logfile="+TestConfig.phantomJSLogsPath};
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setJavascriptEnabled(true);
		caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, TestConfig.phantomJSBinaryPath);
		caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomArgs);
		return caps;

	}
}

package com.crm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.utils.commonutils.TestHelper;
import com.crm.qa.utils.listeners.WebDriverEventListener;;

public class TestBase {

	private  static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	public static Properties prop;

	public TestBase() {
		String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator
				+ "java" + File.separator + "com" + File.separator + "crm" + File.separator + "qa" + File.separator
				+ "config" + File.separator + "config.properties";

		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(path);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization(String browser) {
		// String browserName=prop.getProperty("browser");
		String browserName = browser;
		System.out.println("Setting browser :  " + browserName);
		if (browserName.equalsIgnoreCase("FF")) {
			
			System.setProperty("webdriver.firefox.logfile", System.getProperty("user.dir") + File.separator + "Logs"
					+ File.separator + "FireFoxBrowser_logs.log");
			//System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
			FirefoxBinary binary = new FirefoxBinary(new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe"));
			FirefoxProfile profile = new FirefoxProfile();
			
			driver.set(new FirefoxDriver(binary, profile));
		} else if (browserName.equalsIgnoreCase("chrome")) {
			String chromeDriverPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
					+ File.separator + "resources" + File.separator + "Drivers" + File.separator + "chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("ie")) {
			
				System.out.println("Launchng IE");
				String ieDriverPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
						+ File.separator + "resources" + File.separator + "Drivers" + File.separator
						+ "IEDriverServer.exe";
				System.out.println(ieDriverPath);
				System.setProperty("webdriver.ie.driver", ieDriverPath);
				DesiredCapabilities IEcaps = DesiredCapabilities.internetExplorer();
				IEcaps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				
				driver.set(new InternetExplorerDriver(IEcaps));
			
		} else if (browserName.equalsIgnoreCase("safari")) {

			driver.set(new SafariDriver());

		} else if (browserName.equalsIgnoreCase("opera")) {
			String operaDriverPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
					+ File.separator + "resources" + File.separator + "Drivers" + File.separator + "operadriver"
					+ File.separator + "operadriver.exe";
			System.out.println(operaDriverPath);
			System.setProperty("webdriver.opera.driver", operaDriverPath);
			OperaOptions options = new OperaOptions();
			options.setBinary(new File("C:\\Program Files\\Opera\\49.0.2725.47\\opera.exe"));
			// driver = new OperaDriver(options);
			driver.set(new OperaDriver(options));
			
		} else {
			System.out.println("Browser Not Supported");
		}

		EventFiringWebDriver e_driver = new EventFiringWebDriver(driver.get());
		WebDriverEventListener listerner = new WebDriverEventListener();
		e_driver.register(listerner);
		driver.set(e_driver);
		// getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().pageLoadTimeout(TestHelper.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		getDriver().manage().timeouts().implicitlyWait(TestHelper.IMPLICIT_WAIT, TimeUnit.SECONDS);
		getDriver().get(prop.getProperty("URL"));
	}

	public static WebDriver getDriver() {
		return driver.get();
	}

}

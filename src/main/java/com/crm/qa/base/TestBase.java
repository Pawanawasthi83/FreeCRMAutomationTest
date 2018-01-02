package com.crm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;


import com.crm.qa.utils.commonutils.TestConfig;
import com.crm.qa.utils.listeners.WebDriverEventListener;;

public class TestBase extends DesiredCapabilitiesManager {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	public static Properties prop;
	FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	

	public TestBase() {
		log.debug("Initializing Constructor Of The Base Class ");
		try {
			prop = new Properties();
			File file = new File(TestConfig.configPropertyPath);
			if (file.exists()) {
				fis = new FileInputStream(file);
			} else {
				log.error("File Not Found At Location : " + TestConfig.configPropertyPath);
				
			}
			prop.load(fis);
		} catch (FileNotFoundException e) {
			log.error("File Not Found : ",e);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization(String browserName) {
		log.debug("Initializing Web Driver For Browser : "+browserName);
		if (browserName.equalsIgnoreCase("FF")) {
			driver.set(new FirefoxDriver(firefoxDC()));
		} else if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", TestConfig.chromeDriverPath);
			driver.set(new ChromeDriver(chromeDC()));
		} else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", TestConfig.ieDriverPath);
			driver.set(new InternetExplorerDriver(InterNetExplorerDC()));
		} else if (browserName.equalsIgnoreCase("safari")) {
			driver.set(new SafariDriver());
		} else if (browserName.equalsIgnoreCase("opera")) {
			System.setProperty("webdriver.opera.driver", TestConfig.operaDriverPath);
			driver.set(new OperaDriver(operaDC()));
		} else {
			log.debug(browserName+"Not Supported");
		}

		EventFiringWebDriver e_driver = new EventFiringWebDriver(getDriver());
		WebDriverEventListener listerner = new WebDriverEventListener();
		log.debug("Registering the Event Firing Web Driver with the Listener ");
		e_driver.register(listerner);
		driver.set(e_driver);
		// getDriver().manage().window().maximize();
		getDriver().manage().timeouts().pageLoadTimeout(TestConfig.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		getDriver().manage().timeouts().implicitlyWait(TestConfig.IMPLICIT_WAIT, TimeUnit.SECONDS);
		getDriver().get(prop.getProperty("URL"));
	}

	public static WebDriver getDriver() {
		log.debug("Getting Web Driver Instance");
		return driver.get();
	}
	
}

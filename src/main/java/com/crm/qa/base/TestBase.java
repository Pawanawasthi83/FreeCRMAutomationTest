package com.crm.qa.base;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.utils.commonutils.TestConfig;
import com.crm.qa.utils.commonutils.TestHelper;
import com.crm.qa.utils.listeners.WebDriverEventListener;



public class TestBase{

	public static  WebDriver driver;
    public static WebDriverWait waitDriver;
    
   	private static ThreadLocal<WebDriver> TLdriver = new ThreadLocal<WebDriver>();
	public static Properties prop;
	
	public static Logger log = Logger.getLogger("devpinoyLogger");
	

	public TestBase() {
		log.debug("Initializing Constructor Of The Base Class ");
		TestHelper.getPropConfiguration(TestConfig.configPropertyPath);
	}

	public void initialization(String browserName) {
		log.debug("Current Thread ID On my project : " +Thread.currentThread().getId());
		log.debug("Envirnoment Initilization ......");
		log.debug("Initializing Web Driver For Browser : "+browserName);
		
		if (browserName.equalsIgnoreCase("FF")) {
			log.debug("Inside FF Driver");
			TLdriver.set(new FirefoxDriver(DesiredCapabilitiesManager.firefoxDC()));		
		} else if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", TestConfig.chromeDriverPath);
			TLdriver.set(new ChromeDriver(DesiredCapabilitiesManager.chromeDC()));
		} else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", TestConfig.ieDriverPath);
			TLdriver.set(new InternetExplorerDriver(DesiredCapabilitiesManager.InterNetExplorerDC()));
		} else if (browserName.equalsIgnoreCase("safari")) {
			TLdriver.set(new SafariDriver());
		} else if (browserName.equalsIgnoreCase("opera")) {
			System.setProperty("webdriver.opera.driver", TestConfig.operaDriverPath);
			TLdriver.set(new OperaDriver(DesiredCapabilitiesManager.operaDC()));
		} else if (browserName.equalsIgnoreCase("htmlUnitDriver")) {
			//TLdriver.set(new HtmlUnitDriver(DesiredCapabilitiesManager.htmlUnitDriverDC()));
		}else if (browserName.equalsIgnoreCase("phantom")) {
			TLdriver.set(new PhantomJSDriver(DesiredCapabilitiesManager.phantomJSDC()));
		} else {
			log.debug(browserName+"Not Supported");
		}
				
		waitDriver = new WebDriverWait(TLdriver.get(), TestConfig.EXPLICIT_WAIT);
		EventFiringWebDriver e_driver = new EventFiringWebDriver(TLdriver.get());
		WebDriverEventListener listerner = new WebDriverEventListener();
		log.debug("Registering the Event Firing Web Driver with the Listener ");
		e_driver.register(listerner);
		TLdriver.set(e_driver);
		// getDriver().manage().window().maximize();
		TLdriver.get().manage().timeouts().pageLoadTimeout(TestConfig.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		TLdriver.get().manage().timeouts().implicitlyWait(TestConfig.IMPLICIT_WAIT, TimeUnit.SECONDS);
		log.debug("Envirnoment Initilization Finished ......");
		driver=TLdriver.get();
		log.debug("Launching Web URL");
		driver.get(prop.getProperty("URL"));
	}

	public static ThreadLocal<WebDriver> getDriver() {
		log.debug("Getting Web Driver Instance");
			return TLdriver;
			
	}
	
}

package com.crm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestHelper;
import com.crm.qa.util.WebDriverEventListenerHelper;;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		String path=System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+File.separator
				+"java"+File.separator+"com"+File.separator+"crm"+File.separator+"qa"+File.separator+"config"
				+File.separator+"config.properties";
		
		try{
			prop=new Properties();
			FileInputStream fis = new FileInputStream(path);
			prop.load(fis);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		String browserName=prop.getProperty("browser");
		System.out.println("Setting browser :  "+browserName);	
		if(browserName.equalsIgnoreCase("FF")){
			driver=new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("chrome")){
			
			String chromeDriverPath=System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"
					+File.separator+"resources"+File.separator+"Drivers"+File.separator+"chromedriver.exe";
				System.setProperty("webdriver.chrome.driver", chromeDriverPath);
				driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("ie")){
			try{
			System.out.println("Launchng IE");
			String ieDriverPath=System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"
			+File.separator+"resources"+File.separator+"Drivers"+File.separator+"IEDriverServer.exe";
			System.out.println(ieDriverPath);
			System.setProperty("webdriver.ie.driver", ieDriverPath);
			DesiredCapabilities IEcaps = DesiredCapabilities.internetExplorer();
			IEcaps .setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			driver=new InternetExplorerDriver(IEcaps);
			}catch(Exception e){
				e.printStackTrace();
				driver.quit();
			}
		}else if(browserName.equalsIgnoreCase("safari")){
				driver=new SafariDriver();
		}else if(browserName.equalsIgnoreCase("opera")){
				String operaDriverPath=System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"
						+File.separator+"resources"+File.separator+"Drivers"+File.separator+"operadriver"+File.separator+"operadriver.exe";
				System.out.println(operaDriverPath);
				System.setProperty("webdriver.opera.driver", operaDriverPath);
				OperaOptions options = new OperaOptions();
				options.setBinary(new File("C:\\Program Files\\Opera\\49.0.2725.47\\opera.exe"));
				driver=new OperaDriver(options);
		}else{
			System.out.println("Browser Not Supported");
		}
		
		EventFiringWebDriver e_driver = new EventFiringWebDriver(driver);
		WebDriverEventListenerHelper listerner = new WebDriverEventListenerHelper();
		e_driver.register(listerner);
		driver=e_driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestHelper.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestHelper.IMPLICIT_WAIT,TimeUnit.SECONDS);
		driver.get(prop.getProperty("URL"));
	}
}

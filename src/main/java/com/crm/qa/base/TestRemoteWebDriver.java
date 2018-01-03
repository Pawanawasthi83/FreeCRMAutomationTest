package com.crm.qa.base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class TestRemoteWebDriver {

	
	@Test
	public void  login() throws MalformedURLException{
		
			DesiredCapabilities cap = DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.ANY);
							
			RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4455//wd//hub"), cap);
			driver.get("https://www.freecrm.com/index.html");
			System.out.println(driver.getTitle());
			driver.quit();
			
		
		
	}
	
}

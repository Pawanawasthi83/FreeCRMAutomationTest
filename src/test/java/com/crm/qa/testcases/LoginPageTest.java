package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPageObj;
	HomePage homePageObj;
	
		
	public LoginPageTest() {
		
	}
	
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser ){
		TestBase base = new TestBase();
		log.debug("Before Method Starts ....");
		base.initialization(browser);
		loginPageObj = new LoginPage();
	}
	
	@Test(priority=1)
	public void testLoginPageTitleText(){
		String pageTitle = loginPageObj.getLoginPageTitle();
		Assert.assertEquals(pageTitle, prop.getProperty("loginpagetitle"));
	}
	/*@Test(priority=2)
	public void testCRMLogoImage(){
		boolean flag = loginPageObj.validateCrmLogo();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void testLogin(){
		homePageObj=loginPageObj.login(prop.getProperty("userName"), prop.getProperty("password"));
		String title = homePageObj.getHomePageTitle();
		Assert.assertEquals(title, prop.getProperty("homepagetitle"));
	}*/
	
	@AfterMethod
	public void teardown(){
		log.debug("After Methods Starts ...");
		driver.quit();
		log.debug(Thread.currentThread().getId());
		log.debug(Thread.currentThread().isInterrupted());
		Thread.currentThread().interrupt();
		log.debug(Thread.currentThread().isInterrupted());
		getDriver().remove();
		log.debug("After Methods ends ...");
		
	}
	
	
}

package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {

	LoginPage loginPageObj;
	HomePage homePageObj;
	ContactsPage contactspageObj;
	
	public HomePageTest(){
		super();
	}
	@BeforeTest
	@Parameters("browser")
	
	
	
	@BeforeMethod
	public void setup(String browser){
		initialization(browser);
		loginPageObj=new LoginPage();
		homePageObj = loginPageObj.login(prop.getProperty("userName"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void testHomePageTitleText(){
		String title = homePageObj.getHomePageTitle();
		Assert.assertEquals(title, prop.getProperty("homepagetitle","Home Page Title Page is Not Matched"));
	}
	
	@Test(priority=2)
	public void testHomePageUserNameText(){
		Assert.assertTrue(homePageObj.verifyHomePageUserName());
	}
	@Test(priority=3)
	public void testContactsLink() {
		contactspageObj = homePageObj.clickOnContactsLink();
		String lable = contactspageObj.validateContactPageLabel();
		Assert.assertEquals(lable, prop.getProperty("ContactsPageLable"));

	}
	
	@AfterMethod
	public void teardown(){
		getDriver().quit();
	}
	
}

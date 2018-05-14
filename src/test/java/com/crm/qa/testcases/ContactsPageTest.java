package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.commonutils.DataProviderHelper;


public class ContactsPageTest extends TestBase {

	LoginPage loginpageObj;
	HomePage homepageObj;
	ContactsPage contactspageObj;
	
	public ContactsPageTest(){
		super();
	}
	
	@BeforeTest
	@Parameters("browser")
	
		
	@BeforeMethod
	public void setup(@Optional("ff") String browser){
		initialization(browser);
		loginpageObj= new LoginPage();
		homepageObj = loginpageObj.login(prop.getProperty("userName"), prop.getProperty("password"));
		contactspageObj = homepageObj.clickOnContactsLink();
	}
	
	@Test(priority=1)
	public void testContactsPageLable(){
		
		String lable = contactspageObj.validateContactPageLabel();
		Assert.assertEquals(lable, prop.getProperty("ContactsPageLable"));
	}
	
	@Test(dataProvider="newcontact",dataProviderClass=DataProviderHelper.class,priority=2)
	public void testCreateNewContact(String title,String fname,String lname,String company){
		homepageObj.clickOnNewContactLink();
		String lable= contactspageObj.validateNewContactPageLable();
		Assert.assertEquals(lable,prop.getProperty("NewContactPageLable"));
		contactspageObj.createNewContact(title,fname,lname,company);
		Assert.assertTrue(contactspageObj.validateNewContactName(fname, lname));
	}
	
	@AfterMethod
	public void teardown(){
		driver.close();
		getDriver().remove();
	}
}

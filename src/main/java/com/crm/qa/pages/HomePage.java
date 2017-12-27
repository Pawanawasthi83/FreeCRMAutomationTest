package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.crm.qa.utils.commonutils.TestConfig;
import com.crm.qa.utils.commonutils.TestHelper;

public class HomePage extends TestBase{

	@FindBy(xpath="//td[contains(text(),'User: Pawan Awasthi')]")
	WebElement usernamelable;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsPageLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsPageLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement taskPageLink;
	
	@FindBy(xpath="//frame[@name='mainpanel']")
	WebElement iFrameMainPanel;
	
	public HomePage(){
		PageFactory.initElements(getDriver(), this);
	}
	
	
	public String getHomePageTitle(){
		TestHelper.switchToFrame(iFrameMainPanel);
		WebDriverWait wait = new WebDriverWait(getDriver(), TestConfig.EXPLICIT_WAIT);
		wait.until(ExpectedConditions.visibilityOf(contactsPageLink));
		return getDriver().getTitle();
	}
	
	public boolean verifyHomePageUserName(){
		TestHelper.switchToFrame(iFrameMainPanel);
		return usernamelable.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink(){
		TestHelper.switchToFrame(iFrameMainPanel);
		contactsPageLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink(){
		TestHelper.switchToFrame(iFrameMainPanel);
		dealsPageLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink(){
		TestHelper.switchToFrame(iFrameMainPanel);
		taskPageLink.click();
		return new TasksPage();
	}
	
		
	public void clickOnNewContactLink(){
		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait(getDriver(), TestConfig.EXPLICIT_WAIT);
		wait.until(ExpectedConditions.elementToBeClickable(dealsPageLink));
		action.moveToElement(dealsPageLink).build().perform();
		action.moveToElement(contactsPageLink).build().perform();
		newContactLink.click();
	}
	
	
	
}

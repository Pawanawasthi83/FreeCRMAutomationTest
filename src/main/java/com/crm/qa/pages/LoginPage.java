package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.crm.qa.utils.commonutils.TestHelper;

public class LoginPage extends TestBase{

	// Page Objects - OR
	
	@FindBy(xpath="//input[@name='username']")
	WebElement userName;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[@class='img-responsive']")
	WebElement crmLogo;
	
	//Initializing the Page Objects:
	
	public LoginPage(){
		PageFactory.initElements(getDriver(), this);
	}
	
	//Actions :
	
	public String getLoginPageTitle(){
		return getDriver().getTitle();
	}
	
	public boolean validateCrmLogo(){
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String usrname,String pwd){
		userName.sendKeys(usrname);
		password.sendKeys(pwd);
		WebDriverWait wait= new WebDriverWait(getDriver(), TestHelper.EXPLICIT_WAIT);
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
		loginBtn.click();
		return new HomePage();
	}
	
	
}

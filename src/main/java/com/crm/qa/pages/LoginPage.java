package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

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
		PageFactory.initElements(driver, this);
	}
	
	//Actions :
	
	public String getLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateCrmLogo(){
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String usrname,String pwd){
		userName.sendKeys(usrname);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
	}
	
	
}

package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contectslabel;
	
	@FindBy(xpath="//legend[contains(text(),'Contact Information')]")
	WebElement newContactPageLable;
	
	@FindBy(xpath="//select[@name='title']")
	WebElement titleDropDown;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='surname']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement companyName;
	
	@FindBy(xpath="//form[@id='contactForm']/table/tbody/tr[1]/td/input[2]")
	WebElement saveBtn;
	
	
	
	
	
	public ContactsPage(){
		PageFactory.initElements(getDriver(), this);		
	}
	
	public String validateContactPageLabel(){
		String label = contectslabel.getText();
		return label;
	}
	
	public String validateNewContactPageLable(){
		return newContactPageLable.getText();
	}
	
	public void createNewContact(String title , String fname, String lname ,String company){
		Select select = new Select(titleDropDown);
		select.selectByVisibleText(title);
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		companyName.sendKeys(company);
		saveBtn.click();
		
		
	}
	
	public boolean validateNewContactName(String fname,String surname){
		
		return getDriver().findElement(By.xpath("//td[contains(text(),'"+fname+" "+surname+"')]")).isDisplayed();
	}
	
	
	
}

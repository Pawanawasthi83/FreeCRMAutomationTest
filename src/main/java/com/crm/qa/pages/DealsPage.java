package com.crm.qa.pages;

import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class DealsPage extends TestBase {

	public DealsPage() {
		PageFactory.initElements(getDriver(), this);
	}

}
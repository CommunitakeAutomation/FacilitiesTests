package com.communitake.tests.automation.webpageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PoliciesPage extends SeleniumBasePage {
	
	
	@FindBy(css=".AndroidRestrictions_Button")
	WebElement androidRestrictionBtn;
	
	
	public PoliciesPage (WebDriver driver) {
		super(driver);
	}
	
	public void clickAndroidRestriction() {
		click(androidRestrictionBtn);
	}
}

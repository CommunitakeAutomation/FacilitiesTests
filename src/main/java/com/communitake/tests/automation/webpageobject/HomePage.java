package com.communitake.tests.automation.webpageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends SeleniumBasePage {

	//Fleet button
	@FindBy(css=".Policies_Button")
	WebElement policiesBtn;
	
	public HomePage (WebDriver driver) {
		super(driver);
	}
	
	public void clickPolicies() {
		click(policiesBtn);
	}
}


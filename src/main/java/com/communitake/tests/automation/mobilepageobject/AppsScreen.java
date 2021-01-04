package com.communitake.tests.automation.mobilepageobject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AppsScreen extends AppiumBasePage {

	
	//Settings button
	@AndroidFindBy(id="Settings")
	MobileElement settingBtn;
	
	//External browser
	@AndroidFindBy(id="Browser")
	MobileElement externalBrowser;
	
	


	
	public AppsScreen(AppiumDriver<MobileElement> mobileDriver) {
		super(mobileDriver);
	}
	
	public void openSettings() {
		click(settingBtn);
	}
	
	public void openBrowser() {
		click(externalBrowser);
	}
	
	
	
}
package com.communitake.tests.automation.mobilepageobject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AppsPage extends AppiumBasePage {

	
	@AndroidFindBy(xpath = "//*[@text='See all 25 apps']")
	MobileElement seeAllApps;
	
	@AndroidFindBy(xpath ="//*[@text='Appium Settings']")
	MobileElement appiumSettings;
	
	
	
	public AppsPage(AppiumDriver<MobileElement> mobileDriver) {
		super(mobileDriver);
		
	}
	
	public void openAllApps() {
		click(seeAllApps);
	}
	
	
	public void clickAppiumSet() {
		click(appiumSettings);
	

	}

}

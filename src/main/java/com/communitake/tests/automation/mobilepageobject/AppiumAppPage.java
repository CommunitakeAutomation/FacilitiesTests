package com.communitake.tests.automation.mobilepageobject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AppiumAppPage extends AppiumBasePage {

	//Uninstall button
	@AndroidFindBy(xpath = "//*[@text='UNINSTALL']")
	MobileElement uninstallButton;
	
	//Restriction message
	@AndroidFindBy(xpath = "//*[@text='Action not allowed']")
	MobileElement restrictionMessage;
	
	
	
	public AppiumAppPage(AppiumDriver<MobileElement> mobileDriver) {
		super(mobileDriver);
		
	}
	
	public void uninstallAppiumApp() {
		click(uninstallButton);
	}
	
	public String getAppiumAppMessage() {
		return getmText(restrictionMessage);
	}

}

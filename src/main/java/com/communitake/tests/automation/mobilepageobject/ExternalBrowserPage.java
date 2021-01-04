package com.communitake.tests.automation.mobilepageobject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ExternalBrowserPage extends AppiumBasePage {

	//Google short cut
	@AndroidFindBy(xpath ="//*[@text='Google']")
	MobileElement googleShortCut;


	//Unavailable web page
	@AndroidFindBy(xpath ="//*[@text='Webpage not available']")
	MobileElement webpageNotAvailable;

	public ExternalBrowserPage(AppiumDriver<MobileElement> mobileDriver) {
		super(mobileDriver);
	}
	
	public void clickGoogle() {
		click(googleShortCut);
	}
	
	public String webPageText() {
		return getmText(webpageNotAvailable);
	}

}

package com.communitake.tests.automation.mobilepageobject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LocationPage extends AppiumBasePage {

	
	//Intact R closed GPS text
	@AndroidFindBy(id="com.android.settings:id/switch_text")
	MobileElement locationClosed;
	
	//Location button
	@AndroidFindBy(id="com.android.settings:id/switch_widget")//com.android.settings:id/switch_widget
	MobileElement locationBtn;

	public LocationPage(AppiumDriver<MobileElement> mobileDriver) {
		super(mobileDriver);

	}
	
	public String locationText() {
		return getmText(locationClosed);
	}
	
	public String gedLoacationText() {
		return getmText(locationBtn);
	}
	
	public void validLocClosed() {
		click(locationBtn);
		sleep(5000);
	}
}
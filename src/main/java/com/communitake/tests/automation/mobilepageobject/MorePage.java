package com.communitake.tests.automation.mobilepageobject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MorePage extends AppiumBasePage{

	//Airplane mode button
	@AndroidFindBy(id="android:id/switch_widget")
	MobileElement airPlnBtn;
	
	
	
	public MorePage(AppiumDriver<MobileElement> mobileDriver) {
		super(mobileDriver);
		
	}
	
	public void validApClosed() {
		click(airPlnBtn);
		sleep(500);
	}
	
	public String getAirPlnBtnText() {
		return getmText(airPlnBtn);
	}
}


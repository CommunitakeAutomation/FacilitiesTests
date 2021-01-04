package com.communitake.tests.automation.mobilepageobject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class FactoryResetPage extends AppiumBasePage {
	
	@AndroidFindBy(id="com.android.settings:id/initiate_master_clear")
	MobileElement restPhoneBtn;
	
	
	public FactoryResetPage(AppiumDriver<MobileElement> mobileDriver) {
		super(mobileDriver);
	}
	
	public void resetPhone() {
		click(restPhoneBtn);
	}
	
	public String resetPhoneText() {
		return getmText(restPhoneBtn);
	}

}
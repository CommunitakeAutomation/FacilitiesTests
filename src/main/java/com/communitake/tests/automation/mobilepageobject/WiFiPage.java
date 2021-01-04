package com.communitake.tests.automation.mobilepageobject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class WiFiPage extends AppiumBasePage {
	
	//wifi button
	@AndroidFindBy(id="com.android.settings:id/switch_widget")
	MobileElement wifiBtn;
	
	//wifi is closed - text
	@AndroidFindBy(id="com.android.settings:id/switch_text")
	MobileElement wificlosed;
	
	public WiFiPage(AppiumDriver<MobileElement> mobileDriver) {
		super(mobileDriver);	
	}
	
	public void validWifiClosed() {
		click(wifiBtn);
		sleep(500);
	}
	
	public String wifiClosedText() {
		return getmText(wificlosed);
	}

}

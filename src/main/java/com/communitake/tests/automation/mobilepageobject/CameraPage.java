package com.communitake.tests.automation.mobilepageobject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CameraPage extends AppiumBasePage {
	
	//Warn user message
	@AndroidFindBy(id = "com.communitake.mdc.supportsip:id/setpasswordTitle")
	MobileElement  cameraWarnUser;
	
	//GED camera block text message
	@AndroidFindBy(id="android:id/message")
	MobileElement gedBlockCamText;
	
	
	public CameraPage(AppiumDriver<MobileElement> mobileDriver) {
		super(mobileDriver);
	}
	
	public String cameraTextMessage() {
		return getmText(cameraWarnUser);
	}
	
	public String gedCameraTxtMsg() {
		return getmText(gedBlockCamText);
	}

}

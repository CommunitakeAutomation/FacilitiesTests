package com.communitake.tests.automation.mobilepageobject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class BlueToothPage extends AppiumBasePage {
	
	//Bluetooth button
	@AndroidFindBy(id="com.android.settings:id/switch_widget")
	MobileElement BTBtn;
	
	//BT is closed text
	@AndroidFindBy(id="com.android.settings:id/switch_text")
	MobileElement BTclosed;
	
	//GED BT is closed text
	@AndroidFindBy(xpath="//*[@text='OFF']")
	MobileElement gedBTClosedTxt;
	
	//GED Connection references
	@AndroidFindBy(xpath="//*[@text='Connection preferences']")
	MobileElement connectionReferences;
	
	//BlueTooth settings inside Connection References
	@AndroidFindBy(xpath ="//*[@text='Bluetooth']")
	MobileElement gedBTOp;
	
	
	
	
	public BlueToothPage(AppiumDriver<MobileElement> mobileDriver) {
		super(mobileDriver);
	}
	
	public void validBTClosed() {
		click(BTBtn);
		sleep(500);
	}
			
	
	public String BTclosedText() {
		return getmText(BTclosed);
	}
	
	public String gedBTClosedText() {
		return getmText(gedBTClosedTxt);
	}
	
	public void openGedBTBtn() {
		click(connectionReferences);
		sleep(3000);
		click(gedBTOp);
	}
	
}

package com.communitake.tests.automation.mobilepageobject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class BackupResetPage extends AppiumBasePage {
	
	//Intact R Factory reset
	@AndroidFindBy(xpath ="//*[@text='Factory data reset']")
	MobileElement factoryResetOp;
	
	//Factory reset restriction icon
	@AndroidFindBy(id="com.android.settings:id/restricted_icon")
	MobileElement reatrictionIcon;
	
	//Action not allowed message
	@AndroidFindBy(xpath ="//*[@text='Action not allowed']")
	MobileElement restrictionMessage;
	
	
	
	
	public BackupResetPage(AppiumDriver<MobileElement> mobileDriver){
		super(mobileDriver);
	}
	
	public void chooseBnROp() {
		click(factoryResetOp);
	}
	
	public void openRestrictionMessage() {
		click(reatrictionIcon);
	}
	
	public String getRestrictionMessage() {
		return getmText(restrictionMessage);
	}
}

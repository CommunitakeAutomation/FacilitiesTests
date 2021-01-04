package com.communitake.tests.automation.mobilepageobject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SmsPage extends AppiumBasePage {

	//Permision message
	@AndroidFindBy(xpath = "//*[@text='This user is not allowed to use SMS']")
	MobileElement smsPermosion;
	
	public SmsPage(AppiumDriver<MobileElement> mobileDriver) {
		super(mobileDriver);
		
	}
	
	public String getSmsPerMsg() {
		return getmText(smsPermosion);
	}
	
	
	

}

package com.communitake.tests.automation.mobilepageobject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class DataUsagePage extends AppiumBasePage {

		
	//cellular data button
	@AndroidFindBy(xpath = "//*[@text='Cellular data']")
	MobileElement cellularData;
	
	// Mobile data button text
	@AndroidFindBy(xpath ="//*[@text='OFF']")
	MobileElement cellularDataBtntxt;
	
	// Mobile Data button 
	@AndroidFindBy(id="android:id/switch_widget")
	MobileElement mobileDataBtn;
	
	//GED Roaming button
	@AndroidFindBy(xpath = "//*[@text='Roaming']")
	MobileElement roamingBtn;
	
	
	public DataUsagePage(AppiumDriver<MobileElement> mobileDriver) {
		super(mobileDriver);
	}
	
	public void clickOnDataBtn() {
		click(mobileDataBtn);
	}
	
	public String cellurDataText() {
		return getmText(cellularDataBtntxt);
	}
	
	public void validMoDaClosed() {
		click(mobileDataBtn);
	}

	public void clickRoamingBtn() {
		click(roamingBtn);
	}
}


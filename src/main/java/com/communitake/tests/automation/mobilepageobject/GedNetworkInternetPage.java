package com.communitake.tests.automation.mobilepageobject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class GedNetworkInternetPage extends AppiumBasePage { //For GED Only

	//GED wifi button
	@AndroidFindBy(id="Wi‑Fi")
	MobileElement gedWifiBtn;						
	
	//GED Airplane mode button
	@AndroidFindBy(id="android:id/switch_widget")
	MobileElement ApMdBtn;
	
	//GMS WIFI button
	@AndroidFindBy(id="com.android.settings:id/switch_widget")
	MobileElement gmsWifiBtn;
	
	public GedNetworkInternetPage(AppiumDriver<MobileElement> mobileDriver) {
		super(mobileDriver);
	}
	
	public void clickGedWifiBtn() {
		click(gedWifiBtn);
		sleep(3000);
	}	
	
	public String gedWifiBtnTxt() {
		return getmText(gedWifiBtn);
	}
	
	public void clickApMdBtn() {
		click(ApMdBtn);
	}
	
	public String getApMdBtnTxt() {
		return getmText(ApMdBtn);
	}

	public String getGmsWifiBtnTxt() {
		return getmText(gmsWifiBtn);
	}
}
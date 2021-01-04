package com.communitake.tests.automation.mobilepageobject;

import java.util.List;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class IntactAppPage extends AppiumBasePage {

	//Intact Settings Button
	@AndroidFindBy(id="com.communitake.mdc.supportsip:id/menuImage")
	MobileElement intactSettingButton;

	//Intact 4 Setting button
	@AndroidFindBy(id="More options")
	MobileElement intact4SettingButton;

	//Sync Now
	@AndroidFindBy(id="android:id/title")
	List<MobileElement> Settings;

	//Intact 4 Sync now
	@AndroidFindBy(id="com.communitake.mdc.supportsip:id/title")
	List<MobileElement> syncNow4;

	//Expend notification button
	@AndroidFindBy(id="Open quick settings.")
	MobileElement expandnoti;

	//Intact R  Android settings button
	@AndroidFindBy(id="Open settings.")
	MobileElement androidSetBtn;

	//GED BT con from notification bar
	@AndroidFindBy(xpath="//android.widget.Switch[@content-desc=\"Bluetooth.\"]")
	MobileElement gedBtOp;

	//GED Settings icon
	@AndroidFindBy(id="Settings")
	MobileElement settings;

	//GED Storage
	@AndroidFindBy(xpath="//*[@text='Storage']")
	MobileElement gedStorage;

	//GED Files
	@AndroidFindBy(xpath="//*[@text='Files']")
	MobileElement gedFiles;

	//GED download folder
	@AndroidFindBy(xpath="//*[@text='Location']")
	MobileElement locationOnNoti;

	//IntactR location on notification
	@AndroidFindBy(xpath="//*[@text='Download']")
	MobileElement gedDwlFoldr;

	//IntactR Airplane mode on notification
	@AndroidFindBy(xpath="//*[@text='Airplane mode']")
	MobileElement rApmNoti; 

	//Intact R BT setting on notification
	@AndroidFindBy(xpath="//*[@text='Bluetooth']")
	MobileElement rBTSet;
	
	//gms wifi btn in notifications
	@AndroidFindBy(xpath="//*[android.widget.Switch[@content-desc=\"Wi-Fi,Wifi three bars.,Avistris\"]/android.widget.FrameLayout/android.widget.ImageView]")
	MobileElement gmsNotiWifi;

	public IntactAppPage(AppiumDriver<MobileElement> mobileDriver) {
		super(mobileDriver);	

	}

	public void sync(int i) throws InterruptedException{
		click(intactSettingButton);
		click(Settings.get(i));
		click(intactSettingButton);
		click(Settings.get(i));
		click(intactSettingButton);
		click(Settings.get(i));
		sleep(3000);
	}

	public void syncIntact4(int i) {
		click(intact4SettingButton);
		click(syncNow4.get(i));
		click(intact4SettingButton);
		click(syncNow4.get(i));
		click(intact4SettingButton);
		click(syncNow4.get(i));
		sleep(3000);
	}

	public void expendNotofocations() {
		click(expandnoti);
	}

	public void openAndroidSet() {
		click(expandnoti);
		click(androidSetBtn);
	}

	public void openLocNoti() {
		longPress(locationOnNoti, 2);
	}



	@SuppressWarnings("rawtypes")
	public void openAndroidSettings() {
		Activity activity = new Activity("com.android.settings",  ".Settings");
		//activity.setAppWaitPackage("");
		// activity.setAppWaitActivity("");
		//activity.setStopApp(false);
		((AndroidDriver) mobileDriver).startActivity(activity);
	}

	public void openGedBtOp() {





		//Activity activity = new Activity("etooth.map.BluetoothMapSetting","");
		//((AndroidDriver) mobileDriver).startActivity(activity);
	}

	@SuppressWarnings("rawtypes")
	public void turnOnOfWiFi() {
		((AndroidDriver) mobileDriver).toggleWifi();
	}

	public void openDownloadFolder() {

		mobileDriver.findElementById("Apps").click();
		sleep(500);
		mobileDriver.findElementById("File Manager").click();
		sleep(500);
		mobileDriver.findElementByXPath("//*[@text='Internal shared storage']").click();
		sleep(500);
		mobileDriver.findElementByXPath("//*[@text='Download']").click();
	}

	public void openGedDownloadFolder(String text, String text1) {

		scrollToText("Storage");
		if(gedStorage.isDisplayed()) {
			gedStorage.click();
			sleep(1000);
		}
		scrollToText("Files");
		if(gedFiles.isDisplayed()) {
			gedFiles.click();
			sleep(1000);
		}
		/*scrollToText("Download");
		if(gedDwlFoldr.isDisplayed()) {
			gedDwlFoldr.click();
			sleep(1000);
		}*/

	}

	public void openApmSet() {
		openNotifications();
		click(expandnoti);
		longPress(rApmNoti, 2);
	}

	public void openRBTSet() {
		openNotifications();
		click(expandnoti);
		longPress(rBTSet, 2);
	}

	public void openGmsWifi() {
		longPress(gmsNotiWifi, 2);
	}
}





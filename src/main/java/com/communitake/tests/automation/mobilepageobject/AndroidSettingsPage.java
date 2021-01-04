package com.communitake.tests.automation.mobilepageobject;

import java.util.List;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AndroidSettingsPage extends AppiumBasePage {

	//Wifi - from search in settings
	@AndroidFindBy(xpath ="//*[@text='Wi‑Fi']")
	MobileElement WiFiSettings;

	//BlueTooth settings
	@AndroidFindBy(xpath ="//*[@text='Bluetooth']")
	MobileElement BTSettings;

	//Backup & reset
	@AndroidFindBy(xpath ="//*[@text='Backup & reset']")
	MobileElement backUpReset;

	//Data usage
	@AndroidFindBy(xpath ="//*[@text='Data usage']")
	MobileElement dataUsage;

	//Location settings
	@AndroidFindBy(xpath = "//*[@text='Location']")
	MobileElement locationSettings;

	//IntactR Search settings button   
	@AndroidFindBy(id="Search settings")
	MobileElement searchSettingsBtn;

	//IntactR Search settings field    
	@AndroidFindBy(id="android:id/search_src_text")
	MobileElement searchSettingFld;
	
	//Intact R DEVICE section
	@AndroidFindBy(xpath = "//*[@text='Device']")
	MobileElement deviceConR;

	//Airplane mode setting - from search
	@AndroidFindBy(xpath = "//*[@text='Airplane mode']")
	MobileElement airPlnSettings;

	//Intact R Apps
	@AndroidFindBy(xpath = "//*[@text='Apps']")
	MobileElement appsSet;
	
	//More button
	@AndroidFindBy(xpath = "//*[@text='More']")
	MobileElement moreSettingsBtn;
	
	//GED search settings button
	@AndroidFindBy(id="Navigate up")
	MobileElement gedSearchSettingsBBt;

	//GED searchSettings field
	@AndroidFindBy(id="android:id/search_src_text")
	MobileElement gedSearchSettingsFld;
	
	//GED BT options
	@AndroidFindBy(className="android.widget.LinearLayout")
	List<MobileElement> gedBtOps;
	
	//GED 'System'
	@AndroidFindBy(xpath = "//*[@text='System']")
	MobileElement gedSysytem;
	
	//GED Reset optionn
	@AndroidFindBy(xpath = "//*[@text='Reset options']")
	MobileElement gedRestOp;
	
	//GED Network&Internet
	@AndroidFindBy(xpath = "//*[@text='Network & internet']")
	MobileElement gedNetInt;
	
	//GED Data usage(button uses only to get Data usage)
	@AndroidFindBy(xpath = "//*[@text='Mobile network']")
	MobileElement gedMobileNetwork;
	
	//GED Network&Internet
	@AndroidFindBy(xpath = "//*[@text='Network & internet']")
	MobileElement gedNtwInt;
	
	//GED Apps & notifications
	@AndroidFindBy(xpath = "//*[@text='Apps & notifications']")  	
	MobileElement gedApps;
    
    
    
    
    
	public AndroidSettingsPage(AppiumDriver<MobileElement> mobileDriver) {
		super(mobileDriver);	
	}

	public void openBTSetings() {
		click(BTSettings);
		
	}

	public void openWifiSet() {
		click(WiFiSettings);
	}

	public void clickOnBackup(String text) {
		scrollToText(text);
		if (backUpReset.isDisplayed()) {
			backUpReset.click();
		}
		else {
			mobileDriver.navigate().back();
		}
	}

	public void openDataUsage(String text) {
		scrollToText(text);
		if(dataUsage.isDisplayed()) {
			dataUsage.click();
		}
		else {
			mobileDriver.navigate().back();
		}

	}

	public void openLocationSettings(String text) {
		scrollToText(text);
		if(locationSettings.isDisplayed()) {
			locationSettings.click();
		}
		else {
			mobileDriver.navigate().back();
		}
	}
	
	public void openAirplnSet(String text) {
		scrollToText("More");
		if(moreSettingsBtn.isDisplayed()) {
			moreSettingsBtn.click();
		}
		else {
			mobileDriver.navigate().back();
		}
	}

	@SuppressWarnings("unchecked")
	public void reloadSettingPage() {
		AndroidSettingsPage mobilesettingspage = new AndroidSettingsPage(mobileDriver);
		mobilesettingspage.reload();

	}

	public void clickOnApps(String text) {
		scrollToText("Apps");
		if (appsSet.isDisplayed()) {
			appsSet.click();
		}
		else {
			mobileDriver.navigate().back();
		}
	}
	
	public void openGedApps() {
		click(gedApps);
	}
	
	public void openGedBtSettings(String text, int i) {
		click(gedSearchSettingsBBt);
		gedSearchSettingsFld.clear();
		gedSearchSettingsFld.sendKeys("Bluetooth");
		click(gedBtOps.get(i));
		
	}
	
	public void openGedGpsStngs() {
		click(gedSearchSettingsBBt);
		gedSearchSettingsFld.clear();
		gedSearchSettingsFld.sendKeys("loc");
		scrollToText("Location");
		click(locationSettings);
		
	}
	
	public void openGedRestOp(String text) {
		scrollToText(text);
		if(gedSysytem.isDisplayed()) {
			gedSysytem.click();
		}
		click(gedRestOp);
	}
	
	public void openGedDataUsage() {
		sleep(1000);
		click(gedNetInt);
		sleep(1000);
		click(gedMobileNetwork);
	}
	
	public void openGedNtwInt() {
		click(gedNtwInt);
	}
	
	
	
}	

package com.communitake.tests.automation.ged;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.communitake.tests.automation.mobilepageobject.AndroidSettingsPage;
import com.communitake.tests.automation.mobilepageobject.AppiumAppPage;
import com.communitake.tests.automation.mobilepageobject.AppsPage;
import com.communitake.tests.automation.mobilepageobject.BackupResetPage;
import com.communitake.tests.automation.mobilepageobject.BlueToothPage;
import com.communitake.tests.automation.mobilepageobject.CameraPage;
import com.communitake.tests.automation.mobilepageobject.DataUsagePage;
import com.communitake.tests.automation.mobilepageobject.DownloadFolderPage;
import com.communitake.tests.automation.mobilepageobject.GedNetworkInternetPage;
import com.communitake.tests.automation.mobilepageobject.InstallationAppPage;
import com.communitake.tests.automation.mobilepageobject.IntactAppPage;
import com.communitake.tests.automation.mobilepageobject.LocationPage;
import com.communitake.tests.automation.mobilepageobject.MobileHomePage;
import com.communitake.tests.automation.mobilepageobject.SmsPage;
import com.communitake.tests.automation.webpageobject.AndroidRestrictionsPage;
import com.communitake.tests.automation.webpageobject.HomePage;
import com.communitake.tests.automation.webpageobject.PoliciesPage;


public class FacilitiesTest extends BaseTest1 {

	@Test(priority=1, testName="Bluetooth")
	public void blockBT() throws  InterruptedException {
		
		HomePage homepage = new HomePage(driver);
		homepage.clickPolicies();
		PoliciesPage policiesPage = new PoliciesPage(driver);
		policiesPage.clickAndroidRestriction();
		AndroidRestrictionsPage androidRestrictionPage = new AndroidRestrictionsPage(driver);
		Thread.sleep(1000);
		androidRestrictionPage.BtConfig(1);
		IntactAppPage intactAppPage = new IntactAppPage(mobileDriver);
		intactAppPage.sync(0);
		intactAppPage.openAndroidSettings();
		AndroidSettingsPage androidSettingsPage = new AndroidSettingsPage(mobileDriver);
		androidSettingsPage.openBTSetings();
		BlueToothPage bluetoothPage = new BlueToothPage(mobileDriver);
		bluetoothPage.openGedBTBtn();
		bluetoothPage.validBTClosed();
		String expected = "OFF";
		String actual = bluetoothPage.gedBTClosedText();
		Assert.assertEquals(actual, expected);

	}

	@Test(priority=2, testName="Camera")
	public void blockCamera() throws InterruptedException {

		AndroidRestrictionsPage androidRestrictionPage = new AndroidRestrictionsPage(driver);
		androidRestrictionPage.blockCamera();
		Thread.sleep(1000);
		IntactAppPage intactAppPage = new IntactAppPage(mobileDriver);
		intactAppPage.sync(0);
		Thread.sleep(1000);
		intactAppPage.Home();
		MobileHomePage mobileHomePage = new MobileHomePage(mobileDriver);
		mobileHomePage.openGedCamera();
		CameraPage camerapage = new CameraPage(mobileDriver);
		String expected = "Camera has been disabled because of security policies.";
		String actual = camerapage.gedCameraTxtMsg();
		Assert.assertEquals(actual, expected);

	} 

	@Test(priority=3, testName="GPS")
	public void blockGps() throws InterruptedException {
		
		AndroidRestrictionsPage androidRestrictionPage = new AndroidRestrictionsPage(driver);
		Thread.sleep(1000);
		androidRestrictionPage.gpsRestriction(1);
		IntactAppPage intactAppPage = new IntactAppPage(mobileDriver);
		intactAppPage.sync(0);
		intactAppPage.openAndroidSettings();
		AndroidSettingsPage androidSettingsPage = new AndroidSettingsPage(mobileDriver);
		androidSettingsPage.openGedGpsStngs();
		LocationPage locationPage = new LocationPage(mobileDriver);
		locationPage.validLocClosed();
		String expected = "OFF";
		String actual = locationPage.gedLoacationText();
		Assert.assertEquals(actual, expected);
		
	}

	@Test(priority=4, testName="Factory reset")
	public void blockFactoryReset() throws InterruptedException {
		
		AndroidRestrictionsPage androidRestrictionPage = new AndroidRestrictionsPage(driver);
		androidRestrictionPage.blockFactoryCb();
		Thread.sleep(1000);
		IntactAppPage intactAppPage = new IntactAppPage(mobileDriver);
		intactAppPage.sync(0);
		Thread.sleep(3000);
		intactAppPage.openAndroidSettings();
		AndroidSettingsPage androidSettingsPage = new AndroidSettingsPage(mobileDriver);
		androidSettingsPage.openGedRestOp("System");
		BackupResetPage resetPage = new BackupResetPage(mobileDriver);
		resetPage.openRestrictionMessage();
		String expected = "Action not allowed";
		String actual = resetPage.getRestrictionMessage();
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority=5, testName="Mobile data")
	public void blockMobileData() throws InterruptedException {
		
		AndroidRestrictionsPage androidRestrictionPage = new AndroidRestrictionsPage(driver);
		//androidRestrictionPage.blockWiFi(0);
		androidRestrictionPage.sdoMobileDataPolicy(1);
		IntactAppPage intactAppPage = new IntactAppPage(mobileDriver);
		intactAppPage.sync(0);
		intactAppPage.openAndroidSettings();
		AndroidSettingsPage androidSettingsPage = new AndroidSettingsPage(mobileDriver);
		androidSettingsPage.openGedDataUsage();
		DataUsagePage dataUsagePage = new DataUsagePage(mobileDriver);
		dataUsagePage.clickOnDataBtn();
		Thread.sleep(5000);
		String expected = "OFF";
		String actual = dataUsagePage.cellurDataText();
		Assert.assertEquals(actual, expected);
		
	}
	
	@Test(priority=6, testName="Airplane")
	public void blockAirplane() throws InterruptedException {
		AndroidRestrictionsPage androidRestrictionPage = new AndroidRestrictionsPage(driver);
		androidRestrictionPage.sdoMobileDataPolicy(0);
		Thread.sleep(1000);
		androidRestrictionPage.blockAirplaneCb();
		IntactAppPage intactAppPage = new IntactAppPage(mobileDriver);
		intactAppPage.sync(0);
		intactAppPage.openAndroidSettings();
		AndroidSettingsPage androidSettingsPage = new AndroidSettingsPage(mobileDriver);
		androidSettingsPage.openGedNtwInt();
		GedNetworkInternetPage gedNetworkInternetPage = new GedNetworkInternetPage(mobileDriver);
		gedNetworkInternetPage.clickApMdBtn();
		Thread.sleep(5000);
		String expected = "OFF";
		String actual = gedNetworkInternetPage.getApMdBtnTxt();
		Assert.assertEquals(actual, expected);
		
	}
	
	@Test(priority=7, testName="Disallow install app")
	public void blockAppinst() throws  InterruptedException {
		AndroidRestrictionsPage androidRestrictionPage = new AndroidRestrictionsPage(driver);
		androidRestrictionPage.clickAppInstBlock();
		IntactAppPage intactAppPage = new IntactAppPage(mobileDriver);
		intactAppPage.sync(0);
		intactAppPage.openAndroidSettings();
		intactAppPage.openGedDownloadFolder("Storage", "Files"/*,"Download"*/);
		DownloadFolderPage downloadfolderpage = new DownloadFolderPage(mobileDriver);
		Thread.sleep(3000);
		downloadfolderpage.clickOnAppGed("MyDeviceAndroidClient-Att-release.apk");
		InstallationAppPage installationapppage = new InstallationAppPage(mobileDriver);
		//Thread.sleep(5000);
		//installationapppage.installApp();
		String expected = "Action not allowed";
		String actual = installationapppage.getGedInstBlkMsg();
		Assert.assertEquals(actual, expected);
		
	}
	
	@Test(priority=8, testName="Disallow uninstall app")
	public void blockUninstallApp() throws InterruptedException {
		AndroidRestrictionsPage androidRestrictionPage = new AndroidRestrictionsPage(driver);
		androidRestrictionPage.clickAppUninstallBlock();
		IntactAppPage intactAppPage = new IntactAppPage(mobileDriver);
		intactAppPage.sync(0);
		intactAppPage.openAndroidSettings();
		AndroidSettingsPage androidSettingsPage = new AndroidSettingsPage(mobileDriver);
		androidSettingsPage.openGedApps();
		AppsPage appspage = new AppsPage(mobileDriver);
		appspage.clickAppiumSet();
		AppiumAppPage appiumAppPage = new AppiumAppPage(mobileDriver);
		appiumAppPage.uninstallAppiumApp();
		String expected = "Action not allowed";
		String actual = appiumAppPage.getAppiumAppMessage();
		Assert.assertEquals(actual, expected);
		
	}
	
	@Test(priority=9, testName="Disallow SMS")
	public void blockSmsApp() throws InterruptedException {
		AndroidRestrictionsPage androidRestrictionPage = new AndroidRestrictionsPage(driver);
		androidRestrictionPage.clickDisSmsCb();
		IntactAppPage intactAppPage = new IntactAppPage(mobileDriver);
		intactAppPage.sync(0);
		Thread.sleep(1000);
		intactAppPage.Home();
		MobileHomePage mobileHomePage = new MobileHomePage(mobileDriver);
		mobileHomePage.openSmsApp();
		SmsPage smspage = new SmsPage(mobileDriver);
		String expected = "This user is not allowed to use SMS";
		String actual = smspage.getSmsPerMsg();
		Assert.assertEquals(actual, expected);
	}
	/*
	@Test(priority=10, testName="Wifi")
	public void wifi1() throws  InterruptedException {
		
		AndroidRestrictionsPage androidRestrictionPage = new AndroidRestrictionsPage(driver);
		androidRestrictionPage.blockWiFi(1);
		IntactAppPage intactAppPage = new IntactAppPage(mobileDriver);
		//intactAppPage.turnOnOfWiFi();
		intactAppPage.sync(0);
		Thread.sleep(2000);
		intactAppPage.openAndroidSettings();
		AndroidSettingsPage androidSettingsPage = new AndroidSettingsPage(mobileDriver);
		androidSettingsPage.openGedNtwInt();
		GedNetworkInternetPage gedNetworkInternetPage = new GedNetworkInternetPage(mobileDriver);
		gedNetworkInternetPage.clickGedWifiBtn();
		Thread.sleep(3000);
		String expected = "OFF";
		String actual = gedNetworkInternetPage.gedWifiBtnTxt();
		Assert.assertEquals(actual, expected);
		
	}
	*/
	@Test(priority=11, testName="Reset restrictions")
	public void resetRestrictions() throws InterruptedException {
		AndroidRestrictionsPage androidRestrictionPage = new AndroidRestrictionsPage(driver);
		androidRestrictionPage.resetRestrictions(2);
		Thread.sleep(1000);
		androidRestrictionPage.resetRestrictions(1);
		IntactAppPage intactAppPage = new IntactAppPage(mobileDriver);
		intactAppPage.sync(0);
		Thread.sleep(3000);
		
		
	}
	
}

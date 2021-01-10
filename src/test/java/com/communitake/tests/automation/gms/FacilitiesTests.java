package com.communitake.tests.automation.gms;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.communitake.tests.automation.mobilepageobject.AndroidSettingsPage;
import com.communitake.tests.automation.mobilepageobject.BlueToothPage;
import com.communitake.tests.automation.mobilepageobject.CameraPage;
import com.communitake.tests.automation.mobilepageobject.DataUsagePage;
import com.communitake.tests.automation.mobilepageobject.GedNetworkInternetPage;
import com.communitake.tests.automation.mobilepageobject.IntactAppPage;
import com.communitake.tests.automation.mobilepageobject.LocationPage;
import com.communitake.tests.automation.mobilepageobject.MobileHomePage;
import com.communitake.tests.automation.webpageobject.AndroidRestrictionsPage;
import com.communitake.tests.automation.webpageobject.HomePage;
import com.communitake.tests.automation.webpageobject.PoliciesPage;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


public class FacilitiesTests extends BaseTest3 {
	
	@Feature("GMS Bluetooth")
	@Epic("Blocking Bluetooth")
	@Severity(SeverityLevel.NORMAL)
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
		Thread.sleep(3000);
		bluetoothPage.openGedBTBtn();
		Thread.sleep(3000);
		bluetoothPage.validBTClosed();
		Thread.sleep(3000);
		String expected = "OFF";
		String actual = bluetoothPage.gedBTClosedText();
		Assert.assertEquals(actual, expected);

	}
	@Feature("GMS camera")
	@Epic("Blocking camera")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=2, testName="Camera")
	public void blockCamera() throws InterruptedException {

		AndroidRestrictionsPage androidRestrictionPage = new AndroidRestrictionsPage(driver);
		Thread.sleep(10000);
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
	@Feature("GMS GPS")
	@Epic("Blocking GPS")
	@Severity(SeverityLevel.NORMAL)
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
	
	@Feature("GMS Mobile data")
	@Epic("Blocking Mobile data")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=4, testName="Mobile data")
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
	/*
	@Test(priority=5, testName="Wifi")
	public void wifi1() throws  InterruptedException {
		
		AndroidRestrictionsPage androidRestrictionPage = new AndroidRestrictionsPage(driver);
		androidRestrictionPage.sdoMobileDataPolicy(0);
		Thread.sleep(1000);
		androidRestrictionPage.blockWiFi(1);
		IntactAppPage intactAppPage = new IntactAppPage(mobileDriver);
		intactAppPage.sync(0);
		Thread.sleep(2000);
		intactAppPage.openAndroidSettings();
		AndroidSettingsPage androidSettingsPage = new AndroidSettingsPage(mobileDriver);
		androidSettingsPage.openGedNtwInt();
		GedNetworkInternetPage gedNetworkInternetPage = new GedNetworkInternetPage(mobileDriver);
		Thread.sleep(3000);
		//gedNetworkInternetPage.clickGedWifiBtn();
		//Thread.sleep(3000);
		String expected = "OFF";
		String actual = gedNetworkInternetPage.gedWifiBtnTxt();
		Assert.assertEquals(actual, expected);
		
	}
	*/
	@Feature("GMS Airplane")
	@Epic("Blocking Airplane")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=5, testName="Airplane")
	public void blockAirplane() throws InterruptedException {
		AndroidRestrictionsPage androidRestrictionPage = new AndroidRestrictionsPage(driver);
		androidRestrictionPage.blockWiFi(0);
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
	@Feature("Android restrictions")
	@Epic("Reseting Android restrictions")
	@Severity(SeverityLevel.TRIVIAL)
	@Test(priority=6, testName="Reset restrictions")
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

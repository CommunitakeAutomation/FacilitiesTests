package com.communitake.tests.automation.intactR;

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
import com.communitake.tests.automation.mobilepageobject.InstallationAppPage;
import com.communitake.tests.automation.mobilepageobject.IntactAppPage;
import com.communitake.tests.automation.mobilepageobject.LocationPage;
import com.communitake.tests.automation.mobilepageobject.MobileHomePage;
import com.communitake.tests.automation.mobilepageobject.MorePage;
import com.communitake.tests.automation.mobilepageobject.SmsPage;
import com.communitake.tests.automation.webpageobject.AndroidRestrictionsPage;
import com.communitake.tests.automation.webpageobject.HomePage;
import com.communitake.tests.automation.webpageobject.PoliciesPage;

public class FacilitiesTest extends BaseTest {

	
	@Test(priority=1, testName="Bluetooth")
	public void blockBT() throws  InterruptedException {
		
		HomePage homepage = new HomePage(driver);
		homepage.clickPolicies();
		PoliciesPage policiespage = new PoliciesPage(driver);
		policiespage.clickAndroidRestriction();
		AndroidRestrictionsPage androidRestrictionPage = new AndroidRestrictionsPage(driver);
		Thread.sleep(1000);
		androidRestrictionPage.BtConfig(1);
		IntactAppPage intactAppPage = new IntactAppPage(mobileDriver);
		intactAppPage.sync(0);
		intactAppPage.openRBTSet();
		BlueToothPage bluetoothpage = new BlueToothPage(mobileDriver);
		bluetoothpage.validBTClosed();
		String expected = "Off";
		String actual = bluetoothpage.BTclosedText();
		Assert.assertEquals(actual, expected);

	}
	
	@Test(priority=2, testName="Camera")
	public void blockCamera() throws InterruptedException {

		AndroidRestrictionsPage androidRestrictionPage = new AndroidRestrictionsPage(driver);
		androidRestrictionPage.cameraStatus(2);
		IntactAppPage intactAppPage = new IntactAppPage(mobileDriver);
		intactAppPage.sync(0);
		//Thread.sleep(3000);
		intactAppPage.Home();
		MobileHomePage mobileHomePage = new MobileHomePage(mobileDriver);
		mobileHomePage.openCamera();
		CameraPage camerapage = new CameraPage(mobileDriver);
		String expected = "Approve the application's access to the camera";
		String actual = camerapage.cameraTextMessage();
		Assert.assertEquals(actual, expected);

	} 
	
	@Test(priority=3, testName="GPS")
	public void blockGps() throws InterruptedException {
		
		AndroidRestrictionsPage androidRestrictionPage = new AndroidRestrictionsPage(driver);
		androidRestrictionPage.gpsRestriction(1);
		IntactAppPage intactAppPage = new IntactAppPage(mobileDriver);
		intactAppPage.sync(0);
		Thread.sleep(30000);
		intactAppPage.openNotifications();
		intactAppPage.expendNotofocations();
		intactAppPage.openLocNoti();
		LocationPage locationpage = new LocationPage(mobileDriver);
		locationpage.validLocClosed();
		Thread.sleep(5000);
		String expected = "Off";
		String actual = locationpage.locationText();
		Assert.assertEquals(actual, expected);
		
	}
	
	@Test(priority=4, testName="Factory reset")
	public void blockFactoryReset() throws InterruptedException {
		
		AndroidRestrictionsPage androidRestrictionPage = new AndroidRestrictionsPage(driver);
		androidRestrictionPage.blockFactoryCb();
		Thread.sleep(1000);
		IntactAppPage intactAppPage = new IntactAppPage(mobileDriver);
		intactAppPage.sync(0);
		Thread.sleep(10000);
		intactAppPage.openAndroidSettings();
		AndroidSettingsPage androidSettingsPage = new AndroidSettingsPage(mobileDriver);
		androidSettingsPage.clickOnBackup("Backup & reset");
		BackupResetPage backupresetpage = new BackupResetPage(mobileDriver);
		backupresetpage.openRestrictionMessage();
		String expected = "Action not allowed";
		String actual = backupresetpage.getRestrictionMessage();
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority=5, testName="Mobile data")
	public void blockMobileData() throws InterruptedException {
		
		AndroidRestrictionsPage androidRestrictionPage = new AndroidRestrictionsPage(driver);
		androidRestrictionPage.sdoMobileDataPolicy(1);
		IntactAppPage intactAppPage = new IntactAppPage(mobileDriver);
		intactAppPage.sync(0);
		Thread.sleep(3000);
		intactAppPage.openAndroidSettings();
		AndroidSettingsPage androidSettingsPage = new AndroidSettingsPage(mobileDriver);
		androidSettingsPage.openDataUsage("Data usage");
		DataUsagePage dataUsagePage = new DataUsagePage(mobileDriver);
		dataUsagePage.validMoDaClosed();
		Thread.sleep(5000);
		String expected = "OFF";
		String actual = dataUsagePage.cellurDataText();
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority=6, testName="Airplane")
	public void blockAirplane() throws InterruptedException {
		AndroidRestrictionsPage androidRestrictionPage = new AndroidRestrictionsPage(driver);
		androidRestrictionPage.sdoMobileDataPolicy(0);
		androidRestrictionPage.blockAirplaneCb();
		IntactAppPage intactAppPage = new IntactAppPage(mobileDriver);
		intactAppPage.sync(0);
		Thread.sleep(3000);
		intactAppPage.openApmSet();
		MorePage morepage = new MorePage(mobileDriver);
		morepage.validApClosed();
		String expected = "OFF";
		String actual = morepage.getAirPlnBtnText();
		Assert.assertEquals(actual, expected);
	}

	@Test(priority=7, testName="Disallow install app")
	public void blockAppinst() throws  InterruptedException {
		AndroidRestrictionsPage androidRestrictionPage = new AndroidRestrictionsPage(driver);
		androidRestrictionPage.clickAppInstBlock();
		IntactAppPage intactAppPage = new IntactAppPage(mobileDriver);
		intactAppPage.sync(0);
		intactAppPage.Back();
		intactAppPage.openDownloadFolder();
		DownloadFolderPage downloadfolderpage = new DownloadFolderPage(mobileDriver);
		downloadfolderpage.clickOnAppR();
		InstallationAppPage installationapppage = new InstallationAppPage(mobileDriver);
		installationapppage.installApp();
		String expected = "Package installer has stopped";
		String actual = installationapppage.getInstMsg();
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority=8, testName="Disallow uninstall app")
	public void blockUninstallApp() throws InterruptedException {
		AndroidRestrictionsPage androidRestrictionPage = new AndroidRestrictionsPage(driver);
		androidRestrictionPage.clickAppUninstallBlock();
		IntactAppPage intactAppPage = new IntactAppPage(mobileDriver);
		intactAppPage.sync(0);
		Thread.sleep(3000);
		intactAppPage.openAndroidSettings();
		AndroidSettingsPage androidSettingsPage = new AndroidSettingsPage(mobileDriver);
		androidSettingsPage.clickOnApps("Apps");
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
		Thread.sleep(5000);
		intactAppPage.Home();
		MobileHomePage mobileHomePage = new MobileHomePage(mobileDriver);
		mobileHomePage.openSmsApp();
		SmsPage smspage = new SmsPage(mobileDriver);
		String expected = "This user is not allowed to use SMS";
		String actual = smspage.getSmsPerMsg();
		Assert.assertEquals(actual, expected);
	}
	/*
	@Test(priority=10, testName="wifi")
	public void wifi() throws  InterruptedException {
		AndroidRestrictionsPage androidRestrictionPage = new AndroidRestrictionsPage(driver);
		androidRestrictionPage.blockWiFi(1);
		IntactAppPage intactAppPage = new IntactAppPage(mobileDriver);
		intactAppPage.sync(0);
		intactAppPage.openAndroidSettings();
		AndroidSettingsPage androidSettingsPage = new AndroidSettingsPage(mobileDriver);
		androidSettingsPage.openWifiSet();
		WiFiPage wifipage = new WiFiPage(mobileDriver);
		wifipage.validWifiClosed();
		String expected = "Off";
		String actual = wifipage.wifiClosedText();
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
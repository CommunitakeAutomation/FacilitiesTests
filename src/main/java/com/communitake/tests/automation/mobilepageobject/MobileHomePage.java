package com.communitake.tests.automation.mobilepageobject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class MobileHomePage extends AppiumBasePage {
	
	//Intact App
	@AndroidFindBy(xpath = "//*[@text='Apps']")
	MobileElement intactApp;
	
	//Apps button
	@AndroidFindBy(id="Apps")
	MobileElement appsButton;
	
	//Hebrew date app
	@AndroidFindBy(id="HebDate")
	MobileElement HebDateApp;
	
	//Uninstalling on home screen
	@AndroidFindBy(xpath = "//*[@text='Uninstall']")
	MobileElement uninstalling;
	
	//SMS app
	@AndroidFindBy(id="Messaging")
	MobileElement smsAppHs;
	
	//GED camera app
	@AndroidFindBy(id = "Camera")
	MobileElement gedCameraApp;
	
	//Camera app
	@AndroidFindBy(id="Camera")
	MobileElement cameraApp;
	
	public MobileHomePage(AppiumDriver<MobileElement> mobileDriver) {
		super(mobileDriver);	

	}
	
	public void enterIntactApp() {
		click(intactApp);
	}
	
	public void enterAppsScreen() {
		click(appsButton);
	}
	
	public void uninstallApp() {
		dragNdrop(HebDateApp,uninstalling);
	}
	
	public void openSmsApp() {
		sleep(3000);
		click(smsAppHs);
	}
	
	public void openGedCamera() {
		click(gedCameraApp);
	}
	
	public void openCamera() {
		click(cameraApp);
	}
}
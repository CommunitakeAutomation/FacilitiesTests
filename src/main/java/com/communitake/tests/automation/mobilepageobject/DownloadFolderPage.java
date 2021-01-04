package com.communitake.tests.automation.mobilepageobject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class DownloadFolderPage extends AppiumBasePage {

	//Application in GED folder
	@AndroidFindBy(xpath="//*[@text='MyDeviceAndroidClient-Att-release.apk']")
	MobileElement appInGedFolder; 

	//Application in Intact 4
	@AndroidFindBy(xpath="//*[@text='MyDeviceAndroidClient-ReleaseSip-release.apk']")
	MobileElement appInIntact4;

	//Application in R
	@AndroidFindBy(id="com.mediatek.filemanager:id/edit_adapter_img")
	MobileElement appInIntactR;

	public DownloadFolderPage(AppiumDriver<MobileElement> mobileDriver) {
		super(mobileDriver);

	}

	public void clickOnAppGed(String text) {
		scrollToText(text);
		if(appInGedFolder.isDisplayed()) {
			appInGedFolder.click();
		}
	}

	public void clickOnAppR() {
		click(appInIntactR);
	}

	public void clickOnAppIntact4(String text) {
		scrollToText(text);
		if(appInIntact4.isDisplayed()) {
			appInIntact4.click();
		}

	}
}
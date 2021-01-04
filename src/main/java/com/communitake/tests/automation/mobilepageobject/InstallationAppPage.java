package com.communitake.tests.automation.mobilepageobject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class InstallationAppPage extends AppiumBasePage {

	//Install button
	@AndroidFindBy(id ="com.android.packageinstaller:id/ok_button")
	MobileElement installBtn;
	
	//Installer stopped message
	@AndroidFindBy(xpath ="//*[@text='Package installer has stopped']")
	MobileElement instStopMsg;
	
	//GED block installation message
	@AndroidFindBy(xpath = "//*[@text='Action not allowed']")
	MobileElement gedInstBlkMsg;
	
	//GED message CONTITNUE to install
	@AndroidFindBy(xpath = "//*[@text='CONTINUE']")
	MobileElement countinueInst;
	
	public InstallationAppPage(AppiumDriver<MobileElement> mobileDriver) {
		super(mobileDriver);
		
	}
	
	public void installApp() {
		//click(countinueInst);
		//sleep(500);
		click(installBtn);
	}
	
	public String getInstMsg() {
		return getmText(instStopMsg);
	}
	
	public String getGedInstBlkMsg() {
		return getmText(gedInstBlkMsg);
	}

}


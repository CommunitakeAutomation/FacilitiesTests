package com.communitake.tests.automation.ged;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.communitake.tests.automation.BaseTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;



public abstract class BaseTest1 extends BaseTest {
	
	@BeforeSuite
	public AppiumDriver<MobileElement> mobile() throws MalformedURLException  {
		return mobile("CTGED01", "CTGED010002914", "9");
//		service = AppiumDriverLocalService.buildDefaultService();
//		service.start();
//		DesiredCapabilities caps = new DesiredCapabilities();
//		caps.setCapability("deviceName", "CTGED01");
//		caps.setCapability("udid", "CTGED010000468"); 
//		caps.setCapability("platformName", "Android"); 
//		caps.setCapability("platformVersion", "9");
//		caps.setCapability("browserName", "");
//		caps.setCapability("appPackage", "com.communitake.mdc.supportsip");
//		caps.setCapability("appActivity", "com.communitake.mdc.SplashScreen");
//		caps.setCapability("noReset", "true");
//		caps.setCapability("automationName", "UiAutomator1");
//		//Instantiate Appium Driver
//		mobileDriver= new AndroidDriver<MobileElement>(service.getUrl(), caps);
//		
//		System.out.println(service.isRunning());
//		mobileDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		return mobileDriver;
	}

	@BeforeMethod
	public void Appium() throws MalformedURLException {
		mobileDriver = mobile();
	}
	
	@AfterClass
	public void tearDown() throws IOException {
		mobileDriver.quit();
		service.stop();
		driver.quit();
		Runtime.getRuntime().exec("TASKKILL /F /IM node.exe");
	}

}//saar

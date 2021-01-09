package com.communitake.tests.automation.gms;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.communitake.tests.automation.BaseTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;



public abstract class BaseTest3 extends BaseTest {
	
	@BeforeSuite
	public AppiumDriver<MobileElement> mobile() throws MalformedURLException  {
//		AppiumServiceBuilder builder = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Nissim Automation\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"));
//		service = builder.build();
		service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "CTGED02");
		caps.setCapability("udid", "CTGED020000261"); 
		caps.setCapability("platformName", "Android"); 
		caps.setCapability("platformVersion", "9");
		caps.setCapability("browserName", "");
		caps.setCapability("appPackage", "com.communitake.mdc.supportsip");
		caps.setCapability("appActivity", "com.communitake.mdc.SplashScreen");
		caps.setCapability("noReset", "true");
		caps.setCapability("automationName", "UiAutomator1");
		//Instantiate Appium Driver
		mobileDriver= new AndroidDriver<MobileElement>(service.getUrl(), caps);
		
		System.out.println(service.isRunning());
		mobileDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return mobileDriver;
	}

	@BeforeMethod
	public void Appium() throws MalformedURLException {
		mobileDriver = mobile();
	}
	
	@AfterClass
	//public void tearDown() {
		//driver.quit();
	public void tearDown() throws IOException {
		mobileDriver.quit();
		service.stop();
		driver.quit();
		Runtime.getRuntime().exec("TASKKILL /F /IM node.exe");
	}

}

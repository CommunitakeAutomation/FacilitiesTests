package com.communitake.tests.automation.bond;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;



public abstract class BaseTest extends com.communitake.tests.automation.BaseTest {
	
	
	@BeforeSuite
	public AppiumDriver<MobileElement> mobile() throws MalformedURLException  {
		return mobile("CTIP511", "CTGED010003017", "9");
		//		AppiumServiceBuilder builder = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Nissim Automation\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"));
//		service = builder.build();
//		service = AppiumDriverLocalService.buildDefaultService();
//		service.start();
//		DesiredCapabilities caps = new DesiredCapabilities();
//		caps.setCapability("deviceName", "CTIPR01");
//		caps.setCapability("udid", "WG9SDIUKHIRWNZGA"); 
//		caps.setCapability("platformName", "Android"); 
//		caps.setCapability("platformVersion", "7");
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

}

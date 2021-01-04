package com.communitake.tests.automation.intactR;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.communitake.tests.automation.webpageobject.LoginPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;



public abstract class BaseTest {
	WebDriver driver;
	//AppiumDriver<MobileElement> mobileDriver;
	private AppiumDriverLocalService service;
	protected AppiumDriver<MobileElement> mobileDriver;



	@BeforeClass

	public void Web() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://mydevice.communitake.com/MDPortal/login?customer=en");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("nissim+2000@communitake.com", "na260438");
	}
	
	@BeforeSuite
	public AppiumDriver<MobileElement> mobile() throws MalformedURLException  {
		//AppiumDriver<MobileElement> mobileDriver;
		service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "CTIPR01");
		caps.setCapability("udid", "WG9SDIUKHIRWNZGA"); 
		caps.setCapability("platformName", "Android"); 
		caps.setCapability("platformVersion", "7");
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
	public void tearDown() throws IOException {
		mobileDriver.quit();
		service.stop();
		driver.quit();
		Runtime.getRuntime().exec("TASKKILL /F /IM node.exe");
	}

}

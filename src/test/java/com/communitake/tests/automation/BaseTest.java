package com.communitake.tests.automation;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;

import com.communitake.tests.automation.webpageobject.LoginPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseTest {

	protected WebDriver driver;
	protected AppiumDriverLocalService service;
	protected AppiumDriver<MobileElement> mobileDriver;
	
	@BeforeClass

	public void Web() {
		
		driver = new ChromeDriver();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setCapability("browserVersion", "67");
		chromeOptions.setCapability("platformName", "Windows XP");
		try {
			driver  = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		driver.get("https://mydevice.communitake.com/MDPortal/login?customer=en");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("nissim+2000@communitake.com", "na260438");
	}
}

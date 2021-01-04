package com.communitake.tests.automation.mobilepageobject;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.FindsByAndroidUIAutomator;


public abstract class AppiumBasePage {

	@SuppressWarnings("rawtypes")
	AppiumDriver mobileDriver;

	public AppiumBasePage(AppiumDriver<MobileElement> mobileDriver) {
		this.mobileDriver = mobileDriver;
		PageFactory.initElements(new AppiumFieldDecorator(mobileDriver), this);
	}
	
	public void sleep(long mil) {
		try {
			Thread.sleep(mil);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void click(WebElement el ) {
		el.click();
	}

	public void sendKeys(WebElement el, String text) {
		el.clear();
		el.sendKeys(text);

	}

	public String getmText(WebElement el) {
		return el.getText();
	}

	@SuppressWarnings("rawtypes")
	public void longPress(MobileElement mel, int timeInSeconds) {
		TouchAction touch =new TouchAction(mobileDriver);
		touch.longPress(longPressOptions().withElement(element(mel)).withDuration
				(ofSeconds(timeInSeconds))).release().perform();
	}

	public void rotateScreenPotrait() {
		mobileDriver.rotate(ScreenOrientation.PORTRAIT);
	}

	public void rotateScreenlandscape() {
		mobileDriver.rotate(ScreenOrientation.LANDSCAPE);
	}

	@SuppressWarnings("rawtypes")
	public void openNotifications() {
		((AndroidDriver) mobileDriver).openNotifications();
	}

	@SuppressWarnings("rawtypes")
	public void wifiTurnONoff() {
		((AndroidDriver) mobileDriver).toggleWifi();
	}

	public void Back() {
		mobileDriver.navigate().back();
	}
	
	public void refresh() {
		mobileDriver.resetApp();
	}

	public void Home() {
		((PressesKey) mobileDriver).pressKey(new KeyEvent(AndroidKey.HOME));
	}
	
	public void reload() {
		mobileDriver.getPageSource();
	}
	
	@SuppressWarnings("unchecked")
	public void scrollToText (String text) {
		((FindsByAndroidUIAutomator<MobileElement>) mobileDriver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));");
	}
	
	public void clickByCoordinates(int x, int y) {
		@SuppressWarnings("rawtypes")
		TouchAction touch=new TouchAction(mobileDriver);
		PointOption.point(x, y);
		touch.perform();
	}

	public void wait_until_MobileElementIs_Clickable(MobileElement element) {
		WebDriverWait wait = new WebDriverWait(mobileDriver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void wait_until_MobileElementIs_Visible(MobileElement element) {
		WebDriverWait wait = new WebDriverWait(mobileDriver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void dragNdrop(MobileElement element, MobileElement element1) {
		@SuppressWarnings("rawtypes")
		TouchAction touch = new TouchAction(mobileDriver);
		touch.longPress(element(element)).moveTo(element(element1)).release().perform();
		
	}
	
	public void reset() {
		mobileDriver.resetApp();
	}
	
	
	
	
}


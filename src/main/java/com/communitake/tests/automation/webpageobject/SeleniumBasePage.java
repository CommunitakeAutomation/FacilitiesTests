package com.communitake.tests.automation.webpageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class SeleniumBasePage {

	WebDriver driver;
	JavascriptExecutor js;


	public SeleniumBasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		js=(JavascriptExecutor)driver;
	}

	public void click(WebElement el) {
		highlightElement(el, "yellow");
		el.click();
	}

	public void fillText(WebElement el, String text) {
		highlightElement(el, "blue");
		el.clear();
		el.sendKeys(text);
	}

	public String getText(WebElement el) {
		highlightElement(el, "green");
		return el.getText();
	}

	public String getUrl(WebElement el) {
		highlightElement(el, "#7FFFD4");
		return el.getText();
	}

	public void isDisplayed(WebElement el) {
		highlightElement(el, "white");
		el.isDisplayed();

	}

	public void isSelected(WebElement el) {
		highlightElement(el,"orange");
		el.isSelected();
	}

	public void waitForElementToBeClickable (String element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(element)));
	}

	public void sleep(long mil) {
		try {
			Thread.sleep(mil);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	public void selectText(WebElement el, String text) {
		highlightElement(el, "pink");
		Select select = new Select(el);
		select.selectByVisibleText(text);
	}
	
	public void wairForElementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForElementToBeVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/*
	 * call this method with your element and a color you like (red, green, orange, blue etc...)
	 */
	protected void highlightElement(WebElement element, String color) {
		//keep the old style to change it back
		String originalStyle = element.getAttribute("style");
		String newStyle = "border: 3px solid " + color + ";" + originalStyle;
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Change the style 
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '" + newStyle + "');},0);",
				element);

		//change the style back after few seconds
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ originalStyle + "');},1000);", element);

	}
}
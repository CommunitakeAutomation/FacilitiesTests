package com.communitake.tests.automation.webpageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends SeleniumBasePage {

	//Elements on the page:

	//User name
	@FindBy(css="#user")
	WebElement userName;
	//Password
	@FindBy(css="#password")
	WebElement password;
	//Login button
	@FindBy(css="#Login_commandButton")
	WebElement loginButton;
	//Forgot my password
	@FindBy(linkText="Forgot my password")
	WebElement forgotMyPassword;
	//Error message
	@FindBy(css="#lastMessageText")
	WebElement errorMsg;	

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	public void login(String Name, String Password) {
		fillText(userName, Name);
		fillText(password, Password);
		click(loginButton);
	}
}



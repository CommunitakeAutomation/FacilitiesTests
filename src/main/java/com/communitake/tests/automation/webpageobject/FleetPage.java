package com.communitake.tests.automation.webpageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FleetPage extends SeleniumBasePage {
	
	//Fleet page Elements
	//Add device
	@FindBy (css="#subscribersex_de_new_devicevices_add")
	WebElement addDevice;
	//msisdn/email
	@FindBy (css= "#add_new_device_group_msisdn_input")
	WebElement msisdnEmail;
	//Owner name
	@FindBy (css= "#add_new_device_group_owner_name_input")
	WebElement ownerName;
	//Owner email
	@FindBy (css="#add_new_device_group_owner_email_input")
	WebElement ownerEmail;
	//Add button on dialog box
	@FindBy (css=".add")
	WebElement addBtn;
	
	public FleetPage(WebDriver driver) {
		super(driver);
	}
	
	public void addNewDevice() {
		click(addDevice);
	}
	
	public void deviceDetails(String mail, String name, String email) {
		fillText(msisdnEmail, mail);
		fillText(ownerName, name);
		fillText(ownerEmail, email);
		click(addBtn);
		
	}

	public void check(){
		system.out.println("nothing")
	}

}

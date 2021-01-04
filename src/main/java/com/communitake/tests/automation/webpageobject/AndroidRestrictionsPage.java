package com.communitake.tests.automation.webpageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidRestrictionsPage extends SeleniumBasePage {

	
	//Restrictions General policy 0=Inherit 1=Enable 2=Disable
	@FindBy(css=".policy_selection td")
	List<WebElement> restrictionsPolicy;
	
	//Apply button
	@FindBy(css=".policy_apply_discard_buttonbar [value='Apply']")
	WebElement applyRestriction;
	
	//General Block camera cb
	@FindBy(css=".android_restrictions_checkbox_camera")
	WebElement blockCameraCb;
	
	//wifi policy 0=on 1=block 2=no policy
	@FindBy(css=".android-restrictions-threestate-wifi td")
	List<WebElement> wifiPolicy;
	
	//Camera Intact policy.
	@FindBy(css=".android-restrictions-threestate-fw_camera td")
	List<WebElement> cameraPolicy;
	
	//Bluetooth 0=on 1=block 2=no policy
	@FindBy(css=".android-restrictions-threestate-bluetooth td")
	List<WebElement> bloutoothRestriction;
	
	//2G policy 0=allow 1=block 2=warn user
	@FindBy(css=".android-restrictions-threestate-_2g tr")
	List<WebElement> policyG2;
	
	//Open INTACTPHONE restriction.
	@FindBy(css=".secure_rom .expandable_header")
	WebElement intactRistriction;
	
	//Block factory reset cb
	@FindBy(css=".android_restrictions_checkbox_fw_factoryreset")
	WebElement factoryResetCb;
	
	//BLOCK MOBILE DATA
	@FindBy(css=".android_restrictions_checkbox_fw_data")
	WebElement blockMobileDataBtn;
		
	//General SDO - Header button.
	@FindBy(css=".expandable_header .general_signed_only")
	WebElement generalSdoBtn;
	
	//GPS 0=on 1=block 2=no policy
	@FindBy(css=".android-restrictions-threestate-sign_gps td")
	List<WebElement> gpsPolicy;	
	
	//Roming 
	@FindBy(css=".android-restrictions-threestate-sign_roam td")
	List<WebElement> roamingPolicy;
	
	//Mobile data policy SDO
	@FindBy(css=".android-restrictions-threestate-sign_cellulardata td")
	List<WebElement> sdoMdPoli;
	
	//Corporate devices header
	@FindBy(css=".expandable_header .corporate_devices")
	WebElement corporateDeviceBtn;
	
	//corporate device - disallow factory reset
	@FindBy(css=".android_restrictions_checkbox_cp_factoryReset")
	WebElement CDfactoryResetCb;
	
	//BLOCK AIRPLANE MODE SDO
	@FindBy(css=".android_restrictions_checkbox_sign_airplane")
	WebElement airplanePolicy;
	
	//Corporate - Block App install  
	@FindBy(css=".android_restrictions_checkbox_cp_installApps")
	WebElement blockAppInstCb;
	
	//Corporate - Block App uninstall
	@FindBy(css=".android_restrictions_checkbox_cp_unintallApps")
	WebElement blockAppUninstall;
	
	//Corporate - Disallow SMS.
	@FindBy(css=".android_restrictions_checkbox_cp_sms")
	WebElement disSmsCb;
	

	public AndroidRestrictionsPage(WebDriver driver) {
		super(driver);
	}
	
	public void blockCamera() {
		click(blockCameraCb);
		sleep(500);
		click(applyRestriction);
	}

	public void blockWiFi(int i) {
		click(wifiPolicy.get(i));
		sleep(500);
		click(applyRestriction);
		sleep(500);
	}

	public void cameraStatus(int i) {
		click(intactRistriction);
		sleep(1500);
		click(cameraPolicy.get(i));
		sleep(500);
		click(applyRestriction);
		sleep(500);
	}
	
	public void BtConfig(int i) {
		click(bloutoothRestriction.get(i));
		sleep(500);
		click(applyRestriction);
		sleep(500);
	
	}
	
	public void blockFactoryCb() {
		click(corporateDeviceBtn);
		sleep(500);
		click(CDfactoryResetCb);
		sleep(500);
		click(applyRestriction);
	
	}
	
	public void clickMobileDataCb() {
		click(blockMobileDataBtn);
		sleep(500);
		click(applyRestriction);
		sleep(1000);
	}
	
	public void sdoMobileDataPolicy(int i) {
		click(sdoMdPoli.get(i));
		sleep(500);
		click(applyRestriction);
		sleep(1000);
	}
	
	public void roamingStatus(int i) {
		click(roamingPolicy.get(i));
		sleep(500);
		click(applyRestriction);
		sleep(1000);
	}
	
	public void gpsRestriction(int i) {
		click(generalSdoBtn);
		sleep(500);
		click(gpsPolicy.get(i));
		sleep(500);
		click(applyRestriction);
		
	}
	
	public void blockAirplaneCb() {
		click(airplanePolicy);
		sleep(500);
		click(applyRestriction);
		sleep(500);
	}
	 
	public void clickAppInstBlock() {
		click(blockAppInstCb);
		sleep(500);
		click(applyRestriction);
	}

	public void clickAppUninstallBlock() {
		click(blockAppUninstall);
		sleep(500);
		click(applyRestriction);
	}
	
	public void clickDisSmsCb() {
		click(disSmsCb);
		sleep(500);
		click(applyRestriction);
	}
	
	public void resetRestrictions(int i) {
		click(restrictionsPolicy.get(i));
		sleep(500);
		click(applyRestriction);
	}

	
	
	
	
}
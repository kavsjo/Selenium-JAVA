package com.blocket.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePageObject {

	private By addresLink = By.linkText("Addresses");
	
	public AccountPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	public AccountAddressPage clickOnAddressLink() {
		waitAndClick(addresLink);
		return new AccountAddressPage(driver, log);
	}
	

}

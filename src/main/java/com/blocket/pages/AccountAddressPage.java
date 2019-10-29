package com.blocket.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountAddressPage extends BasePageObject {

	private By deleteButton = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div/div[2]/input[2]");
	private By addNewButton = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[2]/input");
	
	
	public AccountAddressPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	public void clickDelete() {
		log.info("Clicking on delete button");
		waitAndClick(deleteButton);
	}

	public void  acceptAlert() {
		log.info("Switching to alert and pressing Ok");
		Alert alert = switchToAlert();
		alert.accept();
	}
	
	public AddNewAddressPage clickAddNewButton() {
		log.info("Clicking on delete button");
		waitAndClick(addNewButton);
		return new AddNewAddressPage(driver, log);
	}
	
	public boolean isDeleteButtonVisible() {
		log.info("is it visible");
		return find(deleteButton).isDisplayed();
	}
	
}

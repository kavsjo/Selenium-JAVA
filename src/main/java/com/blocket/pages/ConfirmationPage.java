package com.blocket.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage extends BasePageObject {

	private By successMessage = By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/div[1]/strong");
	private By clickForOrderDetails = By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/ul/li[2]/a");
	
	
	public ConfirmationPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	public String getSuccesText() {
		log.info("getting success message");
		String message = find(successMessage).getText();
		log.info("Result text: " + message);
		return message;
	}
	
	public String getOrderDetailsLinkText() {
		log.info("getting order detail text");
		String message = find(clickForOrderDetails).getText();
		log.info("Result text: " + message);
		return message;
	}
	
	public void waitForSuccesMessageLocator() {
		waitForVisibilityOf(successMessage, 3);
	}

}

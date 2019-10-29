package com.blocket.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ApparelAndShoesPage extends BasePageObject{
	
	private String pageUrl = "http://demowebshop.tricentis.com/apparel-shoes";
	
	private By blueJeansLink = By.linkText("Blue Jeans");
	
	public ApparelAndShoesPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	public void openPageUrl() {
		log.info("Opening page: " + pageUrl);
		openUrl(pageUrl);
		log.info("Page opened!");
	}

	public BlueJeansPage clickOnBlueJeans() {
		log.info("Clicking on Blue Jeans");
		waitAndClick(blueJeansLink);
		return new BlueJeansPage(driver, log);
	}
	

}

package com.blocket.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StartPage extends BasePageObject{
	
	private String pageUrl = "http://demowebshop.tricentis.com/";
	
	
	private By apparelShoesLink = By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[4]/a");
	private By accountPageLink = By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a");
	private By loginLink = By.linkText("Log in");
	private By logOutButton = By.linkText("Log out");
	
	public StartPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	public void openPageUrl() {
		log.info("Opening page: " + pageUrl);
		openUrl(pageUrl);
		log.info("Page opened!");
	}

	public LoginPage pressLoginLink() {
		waitAndClick(loginLink);
		return new LoginPage(driver, log);
	}
	
	public ApparelAndShoesPage pressAppShoeLink() {
		waitAndClick(apparelShoesLink);
		return new ApparelAndShoesPage(driver, log);
	}
	public AccountPage goToAccountPage() {
		log.info("Clicking on member link");
		waitAndClick(accountPageLink);
		return new AccountPage(driver, log);
	}
	
	public boolean isLogOutButtonVisibile() {
		return find(logOutButton).isDisplayed();
	}

}

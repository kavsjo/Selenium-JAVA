package com.blocket.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePageObject {
	private String pageUrl = "http://demowebshop.tricentis.com/login";
	
	private By emailInputField = By.id("Email");
	private By passwordInputField = By.id("Password");
	private By logInButton = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input");
	private By invalidCredMessage = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[1]");
	
	public LoginPage (WebDriver driver, Logger log) {
		super(driver, log);
	}
	public void openPageUrl() {
		log.info("Opening page: " + pageUrl);
		openUrl(pageUrl);
		log.info("Page opened!");
	}
	
	public StartPage login(String username, String password) {
		log.info("Executing LogIn with username [" + username + "] and password [" + password + "]");
		type(username, emailInputField);
		type(password, passwordInputField);
		waitAndClick(logInButton);
		return new StartPage(driver, log);
	}
	
	public void invalidLogIn(String username, String password) {
		log.info("Executing Valid LogIn with username [" + username + "] and password [" + password + "]");
		type(username, emailInputField);
		type(password, passwordInputField);
		waitAndClick(logInButton);
	}
	
	public String getLoginErrorMessage() {
		return find(invalidCredMessage).getText();
	}
	
	public void waitForErrorMessage() {
		waitForVisibilityOf(invalidCredMessage, 5);
	}
	
}

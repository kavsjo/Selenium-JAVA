package com.blocket.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ShoppingCartPage extends BasePageObject{

	private By countrySelectMenu = By.id("CountryId");
	private By checkoutButton = By.id("checkout");
	private By termsOfServiceCheckbox = By.id("termsofservice");
	
	public ShoppingCartPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	public void selectCountry(int i) {
		log.info("Selecting " + i + " from country menu");
		WebElement dropdownElement = find(countrySelectMenu);
		Select countrySelectMenu = new Select(dropdownElement);
		countrySelectMenu.selectByValue("" + i);
	}
	
	public CheckOutPage clickCheckoutButton() {
		log.info("Clicking checkout button");
		waitAndClick(checkoutButton);
		return new CheckOutPage(driver, log);
	}
	
	public void clickOnTermsOfService() {
		log.info("Clicking terms of service checkbox");
		waitAndClick(termsOfServiceCheckbox);
	}

	
}

package com.blocket.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlueJeansPage extends BasePageObject{

	private By qtyLink = By.id("addtocart_36_EnteredQuantity");
	private By addToCartButton = By.id("add-to-cart-button-36");
	private By shoppingCartLink = By.linkText("Shopping cart");
	
	public BlueJeansPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	public void selectingQuantiy(String quantity) {
		log.info("Executing with a quantity of [" + quantity + "]");
		type(quantity, qtyLink );
		waitAndClick(addToCartButton);
	}
	
	public ShoppingCartPage clickShoppingCart() {
		log.info("Navigating to shopping cart");
		waitAndClick(shoppingCartLink);
		return new ShoppingCartPage(driver, log);
	}
}

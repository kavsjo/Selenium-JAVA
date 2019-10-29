package com.blocket.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends BasePageObject{
	private By selectBillingMessage = By.xpath("//*[@id=\"checkout-billing-load\"]/div/div[1]/label");
	private By accountPageLink = By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a");
	private By billingAddressMenuLink = By.xpath("//*[@id=\"billing-address-select\"]");
	private By companyField = By.id("BillingNewAddress_Company");
	private By selectCountryMenu = By.id("BillingNewAddress_CountryId");
	private By cityNameField = By.id("BillingNewAddress_City");
	private By adressFieldOne = By.id("BillingNewAddress_Address1");
	private By adressFieldTwo = By.id("BillingNewAddress_Address2");
	private By zipCodeField = By.id("BillingNewAddress_ZipPostalCode");
	private By phoneNumberField = By.id("BillingNewAddress_PhoneNumber");
	private By firstContinueButton = By.xpath("//*[@id=\"billing-buttons-container\"]/input");
	private By secondContinueButton = By.xpath("//*[@id=\"shipping-buttons-container\"]/input");
	private By thirdContinueButton = By.xpath("//*[@id=\"shipping-method-buttons-container\"]/input");
	private By fourthContinueButton = By.xpath("//*[@id=\"payment-method-buttons-container\"]/input");
	private By fifthContinueButton = By.xpath("//*[@id=\"payment-info-buttons-container\"]/input");
	private By confirmButton = By.xpath("//*[@id=\"confirm-order-buttons-container\"]/input");
	private By nextDayAirCheckBox = By.id("shippingoption_1");
	private By creditCardCheckBox = By.id("paymentmethod_2");
	private By creditCardMenu = By.id("CreditCardType");
	private By cardholderNameField = By.id("CardholderName");
	private By cardNumberField = By.id("CardNumber");
	private By expireMonthMenu = By.id("ExpireMonth");
	private By expirationYearMenu = By.xpath("//*[@id=\"ExpireYear\"]");
	private By cvvCodeField = By.id("CardCode");
	
	public CheckOutPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	public AccountPage goToAccountPage() {
		log.info("Clicking on member link");
		waitAndClick(accountPageLink);
		return new AccountPage(driver, log);
	}
	
	public String getBillingText() {
		log.info("Getting Select billing message");
		waitForVisibilityOf(selectBillingMessage, 3);
		String message = find(selectBillingMessage).getText();
		log.info("Result text: " + message);
		return message;
	}
	
	public void selectBillingAdress(String i) {
		log.info("Selecting " + i + " option");
		waitForVisibilityOf(billingAddressMenuLink, 3);
		WebElement selectElement = find(billingAddressMenuLink);
		Select billingAddressMenuLink = new Select(selectElement);
		billingAddressMenuLink.selectByValue("" + i);
	}

	public void selectCountry(int i) {
		log.info("Selecting " + i + " from country menu");
		WebElement dropdownElement = find(selectCountryMenu);
		Select selectCountryMenu = new Select(dropdownElement);
		selectCountryMenu.selectByValue("" + i);
	}
	
	public void clickFirstContinue() {
		waitAndClick(firstContinueButton);
	}
	
	public void fillInCheckoutForm(String company, String city, String address1, String address2, String zip, String phoneNumber) {
		log.info("Filling in Checkout form");
		type(company, companyField);
		type(city, cityNameField);
		type(address1, adressFieldOne);
		type(address2, adressFieldTwo);
		type(zip, zipCodeField);
		type(phoneNumber, phoneNumberField);
		waitAndClick(firstContinueButton);
	}
	
	public void clickSecondContinue() {
		log.info("Clicking on second continue");
		waitAndClick(secondContinueButton);
	}
	
	public void checkNextDayAirShipping() {
		log.info("Picking Next Day Air Shipping");
		waitAndClick(nextDayAirCheckBox);
		waitAndClick(thirdContinueButton);
	}
	
	public void checkCreditCardPayment() {
		log.info("Picking Credit Card as payment method");
		waitAndClick(creditCardCheckBox);
		waitAndClick(fourthContinueButton);
	}
	
	public void selectCreditCard(String cardType) {
		log.info("Selecting " + cardType + " card menu");
		waitForVisibilityOf(creditCardMenu, 3);
		WebElement dropdownElement = find(creditCardMenu);
		Select creditCardMenu = new Select(dropdownElement);
		creditCardMenu.selectByValue(cardType);
	}
	
	public void selectExpirationMonth(String month) {
		log.info("Picking expire Month");
		WebElement dropdownElement = find(expireMonthMenu);
		Select expireMonthMenu = new Select(dropdownElement);
		expireMonthMenu.selectByValue("" + month);
	}
	
	public void selectExpirationYear(String year) {
		log.info("Picking expire year");
		WebElement dropdownElement = find(expirationYearMenu);
		Select expirationYearMenu = new Select(dropdownElement);
		expirationYearMenu.selectByValue("" + year);
	}
	
	public void fillInCardInfo(String cardholderName, String cardNumber, String cvvCode) {
		log.info("Filling in rest of the card credentials"); 
		type(cardholderName, cardholderNameField);
		type(cardNumber, cardNumberField);
		type(cvvCode, cvvCodeField);
		waitAndClick(fifthContinueButton);
	}
	
	public ConfirmationPage clickConfirmOrder() {
		log.info("Clicking on confirm");
		waitAndClick(confirmButton);
		return new ConfirmationPage(driver, log);
	}
	
}

package com.blocket.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddNewAddressPage extends BasePageObject {

	private By firstNameField = By.id("Address_FirstName");
	private By lastNameField = By.id("Address_LastName");
	private By emailField = By.id("Address_Email");
	private By companyField = By.id("Address_Company"); 
	private By cityNameField = By.id("Address_City");
	private By addressFieldOne = By.id("Address_Address1");
	private By addressFieldTwo = By.id("Address_Address2");
	private By zipCodeField = By.id("Address_ZipPostalCode");
	private By phoneNumberField = By.id("Address_PhoneNumber");
	private By saveButton = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/form/div/div[2]/div[2]/input");
	private By selectCountryMenu = By.id("Address_CountryId");
	
	public AddNewAddressPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	public void selectCountry(int i) {
		log.info("Selecting " + i + " from country menu");
		WebElement dropdownElement = find(selectCountryMenu);
		Select selectCountryMenu = new Select(dropdownElement);
		selectCountryMenu.selectByValue("" + i);
	}
	
	public void fillInCheckoutForm(String firstName, String lastName, String email, String company, String city, String adress1, String adress2, String zip, String phoneNumber) {
		log.info("Filling in Checkout form");
		
		type(firstName, firstNameField);
		type(lastName, lastNameField);
		type(email, emailField);
		type(company, companyField);
		type(city, cityNameField);
		type(adress1, addressFieldOne);
		type(adress2, addressFieldTwo);
		type(zip, zipCodeField);
		type(phoneNumber, phoneNumberField);
	}
	
	public AccountAddressPage goBackTo() {
		log.info("Going back to address page");
		waitAndClick(saveButton);
		return new AccountAddressPage(driver,log);
	}
}

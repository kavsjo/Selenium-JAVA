package com.blocket.uitest;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.blocket.base.BaseTest;
import com.blocket.pages.AccountAddressPage;
import com.blocket.pages.AccountPage;
import com.blocket.pages.AddNewAddressPage;
import com.blocket.pages.ApparelAndShoesPage;
import com.blocket.pages.BlueJeansPage;
import com.blocket.pages.CheckOutPage;
import com.blocket.pages.ConfirmationPage;
import com.blocket.pages.LoginPage;
import com.blocket.pages.ShoppingCartPage;
import com.blocket.pages.StartPage;
import com.blocket.base.DataProviders;;

public class OrderBlueJeansE2E extends BaseTest {
	
	
	
	@Test(dataProvider = "csvReader", dataProviderClass = DataProviders.class)
	public void E2EOrderBlueJeans(Map<String, String> testData) {
		String no = testData.get("no");
		String username = testData.get("username");
		String password = testData.get("password");
		String company = testData.get("company");
		String city  = testData.get("city");
		String address1 = testData.get("address1");
		String address2 = testData.get("address2");
		String zip = testData.get("zip");
		String phoneNumber = testData.get("phoneNumber");
		String cardholderName = testData.get("cardholderName");
		String creditcard = testData.get("creditcard");
		String expireMonth = testData.get("expireMonth");
		String expireYear = testData.get("expireYear");
		String cardNumber = testData.get("cardNumber");
		String cvvCode = testData.get("cvvCode");
		String billingMessage = testData.get("billingMessage");
		String expectedOrderMessage = testData.get("expectedOrderMessage");
		String expectedSuccesMessage = testData.get("expectedSuccesMessage");
	
		
		log.info("Starting E2EOrderBlueJeans test" + no);

		StartPage startPage = new StartPage(driver, log);
		startPage.openPageUrl();
		
		LoginPage loginPage = startPage.pressLoginLink();
		StartPage loggedIn = loginPage.login(username, password);
		
		ApparelAndShoesPage appShoesPage = loggedIn.pressAppShoeLink();
	
		BlueJeansPage blueJeansPage = appShoesPage.clickOnBlueJeans();
		blueJeansPage.selectingQuantiy("2");
		
		ShoppingCartPage shoppingCartPage = blueJeansPage.clickShoppingCart();
		shoppingCartPage.selectCountry(73);
		shoppingCartPage.clickOnTermsOfService();
		
		CheckOutPage checkOutPage = shoppingCartPage.clickCheckoutButton();
		try {
			String billingText = checkOutPage.getBillingText();
			if (billingText.contentEquals(billingMessage)) {
				checkOutPage.clickFirstContinue();
				}
			
		} catch (Exception e) {
				checkOutPage.selectCountry(73);
				checkOutPage.fillInCheckoutForm(company, city, address1, address2, zip, phoneNumber);
				checkOutPage.clickFirstContinue();
		}

		checkOutPage.clickSecondContinue();
		checkOutPage.checkNextDayAirShipping();
		checkOutPage.checkCreditCardPayment();
		log.info(creditcard);
		checkOutPage.selectCreditCard(creditcard);
		checkOutPage.selectExpirationMonth(expireMonth);
		checkOutPage.selectExpirationYear(expireYear);
		checkOutPage.fillInCardInfo(cardholderName, cardNumber, cvvCode);
		
		ConfirmationPage confirmPage = checkOutPage.clickConfirmOrder();
		confirmPage.waitForSuccesMessageLocator();
		String successMessage = confirmPage.getSuccesText();
		String orderDetailMessage = confirmPage.getOrderDetailsLinkText();
		
		Assert.assertTrue(successMessage.contains(expectedSuccesMessage),
				"It should have been " + expectedSuccesMessage + " but it was " + successMessage + "!");
		Assert.assertTrue(orderDetailMessage.contains(expectedOrderMessage),
				"It should have been " + expectedOrderMessage + " but it was " + orderDetailMessage + "!");
		
	}
	
	@Test(dataProvider = "csvReader", dataProviderClass = DataProviders.class)
	public void LoginAnnDeleteAddNewAddress (Map<String, String> testData) {
		
		String firstname = testData.get("firstname");
		String lastname = testData.get("lastname");
		String username = testData.get("username");
		String password = testData.get("password");
		String company = testData.get("company");
		String city  = testData.get("city");
		String address1 = testData.get("address1");
		String address2 = testData.get("address2");
		String zip = testData.get("zip");
		String phoneNumber = testData.get("phoneNumber");
		String succesMessage = testData.get("succesMessage");
		
		LoginPage loginPage = new LoginPage(driver, log);
		loginPage.openPageUrl();
		
		StartPage loggedIn = loginPage.login(username, password);
		
		AccountPage accountPage = loggedIn.goToAccountPage();
		
		AccountAddressPage addressPage = accountPage.clickOnAddressLink();
		try {
				while(addressPage.isDeleteButtonVisible()) {
				addressPage.clickDelete();
				addressPage.acceptAlert();
				}
				AddNewAddressPage addNewAddress = addressPage.clickAddNewButton();
				addNewAddress.selectCountry(73);
				addNewAddress.fillInCheckoutForm(firstname, lastname, username, company, city, address1, address2, zip, phoneNumber);

				AccountAddressPage newAddressCheck = addNewAddress.goBackTo();
				Assert.assertTrue(newAddressCheck.isDeleteButtonVisible(), succesMessage);
			

		} catch (Exception e) {
			AddNewAddressPage addNewAddress = addressPage.clickAddNewButton();
			addNewAddress.selectCountry(73);
			addNewAddress.fillInCheckoutForm(firstname, lastname, username, company, city, address1, address2, zip, phoneNumber);
			
			AccountAddressPage newAddressCheck = addNewAddress.goBackTo();
			Assert.assertTrue(newAddressCheck.isDeleteButtonVisible(), succesMessage);
		}
	}
	
}

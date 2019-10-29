package com.blocket.uitest;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.blocket.base.BaseTest;
import com.blocket.base.DataProviders;
import com.blocket.pages.LoginPage;
import com.blocket.pages.StartPage;


public class LoginTest extends BaseTest {
	@Test(dataProvider = "csvReader", dataProviderClass = DataProviders.class)
	public void validLoginTest(Map<String, String> testData) {
		
		String username = testData.get("username");
		String password = testData.get("password");
		
		StartPage startPage = new StartPage(driver, log);
		startPage.openPageUrl();
		
		LoginPage loginPage = startPage.pressLoginLink();
		
		StartPage loggedIn = loginPage.login(username, password);
		
		Assert.assertTrue(loggedIn.isLogOutButtonVisibile());
		
		}	
	 
	@Test(dataProvider = "csvReader", dataProviderClass = DataProviders.class)
	public void invalidLoginTest(Map<String, String> testData) {
		
		String invalidUsername = testData.get("username");
		String invalidPassword = testData.get("password");
		String expectedMessage = testData.get("message");
		
		StartPage startPage = new StartPage(driver, log);
		startPage.openPageUrl();
		
		LoginPage loginPage = startPage.pressLoginLink();
		loginPage.invalidLogIn(invalidUsername, invalidPassword);
		
		loginPage.waitForErrorMessage();
		String message = loginPage.getLoginErrorMessage();
		
		Assert.assertTrue(message.contains(expectedMessage), "Message was wrong");
	}
	

}



		
		
		

		
		
		


package com.blocket.uitest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.blocket.base.BaseTest;
import com.blocket.pages.LoginPage;
import com.blocket.pages.StartPage;


public class LoginTest extends BaseTest {
	@Test
	public void validLoginTest(){
		StartPage startPage = new StartPage(driver, log);
		startPage.openPageUrl();
		
		LoginPage loginPage = startPage.pressLoginLink();
		
		StartPage loggedIn = loginPage.login("landa@hotmail.com", "landa1234");
		
		Assert.assertTrue(loggedIn.isLogOutButtonVisibile());
		
		}	
	 
	@Test
	public void invalidLoginTest() {
		StartPage startPage = new StartPage(driver, log);
		startPage.openPageUrl();
		
		LoginPage loginPage = startPage.pressLoginLink();
		loginPage.invalidLogIn("invalid@hotmail.com", "BadPassword");
		
		loginPage.waitForErrorMessage();
		String message = loginPage.getLoginErrorMessage();
		
		String expectedMessage = "Login was unsuccessful. Please correct the errors and try again.";
		
		Assert.assertTrue(message.contains(expectedMessage), "Message was wrong");
	
	}
	

}



		
		
		

		
		
		


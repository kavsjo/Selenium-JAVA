package com.blocket.uitest;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.opera.OperaDriver;

import org.testng.annotations.Test;

import com.blocket.base.BaseTest;

public class demo extends BaseTest{
 @Test
public void createAccount(){


//set system property, so that we can access opera driver
System.setProperty("webdriver.opera.driver", "src/main/resources/operadriver.exe");
// it will open the opera browser
WebDriver driver = new OperaDriver();
driver.get("https://www.google.com/intl/en/mail/help/about.html");


 }
}

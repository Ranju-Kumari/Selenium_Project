package com.mercurytoursflights.pagemethods;

import org.openqa.selenium.WebDriver;
import com.mercurytoursflights.pageobjects.LoginPageConstants;

/**
 * @author M1049131 Purpose: Methods to access the locators and by using these
 *         methods, sending the inputs to the application for login purpose
 *
 */

public class LoginPageMethods extends LoginPageConstants{
	
	public LoginPageMethods(WebDriver driver) {
		super(driver);
	}

	public void setUserName(String uname) {
		username.sendKeys(uname);
	}

	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}

	public void clickOnSignIn() {
		signIn.click();
	}

}

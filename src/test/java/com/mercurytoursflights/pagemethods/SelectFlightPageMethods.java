package com.mercurytoursflights.pagemethods;

import org.openqa.selenium.WebDriver;
import com.mercurytoursflights.pageobjects.SelectFlightPageConstants;

/**
 * @author M1049131 Purpose: Methods to access the locators to select the flight
 *
 */

public class SelectFlightPageMethods extends SelectFlightPageConstants {

	public SelectFlightPageMethods(WebDriver driver) {
		super(driver);
		
	}
	public void clickOnDepartureFlight() {
		departFlight.click();
	}

	public void clickOnReturnFlight() {
		returnFlight.click();
	}

	public void clickOnContinue() {
		clickOnContinue.click();
	}

}

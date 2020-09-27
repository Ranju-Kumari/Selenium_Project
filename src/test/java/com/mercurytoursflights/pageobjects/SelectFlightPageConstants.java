package com.mercurytoursflights.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * @author M1049131 Purpose: Locators for select flight
 *
 */

public class SelectFlightPageConstants {

	public WebDriver driver;

	public SelectFlightPageConstants(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 100);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='outFlight' and @value='Blue Skies Airlines$361$271$7:10']")
	@CacheLookup
	protected WebElement departFlight;

	@FindBy(xpath = "//input[@name='inFlight' and @value='Blue Skies Airlines$631$273$14:30']")
	@CacheLookup
	protected WebElement returnFlight;

	@FindBy(xpath = "//input[@name='reserveFlights']")
	@CacheLookup
	protected WebElement clickOnContinue;

}

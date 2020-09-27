package com.mercurytoursflights.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * @author M1049131 Purpose: Locators for flight details
 *
 */

public class FlightDetailsPageConstants {

	public WebDriver driver;

	public FlightDetailsPageConstants(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 100);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@value='roundtrip']")
	@CacheLookup
	protected WebElement tripType;

	@FindBy(name = "passCount")
	@CacheLookup
	protected WebElement noOfPassengers;

	@FindBy(name = "fromPort")
	@CacheLookup
	protected WebElement departingFrom;

	@FindBy(name = "fromMonth")
	@CacheLookup
	protected WebElement onMonth;

	@FindBy(name = "fromDay")
	@CacheLookup
	protected WebElement onDay;

	@FindBy(name = "toPort")
	@CacheLookup
	protected WebElement arrivingIn;

	@FindBy(name = "toMonth")
	@CacheLookup
	protected WebElement returningOnMonth;

	@FindBy(name = "toDay")
	@CacheLookup
	protected WebElement returningOnDay;

	@FindBy(xpath = "//input[@value='Business']")
	@CacheLookup
	protected WebElement serviceClass;

	@FindBy(name = "airline")
	@CacheLookup
	protected WebElement airline;

	@FindBy(xpath = "//input[@name='findFlights']")
	@CacheLookup
	protected WebElement FindFlights;
}

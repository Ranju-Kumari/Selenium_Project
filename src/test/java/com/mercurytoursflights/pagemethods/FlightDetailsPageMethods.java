package com.mercurytoursflights.pagemethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import com.mercurytoursflights.pageobjects.FlightDetailsPageConstants;

/**
 * @author M1049131 purpose: Methods to access locators and to book return
 *         ticket, inputs fetched from excel sheet and sending to the 
 *         application.
 *
 */

public class FlightDetailsPageMethods extends FlightDetailsPageConstants {

	public FlightDetailsPageMethods(WebDriver driver) {
		super(driver);
		
	}
	public void clickOnTypeOfTrip() {
		tripType.click();
	}

	public void selectNoOfPassengers(String noOfPassenger) {
		Select passengers = new Select(noOfPassengers);
		passengers.selectByVisibleText(noOfPassenger);
	}

	public void selectDepartingFlightFrom(String departureFlightDestination) {
		Select departingFlight = new Select(departingFrom);
		departingFlight.selectByVisibleText(departureFlightDestination);
	}

	public void selectDepartingOnMonth(String month) {
		Select departingOnMonth = new Select(onMonth);
		departingOnMonth.selectByVisibleText(month);
	}

	public void selectDepartingOnDay(String day) {
		Select departingOnDay = new Select(onDay);
		departingOnDay.selectByVisibleText(day);
	}

	public void selectArrivingFlightIn(String arrivingDestination) {
		Select arriving = new Select(arrivingIn);
		arriving.selectByVisibleText(arrivingDestination);
	}

	public void selectArrivingOnMonth(String arriveMonth) {
		Select arrivingMonth = new Select(returningOnMonth);
		arrivingMonth.selectByVisibleText(arriveMonth);
	}

	public void selectArrivingOnDate(String arriveDate) {
		Select arrivingDate = new Select(returningOnDay);
		arrivingDate.selectByVisibleText(arriveDate);
	}

	public void clickOnServiceClass() {
		serviceClass.click();
	}

	public void selectAirline(String airLine) {
		Select FlightNo = new Select(airline);
		FlightNo.selectByVisibleText(airLine);
	}

	public void clickOnFindFlights() {
		FindFlights.click();
	}

}

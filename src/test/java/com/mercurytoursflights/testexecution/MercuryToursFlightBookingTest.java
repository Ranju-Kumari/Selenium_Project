package com.mercurytoursflights.testexecution;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.mercurytoursflights.pagemethods.FlightDetailsPageMethods;
import com.mercurytoursflights.pagemethods.LoginPageMethods;
import com.mercurytoursflights.pagemethods.SelectFlightPageMethods;
import com.mercurytoursflights.pageobjects.LoginPageConstants;
import com.mercurytoursflights.reusuablecomponents.Driver;
import com.mercurytoursflights.utility.ConfigProperty;
import com.mercurytoursflights.utility.Log;

public class MercuryToursFlightBookingTest extends Driver {
	public MercuryToursFlightBookingTest() {
		super();
	}
	String userName = "";
	String password = "";
	@BeforeMethod
	public void openBrowser() {	
		url = ConfigProperty.prop.getProperty("webUrl");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	@Test(dataProvider = "FlightBookingDetailsData", priority = 0)
	public void flightBooking(String noOfPassengers, String departFrom, String departMonth, String departDate,
							String arrivingIn, String arrivingMonth, String arrivingDay, String airline) {
		LoginPageMethods login=new LoginPageMethods(driver);
		FlightDetailsPageMethods flightDetails=new FlightDetailsPageMethods(driver);
		SelectFlightPageMethods selectFlight=new SelectFlightPageMethods(driver);
		 userName = ConfigProperty.prop.getProperty("userName");
		 password = ConfigProperty.prop.getProperty("password");
		result.add("Test Case-1: Booking Return Ticket in Demoaut Application");
		result.add("Step-1 : LOGIN INTO THE APPLICATION");
		Log.info("Demoaut application opened successfully");
		login.setUserName(userName);
		Log.info("Enter UserName ");
		login.setPassword(password);
		Log.info("Enter Password");
		result.add("(1) Successfully entered userName and Password");
		login.clickOnSignIn();
		Log.info("Successfully logged into the demoaut application");
		result.add("(2) Successfully logged into the demoaut application");
		result.add("Step-2 :BOOKING A FLIGHT");
		Log.info("Book a Flight");
		flightDetails.clickOnTypeOfTrip();
		Log.info("Type of trip Selected");
		result.add("(1) Type of trip Selected");
		flightDetails.selectNoOfPassengers(noOfPassengers);
		Log.info("Number of passengers Selected");
		result.add("(2) Number of passengers Selected");
		flightDetails.selectDepartingFlightFrom(departFrom);
		Log.info("Departure flight destination Selected");
		result.add("(3) Departure flight destination Selected");
		flightDetails.selectDepartingOnMonth(departMonth);
		Log.info("Departure Fligh month Selected");
		result.add("(4) Departure Fligh month Selected");
		flightDetails.selectDepartingOnDay(departDate);
		Log.info("Departure Flight date selected");
		result.add("(5) Departure Flight date selected");
		flightDetails.selectArrivingFlightIn(arrivingIn);
		Log.info("Selected Arrival flight destination");
		result.add("(6) Selected Arrival flight destination");
		flightDetails.selectArrivingOnMonth(arrivingMonth);
		Log.info("Selected arrivaing Flight month");
		result.add("(7) Selected arrivaing Flight month");
		flightDetails.selectArrivingOnDate(arrivingDay);
		Log.info("Selected arriving flight day");
		result.add("(8) Selected arriving flight day");
		flightDetails.clickOnServiceClass();
		Log.info("Clicked on the sevice class--business");
		result.add("(9) Clicked on the sevice class--business");
		flightDetails.selectAirline(airline);
		Log.info("Selected the airline");
		result.add("(10) Selected the airline");
		flightDetails.clickOnFindFlights();
		Log.info("Clicked on find flights button");
		result.add("(11) Clicked on find flights button");
		Log.info(" Select a Flight");
		result.add("Step-3 :  SELECT A FLIGHT");
		selectFlight.clickOnDepartureFlight();
		Log.info("clicke on departure flight");
		result.add("(1) clicke on departure flight");
		selectFlight.clickOnReturnFlight();
		Log.info("Clicked on Return Flight");
		result.add("(2) Clicked on Return Flight");
		selectFlight.clickOnContinue();
		Log.info("Clicked on continue");
		result.add("(3) Clicked on continue");		
	}
	@Test( priority = 1)
	public void validateUserCredentials() {
		result.add("Test Case-2 : Validating User Credentials");
		userName = ConfigProperty.prop.getProperty("userName");
		System.out.println(userName);
		password = ConfigProperty.prop.getProperty("password");
		System.out.println(password);
		LoginPageConstants login = new LoginPageConstants(driver);
		LoginPageMethods loginMethods = new LoginPageMethods(driver);
		Log.info("Checking Whether user name field is exists or not");
		result.add("Checking Whether user name field is exists or not");

		try {
			WebElement userNameTxtBox = login.username;
			Log.info("USER NAME FIELD EXISTS");
			result.add("Step-1 : USER NAME FIELD EXISTS");
			Log.info("Enter the valid user name");
			userNameTxtBox.sendKeys(userName);
			Log.info("User name entered successfully");
			result.add("(1) User name entered successfully");
		} catch (Exception e) {
			Log.warn("Email Id field doesn't exists");
		}
		Log.info("Checking whether password field exists or not");
		result.add("Checking whether password field exists or not");

		try {
			WebElement passwordTxtBox = login.password;
			Log.info("Checking Password Field Exists or not");
			result.add("Step-2 : Checking Password Field Exists or not");
			Log.info("Enter valid password");
			passwordTxtBox.sendKeys(password);
			Log.info("Password Entered successfully");
			result.add("(2) Password Entered successfully");
		} catch (Exception e) {
			Log.warn("Password Field doesn't exists");
		}

		loginMethods.clickOnSignIn();
		Log.info("Clicked on Sign in");
		result.add("Step-3 : Clicked on Sign in");
		Log.info("User logged into the application successfully");
		result.add("Step-4 : User logged into the application successfully");		
	}
	@AfterMethod
	public void closeBrowser() {
		driver.close();		
	}
}

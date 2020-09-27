package com.mercurytoursflights.reusuablecomponents;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.mercurytoursflights.utility.ConfigProperty;
import com.mercurytoursflights.utility.PdfGenerate;
import com.mercurytoursflights.utility.ReadExcel;
import com.mercurytoursflights.utility.SendMail;

/**
 * @author M1049131 
 * Purpose: Definied methods for opening browser and closing
 *        	 browser.
 *
 */

public class Driver {
	
	public static WebDriver driver;
	ConfigProperty config;
	String driverPath = "";
	protected String url = "";
	PdfGenerate PdfUtility;
	protected List<String> result;

	public Driver() {
		super();
	}

	@BeforeSuite
	public void exectutionStarted() {
		System.out.println("Demo Aut application Started");
		config = new ConfigProperty();
		driverPath = ConfigProperty.prop.getProperty("driverPath");		
		PdfUtility = new PdfGenerate();
		result = new ArrayList<String>();
		System.setProperty("webdriver.chrome.driver", driverPath);
	}

	@AfterSuite
	public void endOfExecution() throws IOException, COSVisitorException {
		System.out.println("Execution Completed");
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());		
		result.add("Test Ends: " + timeStamp);	
		PdfUtility.writeTestResultsToPdfFile("./pdfreports/TestResultReport.pdf", result);		
		try {
			SendMail.send();
		} catch (IOException | MessagingException e) {
			e.printStackTrace();
		}
	}
	
	@BeforeClass
	public void beforeClass1()
	{
		System.out.println("Before Class");
	}
	@AfterClass
	public void afterClass1()
	{
		System.out.println("After Class");
	}
	@BeforeTest
	public void beforeTest1()
	{
		System.out.println("Before Test");
	}
	@AfterTest
	public void afterTest1()
	{
		System.out.println("After Test");
	}
	// DataProvider to read the excel sheet inputs and sending into the application.
	@DataProvider(name = "FlightBookingDetailsData")
	public Object[][] getData() throws Exception {
		String path =  ConfigProperty.prop.getProperty("excelPath");
		System.out.println(path);
		int rowNum = ReadExcel.getRowCount(path, "FlightDetails");
		int colNum = ReadExcel.getCellCount(path, "FlightDetails", 1);
		Object loginData[][] = new Object[rowNum][colNum];

		for (int i = 1; i <= rowNum; i++) {
			for (int j = 0; j < colNum; j++) {
				loginData[i - 1][j] = ReadExcel.getCellData(path, "FlightDetails", i, j);
			}
		}

		return loginData;
	}

}
